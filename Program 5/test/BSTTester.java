import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.List;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

public class BSTTester
{
	final int ARRAY_SIZE = 10;
	
	BST[] trees;
	int[][] pre, post, in;
	boolean[] symmetric;
	int[] imbalance;
	
	@Before
	public void setUp() throws Exception
	{
		trees = new BST[ARRAY_SIZE];
		pre = new int[ARRAY_SIZE][8];
		post = new int[ARRAY_SIZE][8];
		in = new int[ARRAY_SIZE][8];
		symmetric = new boolean[ARRAY_SIZE];
		imbalance = new int[ARRAY_SIZE];
		
		
		trees[0] = new BST();
		trees[0].put(0, 0);
		pre[0][0] = 0;
		post[0][0] = 0;
		in[0][0] = 0;
		symmetric[0] = true;
		imbalance[0] = 0;
		
		trees[1] = new BST();
		trees[1].put(0, 0);
		trees[1].put(1, 1);
		pre[1][0] = 0;
		pre[1][1] = 1;
		post[1][0] = 1;
		post[1][1] = 0;
		in[1][0] = 0;
		in[1][1] = 1;
		symmetric[1] = false;
		imbalance[1] = 1;
		
		trees[2] = new BST();
		trees[2].put(1, 1);
		trees[2].put(0, 0);
		pre[2][0] = 1;
		pre[2][1] = 0;
		post[2][0] = 0;
		post[2][1] = 1;
		in[2][0] = 0;
		in[2][1] = 1;
		symmetric[2] = false;
		imbalance[2] = 1;
		
		trees[3] = new BST();
		trees[3].put(1, 1);
		trees[3].put(0, 0);
		trees[3].put(2, 2);
		pre[3][0] = 1;
		pre[3][1] = 0;
		pre[3][2] = 2;
		post[3][0] = 0;
		post[3][1] = 2;
		post[3][2] = 1;
		in[3][0] = 0;
		in[3][1] = 1;
		in[3][2] = 2;
		symmetric[3] = true;
		imbalance[3] = 0;
		
		trees[4] = new BST();
		trees[4].put(0, 0);
		trees[4].put(1, 1);
		trees[4].put(2, 2);
		pre[4][0] = 0;
		pre[4][1] = 1;
		pre[4][2] = 2;
		post[4][0] = 2;
		post[4][1] = 1;
		post[4][2] = 0;
		in[4][0] = 0;
		in[4][1] = 1;
		in[4][2] = 2;
		symmetric[4] = false;
		imbalance[4] = 2;
		
		trees[5] = new BST();
		trees[5].put(2, 2);
		trees[5].put(1, 1);
		trees[5].put(0, 0);
		pre[5][0] = 2;
		pre[5][1] = 1;
		pre[5][2] = 0;
		post[5][0] = 0;
		post[5][1] = 1;
		post[5][2] = 2;
		in[5][0] = 0;
		in[5][1] = 1;
		in[5][2] = 2;
		symmetric[5] = false;
		imbalance[5] = 2;
		
		trees[6] = new BST();
		trees[6].put(3, 3);
		trees[6].put(1, 1);
		trees[6].put(2, 2);
		trees[6].put(0, 0);
		pre[6][0] = 3;
		pre[6][1] = 1;
		pre[6][2] = 0;
		pre[6][3] = 2;
		post[6][0] = 0;
		post[6][1] = 2;
		post[6][2] = 1;
		post[6][3] = 3;
		in[6][0] = 0;
		in[6][1] = 1;
		in[6][2] = 2;
		in[6][3] = 3;
		symmetric[6] = false;
		imbalance[6] = 2;
		
		trees[7] = new BST();
		trees[7].put(0, 0);
		trees[7].put(2, 2);
		trees[7].put(1, 1);
		trees[7].put(3, 3);
		pre[7][0] = 0;
		pre[7][1] = 2;
		pre[7][2] = 1;
		pre[7][3] = 3;
		post[7][0] = 1;
		post[7][1] = 3;
		post[7][2] = 2;
		post[7][3] = 0;
		in[7][0] = 0;
		in[7][1] = 1;
		in[7][2] = 2;
		in[7][3] = 3;
		symmetric[7] = false;
		imbalance[7] = 2;
		
		trees[8] = new BST();
		trees[8].put(3, 3);
		trees[8].put(1, 1);
		trees[8].put(5, 5);
		trees[8].put(0, 0);
		trees[8].put(2, 2);
		trees[8].put(4, 4);
		trees[8].put(6, 6);
		pre[8][0] = 3;
		pre[8][1] = 1;
		pre[8][2] = 0;
		pre[8][3] = 2;
		pre[8][4] = 5;
		pre[8][5] = 4;
		pre[8][6] = 6;
		post[8][0] = 0;
		post[8][1] = 2;
		post[8][2] = 1;
		post[8][3] = 4;
		post[8][4] = 6;
		post[8][5] = 5;
		post[8][6] = 3;
		in[8][0] = 0;
		in[8][1] = 1;
		in[8][2] = 2;
		in[8][3] = 3;
		in[8][4] = 4;
		in[8][5] = 5;
		in[8][6] = 6;
		symmetric[8] = true;
		imbalance[8] = 0;
		
		trees[9] = new BST();
		trees[9].put(3, 3);
		trees[9].put(1, 1);
		trees[9].put(5, 5);
		trees[9].put(0, 0);
		trees[9].put(2, 2);
		trees[9].put(4, 4);
		pre[9][0] = 3;
		pre[9][1] = 1;
		pre[9][2] = 0;
		pre[9][3] = 2;
		pre[9][4] = 5;
		pre[9][5] = 4;
		post[9][0] = 0;
		post[9][1] = 2;
		post[9][2] = 1;
		post[9][3] = 4;
		post[9][4] = 5;
		post[9][5] = 3;
		in[9][0] = 0;
		in[9][1] = 1;
		in[9][2] = 2;
		in[9][3] = 3;
		in[9][4] = 4;
		in[9][5] = 5;
		symmetric[9] = false;
		imbalance[9] = 1;
	}

