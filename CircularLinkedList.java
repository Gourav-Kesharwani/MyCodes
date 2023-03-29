public class CircularLinkedList {
        class Node{
            int data;
            Node next;
    
            Node(int data)
            {
                this.data=data;
                this.next=null;
            }
        }
    
        public Node tail;
        public Node head;
        int  size=0;




        void addLast(int data)
        {
            //step 1 creating a node
            Node newNode=new Node(data);
            if(head==null)
            {
                head=tail=newNode;
                size=1;
                return;
            }
    
            //step2 inserting node at last
            tail.next=newNode;
            size++;
            //step3 making new tail as newNode
            tail=newNode;
            tail.next=head;
        }
        public static void main(String []args)
        {
            CircularLinkedList l=new CircularLinkedList();
            for(int i=0;i<4;i++)
            {
                l.addLast(i);
            }

            for(int i=0;i<4;i++)
            {
                System.out.println(l.head);
            }

        }
    
    
}
