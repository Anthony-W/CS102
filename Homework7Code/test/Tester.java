import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import org.junit.Test;

public class Tester
{

	@Test
	public void testEqualQueues()
	{
		//initialize queues and random number generator
		Queue<Integer> queue = new LinkedList<Integer>();
		Queue<Integer> queue2 = new LinkedList<Integer>();
		Random rng = new Random();
		
		//check that empty queues are equal
		assertTrue(Main.equalQueues(queue, queue2));
		
		//check two equal queues
		boolean flag;
		int next;
		for (int i = 0; i < 10; i++)
		{
			//add a new random number to queue
			next = rng.nextInt(200);
			queue.add(next);
			queue2.add(next);
			
			//check for equality
			flag = Main.equalQueues(queue, queue2);
			if (!flag)
			{
				System.out.println(queue);
				System.out.println(queue2);
			}
			assertTrue(flag);
			
		}
		
		//empty the queues
		queue.clear();
		queue2.clear();
		
		//check unequal queues
		queue.add(0);
		assertFalse(Main.equalQueues(queue, queue2));

		queue2.add(1);
		assertFalse(Main.equalQueues(queue, queue2));
		
		queue2.add(0);
		assertFalse(Main.equalQueues(queue, queue2));
		
		queue.add(1);
		assertFalse(Main.equalQueues(queue, queue2));
	}

}
