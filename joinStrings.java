//id: joinstrings

class joinStrings{
    public static void main(String[] args){

        Kattio input=new Kattio();

        int n=input.getInt();

        LL[] helper=new LL[n];

        for (int i=0;i<n;i++){
            String word=input.getLine();
            helper[i]=new LL(word);
        }

        if (n==1){
            input.print(helper[0].getVar());
            input.flush();
            return;
        }

        LL head=null;

        for (int j=0;j<n-1;j++){

            int first=input.getInt()-1;
            int sec=input.getInt()-1;

            LL current=helper[first];
            head=current;
            current=current.getTail();

            LL second=helper[sec];

            current.setNext(second);
            head.setTail(second.getTail());
        }

        while (head.getNext()!=null){
            input.print(head.getVar());
            head=head.getNext();
        }

        input.print(head.getVar());
        input.flush();
    }
}

class LL{
    public String var;
    public LL next;
    public LL tail;

    public LL(String a){
        var=a;
        next=null;
        tail=this;
    }

    public String getVar(){return var;}
    public LL getNext(){return next;}
    public void setNext(LL item){next=item;}
    public void setTail(LL item){tail=item;}
    public LL getTail(){return tail;}
}
