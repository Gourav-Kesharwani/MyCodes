import java.util.*;
import java.io.*;

public class LinkedList {

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

    void addFirst(int data)
    {
        //step1 creating a node
        Node newNode=new Node(data);

        if(head==null)
        {
            head=tail=newNode;
            
            size=1;
            return;
        }

        //step2 inserting node at head
        newNode.next=head;

        //step 3 making new head
        head=newNode;
        size++;
    }

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
    }

    void printAll()
    {
        if(head==null)
        return;
        System.out.println();
        for(Node temp=head;temp!=null;temp=temp.next)
        {
            System.out.print(temp.data+" ");

        }
        System.out.println();
    }

    void insertMiddle(int index,int data)
    {
        Node newNode=new Node(data);
        if(head==null)
        {
            head=tail=newNode;
            size=1;
            return ;
        }   
        Node temp=head;
        int i=0;
        while(i<index-1){
            temp=temp.next;
            i++; 
        }
        newNode.next=temp.next;
        temp.next=newNode;
    }

    int sizeOfLl()
    {
        return size;
    }

    int removeFirst()
    {
        if(head==null)
        {
            System.out.println("Insert a node first");
            size=0;
            return Integer.MAX_VALUE;
        }
        else if(size==1)
        {
            int val=tail.data;
            head=tail=null;
            size=0;
            return val;
        }

        int val=head.data;
        size--;
        head=head.next;
        return  val;
    }

    int removeLast()
    {
        if(size==0)
        {
            System.out.println("Insert a node first");
            size=0;
            return Integer.MAX_VALUE;
        }
        else if(size==1)
        {
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }

        Node temp=head;

        while(temp.next.next!=null)
        {
            temp=temp.next;
        }
        int val=tail.data;
        
        tail=temp;
        temp.next=null;
        size--;
        return val;
    }

    int iterativeSearch(int key)
    {
        if(head==null)
        {
            System.out.println("Insert a node first");
            return -1;
        }

        Node temp=head;
        int index=-1;
        while(temp!=null)
        {
            index++;
            if(temp.data==key)
            {
                break;
            }
            temp=temp.next;
        }

       
        return index;
        
    }

    int recursiveHelperSearch(Node head,int key)
    {
        if(head==null)
        {
            return -1;
        }
        if(head.data==key)
        return 0;

        int idx=recursiveHelperSearch(head.next, key);

        if(idx==-1)
        return -1;
        return idx+1;
    }
    int recursiveSearch(int key)
    {
        return recursiveHelperSearch(head,key);
    }
    

    void reverseLinkedList(){
        if(head==null)
        {
            System.out.println("Linked list is empty");
            return;
        }
        if(size==1)
        {
            return;
        }

        Node prev=null,next,curr=head;

        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        head=prev;


    }

    int deleteNthFromEnd(int n)
    {
        if(head==null)
        {
            System.out.println("linked list is empty");
            return Integer.MAX_VALUE;
        }

        int siz=0;
        Node temp=head;
        while(temp!=null)
        {
            siz++;
            temp=temp.next;
        }

        if(siz==n){
            int val=head.data;
            head=head.next;
            return val;
        }

        Node prev=head;
        int i=1;

        while(i<(siz-n))
        {
            i++;
            prev=prev.next;
        }
        int val=prev.next.data;
        prev.next=prev.next.next;
        return val;
    }

    //function to check if a ll is a palindrome

    Node midLL()
    {
        //function returns the mid of a linked list
        Node slow=head,fast=head;

        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow; //points to middle
    }

    boolean palindrome()
    {
        if(head==null||head.next==null)
        {
            return true;
        }

        Node mid=midLL();
        Node prev=null,next,curr=mid;

        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        Node left=head,right=prev;

        while(right!=null)
        {
            if(left.data!=right.data)
            {
                return false;
            }
            left=left.next;
            right=right.next;
        }

        return true;

    }



    //cycle in a linked list

    //Floyd's cycle finding algorithm
    boolean detectCycle()
    {
        Node slow=head,fast=head;
        while(fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
            {
                return true;
            }
        }

        return false;
    }

    //removing cycle in a linked list

    void removingCycle()
    {
        Node slow=head,fast=head;
        boolean flag=false;
        //finding whether cycle exists or not

        while(fast!=null&&fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow)
            {
                flag=true;
                break;
            }
        }

        if(flag==false)
        {
            System.out.println("ll does not contain cycle");
            return;
        }

        System.out.println("cycle found");
        //slow =head
        slow=head;
        Node prev=null;
        //slow +1 fast+1
        while(slow!=fast)
        {
            slow=slow.next;
            prev=fast;
            fast=fast.next;
        }
        prev.next=null;
        printAll();

    }


    //merge sort

    public Node getMidNode(Node head)
    {
        Node slow=head,fast=head.next;
        while(fast!=null&&fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }

        return slow;
    }

    public Node merge(Node leftHead,Node rightHead)
    {
        Node mergedLl=new Node(-1);
        Node temp=mergedLl;
        while(leftHead!=null&&rightHead!=null)
        {
            if(leftHead.data<=rightHead.data)
            {
                temp.next=leftHead;
                temp=temp.next;
                leftHead=leftHead.next;
            }
            else
            {
                temp.next=rightHead;
                temp=temp.next;
                rightHead=rightHead.next;
            }
        }
        while(leftHead!=null)
        {
            temp.next=leftHead;
            temp=temp.next;
            leftHead=leftHead.next;
        }
        while(rightHead!=null)
        {
            temp.next=rightHead;
            temp=temp.next;
            rightHead=rightHead.next;
        }


        return mergedLl.next;

    }

    public Node mergeSort(Node head)
    {
        if(head==null||head.next==null)
        {
            return head;
        }

        //get mid of linked list
        Node mid=getMidNode(head);

        Node newRightHead=mid.next;
        Node newLeftHead=head;
        mid.next=null;
        
        //dividing linked list
        mergeSort(newLeftHead);
        mergeSort(newRightHead);

        //merge function
        return merge(newLeftHead,newRightHead);
    }


    //ZIG-ZAG linkedList

    public void zigZagLinkedList(){
        if(head==null&&head.next==null)
        {
            return;
        }

        //finding mid of the linked list
        Node slow=head;
        Node fast=head.next;

        while(fast!=null&& fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }

        // reversing second part
        Node mid=slow;
        Node prev=null,next=null,curr=mid.next;
        mid.next=null;

        while(curr!=null)
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        
        // alternate zig-zag

        Node left=head,right=prev;
        Node nextL,nextR;

        while(left!=null&&right!=null)
        {
            nextL=left.next;
            left.next=right;
            nextR=right.next;
            right.next=nextL;

            left=nextL;
            right=nextR;
        }
    }


    // swapping two given keys

    void swap(int key1,int key2)
    {
        if(head==null||head.next==null)
        {
            return;
        }
        
        Node temp=head;
        Node temp1=null,temp2=null;

        while(temp!=null)
        {
            if(temp.data==key1)
            {
                temp1=temp;
            }
            else if(temp.data==key2)
            {
                temp2=temp;
            }
            temp=temp.next;
        }

        int val=temp1.data;
        temp1.data=temp2.data;
        temp2.data=val;


    }

    // all even values before odd values

    void evenBeforeOdd()
    {
        if(head==null||head.next==null)
        {
            return;
        }
        Node odd=head,even=head;
        int val=0;

        while(even!=null)
        {
            if(even.data%2==0)
            {
                val=odd.data;
                odd.data=even.data;
                even.data=val;
                odd=odd.next;
            }
            even=even.next;
        }
    }

    void segregateEvenOdd(){Node end = head;Node prev = null;Node curr = head;while (end.next != null)end = end.next;Node new_end = end;while (curr.data %2 !=0 && curr != end){new_end.next = curr;curr = curr.next;new_end.next.next = null;new_end = new_end.next;}if (curr.data %2 ==0){head = curr;while (curr != end){if (curr.data % 2 == 0){prev = curr;curr = curr.next;}else{prev.next = curr.next;curr.next = null;new_end.next = curr;
        new_end = curr;curr = prev.next;}}}else prev = curr;if (new_end != end && end.data %2 != 0){prev.next = end.next;end.next = null;new_end.next = end;}}void push(int new_data){Node new_node = new Node(new_data);new_node.next = head;head = new_node;}
    public static void main(String args[])
    {
        LinkedList l1=new LinkedList();
        l1.addFirst(1);
        l1.addFirst(100);
        l1.addFirst(13);
        l1.addFirst(190);
        l1.addFirst(3);
        l1.printAll();
        l1.segregateEvenOdd();
        l1.printAll();
        

    }
    
}
