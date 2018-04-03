import java.util.LinkedList;
import java.util.Queue;

public class Main
{
	static private Queue<Integer> queue = new LinkedList<Integer>();
	static private Queue<Integer> queue2 = new LinkedList<Integer>();
	static private int start = 0, end = 0, CAPACITY = 0;
	
	public static void main(String[] args)
	{
		queue.add(1);
		queue2.add(1);
		System.out.println(equalQueues(queue, queue2));
	}

	public static boolean equalQueues(Queue first, Queue second)
	{
		return (first.equals(second));
	}
	
	public static int size()
	{
		return (end - start > 0 ? end - start : CAPACITY - (end - start));
	}
}
