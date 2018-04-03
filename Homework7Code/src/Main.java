import java.util.LinkedList;
import java.util.Queue;

public class Main
{
	static private Queue<Integer> queue = new LinkedList<Integer>();
	static private Queue<Integer> queue2 = new LinkedList<Integer>();
	static private int start = 0, end = 0, CAPACITY = 0;
	
	public static void main(String[] args)
	{
		queue.add(100);
		queue.add(150);
		queue2.add(100);
		queue2.add(150);
		System.out.println(equalQueues(queue, queue2));
	}

	public static <T extends Comparable<T>> boolean equalQueues(Queue<T> first, Queue<T> second)
	{
		if (first.size() != second.size()) return false;
		
		int size = first.size();
		boolean equal = true;
		
		for (int i = 0; i < size; i++)
		{
			if (!first.peek().equals(second.peek())) equal = false;
			
			first.add(second.remove());
			second.add(first.remove());
		}
		
		return equal;
	}
	
	public static int size()
	{
		return (end - start > 0 ? end - start : CAPACITY - (end - start));
	}
}
