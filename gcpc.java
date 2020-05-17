//id: gcpc

class Node{

    private Node leftChild,rightChild,parent;
    private int[] data=new int[3]; //{groupNumber, total problem solved, total penalties acquired}
    private int height, rank; //Rank stores total number of nodes on its left and right trees

    public Node(int groupNumber, int totalSolves, int penalties){
        data[0]=groupNumber;
        data[1]=totalSolves;
        data[2]=penalties;

        height=0;
        rank=0;
    }


    //This is to replace the data in a node with node n. Used in deleteGroup func
    public void replaceNode(Node n){
        int newGroup=n.groupNumber();
        int newSolves=n.solves();
        int newP=n.penalties();
        setGroup(newGroup);
        setSolves(newSolves);
        setPenalties(newP);
    }

    //Check if its the same group
    public boolean isEqual(Node n){return n.groupNumber()==data[0];}

    //setters
    public void setRightChild(Node n){ rightChild=n;}
    public void setLeftChild(Node n){ leftChild=n;}
    public void setParent(Node n){parent=n;}
    
    public void setHeight(int h){height=h;}
    public void setRank(int r){rank=r;}

    private void setGroup(int n){data[0]=n;}
    private void setSolves(int n){data[1]=n;}
    private void setPenalties(int n){data[2]=n;}

    //getters
    public int getHeight(){return height;}
    public int getRank(){return rank;}

    public int groupNumber(){return data[0];}
    public int solves(){return data[1];}
    public int penalties(){return data[2];}

    public Node rightChild(){return rightChild;}
    public Node leftChild(){return leftChild;}
    public Node parent(){return parent;}
}

class AVLTree{ //A very specific and annoying sort of AVL tree

    Node root;

    //Keeps track of all groups currently in the AVL tree, and their solves&penalties
    //Nodes itself is NOT stored inside
    int[][] groups;

    public AVLTree(int g){
        root=null;
        groups=new int[g+1][2];
    }

    //Get height and rank of Node n
    public int getHeight(Node n){
        if (n==null){return -1;}
        return n.getHeight();
    }

    public int getRank(Node n){
        if (n==null){return -1;}
        return n.getRank();
    }

    //setters
    public void setRank(Node n){
        int right=getRank(n.rightChild())+1;
        int left=getRank(n.leftChild())+1;
        n.setRank(right+left);
    }

    public void setHeight(Node n){
        int newHeight=Math.max(getHeight(n.leftChild()),getHeight(n.rightChild()))+1;
        n.setHeight(newHeight);
    }

    //comparison func
    public boolean isGreater(Node a, Node b){ //b is the node being inserted
        int aNumber=a.groupNumber();
        int aSolves=a.solves();
        int aPenalties=a.penalties();

        int bNumber=b.groupNumber();
        int bSolves=b.solves();
        int bPenalties=b.penalties();

        if (bSolves>aSolves){return true;} //b has more solves
        if (bSolves==aSolves && bPenalties<aPenalties){return true;} //Equal solves, but b has less penalties
        if (bSolves==aSolves && bPenalties==aPenalties && bNumber<aNumber){return true;} //Exactly equal, we want group 1 to be infront
        return false; //b is smaller or equal to
    }

    public void insert(Node n){
        int groupNumber=n.groupNumber();
        int solves=n.solves();
        int penalty=n.penalties();
        int[] helper={solves,penalty};
        groups[groupNumber]=helper;

        insert(root, n);
    }

    public void insert(Node n, Node newNode){       
        if (root==null){root=newNode; return;} //empty tree

        if (!isGreater(n,newNode)){ //Pushing to left tree
            if (n.leftChild()==null){
                n.setLeftChild(newNode);
                newNode.setParent(n);
            }

            else{
                insert(n.leftChild(),newNode);
            }
        }

        else{ //push to right tree
            if (n.rightChild()==null){
                n.setRightChild(newNode);
                newNode.setParent(n);
            }

            else{
                insert(n.rightChild(),newNode);
            }
        }

        setHeight(n);
        setRank(n);
        balanceTree(n);
    }

