import java.util.Queue;
import java.util.LinkedList;


public class QueueDataStructure {
    public static void main(String args[])
    {
    Queue<Integer> q= new LinkedList<>();

    for(int i=1;i<=5;i++)
    {
        q.add(i);
    }

    // q.size()
    System.out.println(q.size());

    // q.peek();

    System.out.println(q.peek());

    // q.remove() removes first element and returns it
    System.out.println(q.remove());

    System.out.println(q);

    
    }
}
