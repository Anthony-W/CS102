package linkedListTest;

public class MyList<Item>
{
	private Node head = null;
	private Node tail = null;

	private class Node
	{
		private Item _item;
		private Node _next;

		private Node(Item item)
		{
			_item = item;
			_next = null;
		}
	}

	public MyList()
	{
		head = new Node(null);
		tail = new Node(null);
		head._next = tail;
	}

	public void add(Item c)
	{
		Node newNode = new Node(c);
		newNode._next = head._next;
		head._next = newNode;
	}

	public Item pop()
	{
		Node node = head._next;
		head._next = node._next;
		return (Item) node._item;
	}

	public int size()
	{
		int size = 0;
		Node current = head._next;

		while (current != tail)
		{
			size++;
			current = current._next;
		}
		return size;
	}

	public boolean contains(Item item)
	{
		Node current = head._next;
		
		while (current != tail)
		{
			if (current._item.equals(item)) return true;
			current = current._next;
		}
		
		return false;
	}

/*
	public boolean contains(Item item)
	{
		return contains(item, head._next);
	}
	
	private boolean contains(Item item, Node node)
	{
		if (node == tail) return false;
		else if (node._item.equals(item)) return true;
		else return contains(item, node._next);
	}
*/
	@Override
	public String toString()
	{
		String output = "[ ";
		Node current = head._next;

		while (current != tail)
		{
			output += current._item;
			current = current._next;
			if (current != tail)
				output += ", ";
		}
		return output + " ]";
	}
}