    public void balanceTree(Node n){
        if (n==null){return;}

        int leftHeight=getHeight(n.leftChild());
        int rightHeight=getHeight(n.rightChild());
        int diff=leftHeight-rightHeight;

        if (-1<=diff && diff<=1){return;} //Tree doesn't need to be rebalanced

        if (diff>1){ //left side skewed
            if ( getHeight(n.leftChild().leftChild() ) >getHeight( n.leftChild().rightChild() ) ){ //straight line
                rotateRight(n);
            }

            else{
                rotateLeftThenRight(n); //Zigzag line
            }
        }

        else{ //right side skewed
            if ( getHeight( n.rightChild().rightChild() ) > getHeight( n.rightChild().leftChild() ) ){ //straight line
                rotateLeft(n);
            }

            else{
                rotateRightThenLeft(n); //zigzag line
            }
        }

        setHeight(n);
        setRank(n);
    }

    public void rotateRight(Node n){
        Node parent, leftChild, rightChildOfLeft;
        
        parent=n.parent();
        leftChild=n.leftChild();
        rightChildOfLeft=leftChild.rightChild();

        n.setParent(leftChild);
        n.setLeftChild(rightChildOfLeft);

        if (rightChildOfLeft!=null){rightChildOfLeft.setParent(n);}
 
        leftChild.setRightChild(n);

        if (parent==null){ //Root node
            root=leftChild;
            leftChild.setParent(null);
        }

        else{
            if (parent.leftChild()!=null && parent.leftChild().isEqual(n)){
                parent.setLeftChild(leftChild);
            }

            else{
                parent.setRightChild(leftChild);
            }

            leftChild.setParent(parent);

        }

        setHeight(n);
        setRank(n);
        setHeight(leftChild);
        setRank(leftChild);
    }

    public void rotateLeft(Node n){

        Node parent,rightChild, leftChildOfRight;

        parent=n.parent();
        rightChild=n.rightChild();
        leftChildOfRight=rightChild.leftChild();

        n.setParent(rightChild);
        n.setRightChild(leftChildOfRight);

        if (leftChildOfRight!=null){leftChildOfRight.setParent(n);}

        rightChild.setLeftChild(n);

        if (parent==null){
            //root node
            root=rightChild;
            rightChild.setParent(null);
        }

        else{
            if (parent.leftChild()!=null && parent.leftChild().isEqual(n)){
                parent.setLeftChild(rightChild);
            }

            else{
                parent.setRightChild(rightChild);
            }
            rightChild.setParent(parent);
        }

        setHeight(n);
        setRank(n);
        setHeight(rightChild);
        setRank(rightChild);
    }

    public void rotateRightThenLeft(Node n){
        rotateRight(n.rightChild());
        rotateLeft(n);
    }

    public void rotateLeftThenRight(Node n){
        rotateLeft(n.leftChild());
        rotateRight(n);
    }

    public Node search(int groupNumber){
        if (groups[groupNumber][0]==0){return null;}
        Node groupNode=new Node(groupNumber, groups[groupNumber][0],groups[groupNumber][1]);
        return search(root, groupNode);
    }

    public Node search(Node n, Node groupNode){
        if (n==null){return null;}

        if (n.groupNumber()==groupNode.groupNumber()){
            return n;
        }

        else if (isGreater(n,groupNode)){
            return search(n.rightChild(),groupNode);
        }

        else{
            return search(n.leftChild(), groupNode);
        }

    }

    public boolean isLeaf(Node n){return (n.rightChild()==null && n.leftChild()==null);}

    public Node predecessor(Node n){
        n=n.leftChild();
        if(n==null){return n;}

        while (n.rightChild()!=null){
            n=n.rightChild();
        }

        return n;
    }

    public Node successor(Node n){
        n=n.rightChild();
        if(n==null){return n;}

        while(n.leftChild()!=null){
            n=n.leftChild();
        }

        return n;
    }



    public void deleteGroup(int groupNumber){

        if (groups[groupNumber][0]==0){return;}

        Node groupNode=search(groupNumber);
        Node parent=groupNode.parent();

        deleteGroup(groupNode);
        balanceTree(parent);
    }

