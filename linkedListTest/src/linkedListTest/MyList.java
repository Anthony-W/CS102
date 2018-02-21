package linkedListTest;

public class MyList<Item> {
	protected MyNode<Item> head = null;
	protected MyNode<Item> tail = null;
	
	public MyList() {
		head = new MyNode<Item>(null);
		tail = new MyNode<Item>(head);
	}
	
	void add(Item c) {
		/*if (c instanceof Comparable) {
			MyNode<Item> current = head.next;
			Comparable C = (Comparable)c;
			while (current != tail) {
				int comparison = C.compareTo((Comparable)current.data);
			}
		}
		else
		{*/
			new MyNode<Item>(c, head);
		//}
		
	}
	
	Item pop() {
		MyNode node = head.next;
		head.next = node.next;
		return (Item) node.data;
	}
	
	int size() {
		int size = 0;
		MyNode<Item> current = head.next;
		
		while(current != tail) {
			size++;
			current = current.next;
		}
		return size;
	}
	
	@Override
	public String toString() {
		String output = "[ ";
		MyNode<Item> current = head.next;
		
		while(current != tail) {
			output += current.data.toString();
			output += ", ";
			current = current.next;
		}
		output = output.substring(0,output.length()-2);
		return output + " ]";
	}
}