	@Test
	public void test()
	{	
		testPreOrder();
		testPostOrder();
		testInOrder();
		testIsSymmetric();
		testMaxImbalance();
		testReverse();
	}
	
	private void checkPre(int i)
	{
		Iterable<Integer> list = trees[i].preOrder();
		int count = 0;
		for (Integer j : list)
		{
			assertTrue(j.equals(pre[i][count++]));
		}
	}
	
	private void checkPost(int i)
	{
		Iterable<Integer> list = trees[i].postOrder();
		int count = 0;
		for (Integer j : list)
		{
			assertTrue(j.equals(post[i][count++]));
		}
	}
	
	private void checkIn(int i)
	{
		Iterable<Integer> list = trees[i].inOrder();
		int count = 0;
		for (Integer j : list)
		{
			assertTrue(j.equals(in[i][count++]));
		}
	}
	
	private void testPreOrder()
	{
		for (int i = 0; i < ARRAY_SIZE; i++)
		{
			checkPre(i);
		}
	}
	
	private void testPostOrder()
	{
		for (int i = 0; i < ARRAY_SIZE; i++)
		{
			checkPost(i);
		}
	}
	
	private void testInOrder()
	{
		for (int i = 0; i < ARRAY_SIZE; i++)
		{
			checkIn(i);
		}
	}
	
	
	private void testIsSymmetric()
	{
		for (int i = 0; i < ARRAY_SIZE; i++)
		{
			assertEquals(trees[i].isSymmetric(), symmetric[i]);
		}
	}
	
	
	private void testMaxImbalance()
	{
		for (int i = 0; i < ARRAY_SIZE; i++)
		{
			assertEquals(trees[i].maxImbalance(), imbalance[i]);
		}
	}
	
	private void testReverse()
	{
		for (int i = 0; i < ARRAY_SIZE; i++)
		{
			testReverse(trees[i]);
		}
	}
	
	private void testReverse(BST tree)
	{
		Iterable<Integer> inOrder = tree.inOrder();
		
		BST reversedTree = tree.reverse();
		
		Iterable<Integer> reversed = reversedTree.inOrder();
		
		Stack<Integer> reverser = new Stack<Integer>();
		Queue<Integer> actualReversed = new Queue<Integer>();
		
		for (Integer i : inOrder)
		{
			reverser.push(i);
		}
		while (!reverser.isEmpty())
		{
			actualReversed.enqueue(reverser.pop());
		}
		
		assertEquals(reversed.toString(), actualReversed.toString());
	}

}