    public void deleteGroup(Node groupNode){
        if (groupNode==null){return;}

        int groupNumber=groupNode.groupNumber();
        groups[groupNumber][0]=0; //Deleting of node from arr
        groups[groupNumber][1]=0;

        if (groupNode.isEqual(root)){

            Node succ;

            if (root.rightChild()!=null) { succ=successor(root);}
            else if (root.leftChild()!=null) { succ=predecessor(root);}

            else{ root=null; return; }

            deleteGroup(succ);
            groupNode.replaceNode(succ);

            int[] helper={succ.solves(),succ.penalties()};

            groups[succ.groupNumber()]=helper;
            return;
        }

        //Other cases
        Node parent=groupNode.parent();

        if (isLeaf(groupNode)){
            if (parent.leftChild()!=null && parent.leftChild().isEqual(groupNode)){
                parent.setLeftChild(null);
            }

            else if(parent.rightChild().isEqual(groupNode)){
                parent.setRightChild(null);
            }
            
            Node origParent=parent;
            while (parent!=null){
                setHeight(parent);
                setRank(parent);
                parent=parent.parent();
            }
            
            groupNode.setParent(null);
            balanceTree(origParent);
        }

        //If one side is empty
        else if(groupNode.rightChild()==null || groupNode.leftChild()==null){

            //Left tree is the NOT empty one
            if (groupNode.leftChild()!=null){
                if (parent.leftChild()!=null && parent.leftChild().isEqual(groupNode)){
                    parent.setLeftChild(groupNode.leftChild());
                    groupNode.leftChild().setParent(parent);
                }

                else{
                    parent.setRightChild(groupNode.leftChild());
                    groupNode.leftChild().setParent(parent);
                }
            }

            //Right tree is the NOT empty one
            else if(groupNode.rightChild()!=null){
                if (parent.leftChild()!=null && parent.leftChild().isEqual(groupNode)){
                    parent.setLeftChild(groupNode.rightChild());
                    groupNode.rightChild().setParent(parent);
                }

                else{
                    parent.setRightChild(groupNode.rightChild());
                    groupNode.rightChild().setParent(parent);
                }
            }

            Node origParent=parent;
            
            while (parent!=null){
                setHeight(parent);
                setRank(parent);
                parent=parent.parent();
            }
            
            balanceTree(origParent);
        }

        else{
            
            Node succ=successor(groupNode);
            int[] helper={succ.solves(),succ.penalties()};
            deleteGroup(succ);
            setHeight(parent);
            setRank(parent);
            groups[succ.groupNumber()]=helper;
            groupNode.replaceNode(succ);
        }
    }





    public int placing(int groupNumber){
        int totalNodes=getRank(root)+1;

        if (groups[groupNumber][0]==0){
            return totalNodes+1; //If node is not inside tree, then all nodes in tree are higher than group 1
        }

        Node groupNode=search(groupNumber);

        if (root.isEqual(groupNode)){ //If its the root node, everone on the right is better
            return getRank(root.rightChild())+1 +1; // +1 to count the right child itself, +1 for placement. i.e 4th if 3 Nodes in right tree
        }

        //groupNode lies somewhere in the left tree
        if (!isGreater(root,groupNode)){
            Node parent=groupNode.parent();
            Node helper=groupNode;
            int smallerCount=getRank(groupNode.leftChild())+1;
            while (!parent.isEqual(root)){
                if (parent.rightChild()!=null && parent.rightChild().isEqual(helper)){
                    smallerCount+=getRank(parent.leftChild())+1+1; //+1 for leftChild, +1 for parentNode
                }
                helper=parent;
                parent=parent.parent();
            }

            return totalNodes-smallerCount;
        }

        //groupNode lies somewhere in the right tree
        else{
            Node parent=groupNode.parent();
            Node helper=groupNode;
            int largerCount=getRank(groupNode.rightChild())+1;

            while (!parent.isEqual(root)){

                if (parent.leftChild()!=null && parent.leftChild().isEqual(helper)){
                    largerCount+=getRank(parent.rightChild())+1 +1; //+1 for right Child, +1 for parent node
                }
                helper=parent;
                parent=parent.parent();
            }

            return largerCount+1;
        }
    }
}



class gcpc{
    public static void main(String[] args){

        Kattio input=new Kattio();

        int teams=input.getInt();
        int events=input.getInt();
        AVLTree tree=new AVLTree(teams);
        
        for (int i=0;i<events;i++){
            int groupNumber=input.getInt();
            int solves=1;
            int penalty=input.getInt();

            Node groupNode=tree.search(groupNumber);

            if (groupNode!=null){
                solves=groupNode.solves()+1;
                penalty+=groupNode.penalties();
                tree.deleteGroup(groupNode);
            }
            
            Node helper=new Node(groupNumber,solves,penalty);
            tree.insert(helper);
            int currPlacing=tree.placing(1);
            input.println(currPlacing);
        }
            
        input.flush();
    }
}
