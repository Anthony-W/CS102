package linkedListTest;

public class MyNode<Item> {
	Item data;
	MyNode next = null;
	
	public MyNode(Item data, MyNode previous) {
		this.data = data;
		next = previous.next;
		previous.next = this;
	}
	
	public MyNode(MyNode previous) {
		if (previous != null) previous.next = this;
		data = null;
	}
}
