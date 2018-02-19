package linkedListTest;

public class MyNode {
	char data;
	MyNode next = null;
	
	public MyNode(char data, MyNode previous) {
		this.data = data;
		next = previous.next;
		previous.next = this;
	}
	
	public MyNode() {
		
	}
}
