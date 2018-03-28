/******************************************************************************
 *  Compilation:  javac DoublyLinkedList.java
 *  Execution:    java DoublyLinkedList
 *  Dependencies: StdOut.java
 *
 *  A list implemented with a doubly linked list. The elements are stored
 *  (and iterated over) in the same order that they are inserted.
 * 
 *  % java DoublyLinkedList 10
 *  10 random integers between 0 and 99
 *  24 65 2 39 86 24 50 47 13 4 
 *
 *  add 1 to each element via next() and set()
 *  25 66 3 40 87 25 51 48 14 5 
 *
 *  multiply each element by 3 via previous() and set()
 *  75 198 9 120 261 75 153 144 42 15 
 *
 *  remove elements that are a multiple of 4 via next() and remove()
 *  75 198 9 261 75 153 42 15 
 *
 *  remove elements that are even via previous() and remove()
 *  75 9 261 75 153 15 
 *
 ******************************************************************************/

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<Item> implements Iterable<Item> {
    //private int n;        // number of elements on list
    private Node<Item> pre;     // sentinel before first item
    private Node<Item> post;    // sentinel after last item

    public DoublyLinkedList() {
        pre  = new Node<Item>();
        post = new Node<Item>();
        pre.next = post;
        post.prev = pre;
    }

    // linked list node helper data type
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
        private Node<Item> prev;
    }

    public boolean isEmpty()    { return size() == 0; }
    
    public int size()          
    {
    	Node<Item> current = pre.next;
    	int size = 0;
    	while (current != post)
    	{
    		size++;
    		current = current.next;
    	}
    	return size;
    }

    // add the item to the list
    public void add(Item item) {
        Node<Item> last = post.prev;
        Node<Item> x = new Node<Item>();
        x.item = item;
        x.next = post;
        x.prev = last;
        post.prev = x;
        last.next = x;
    }
    
    

    public ListIterator<Item> iterator(int i)  { return new DoublyLinkedListIterator(i); }
    public ListIterator<Item> begin()  { return iterator(0); }
    public ListIterator<Item> end()  { return iterator(size()); }
    public ListIterator<Item> iterator()  { return begin(); }

    // assumes no calls to DoublyLinkedList.add() during iteration
    private class DoublyLinkedListIterator implements ListIterator<Item> {
        private Node<Item> current;  // the node that is returned by next()
        private Node<Item> lastAccessed = null;      // the last node to be returned by prev() or next()
                                               // reset to null upon intervening remove() or add()
        private int index;
        
        public DoublyLinkedListIterator()
        {
        	this(0);
        }
        
        public DoublyLinkedListIterator(int index)
        {
        	if (index < 0 || index > size()) throw new IndexOutOfBoundsException(index + " is not a valid index in this list.");
        	
        	this.current = pre;
        	for (int i = 0; i <= index; i++)
        	{
        		current = current.next;
        	}
        	this.index = index;
        }

        public boolean hasNext()      { return index < size(); }
        public boolean hasPrevious()  { return index > 0; }
        public int previousIndex()    { return index - 1; }
        public int nextIndex()        { return index;     }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            lastAccessed = current;
            Item item = (Item) current.item;
            current = current.next; 
            index++;
            return item;
        }

        public Item previous() {
            if (!hasPrevious()) throw new NoSuchElementException();
            current = current.prev;
            index--;
            lastAccessed = current;
            return current.item;
        }

        // replace the item of the element that was last accessed by next() or previous()
        // condition: no calls to remove() or add() after last call to next() or previous()
        public void set(Item item) {
            if (lastAccessed == null) throw new IllegalStateException();
            lastAccessed.item = item;
        }

        // remove the element that was last accessed by next() or previous()
        // condition: no calls to remove() or add() after last call to next() or previous()
        public void remove() { 
            if (lastAccessed == null) throw new IllegalStateException();
            Node<Item> x = lastAccessed.prev;
            Node<Item> y = lastAccessed.next;
            x.next = y;
            y.prev = x;
            if (current == lastAccessed)
                current = y;
            else
                index--;
            lastAccessed = null;
        }

        // add element to list 
        public void add(Item item) {
            Node<Item> x = current.prev;
            Node<Item> y = new Node<Item>();
            Node<Item> z = current;
            y.item = item;
            x.next = y;
            y.next = z;
            z.prev = y;
            y.prev = x;
            index++;
            lastAccessed = null;
        }
        
        public int size()
        {
        	return DoublyLinkedList.this.size();
        }

    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }

    // a test client
    public static void main(String[] args) {
        //int n  = Integer.parseInt(args[0]);
    	int n=10;
    	
        // add elements 1, ..., n
        StdOut.println(n + " random integers between 0 and 99");
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        for (int i = 0; i < n; i++)
            list.add(StdRandom.uniform(100));
        StdOut.println(list);
        StdOut.println();

        ListIterator<Integer> iterator = list.iterator();

        // go forwards with next() and set()
        StdOut.println("add 1 to each element via next() and set()");
        while (iterator.hasNext()) {
            int x = iterator.next();
            iterator.set(x + 1);
        }
        StdOut.println(list);
        StdOut.println();

        // go backwards with previous() and set()
        StdOut.println("multiply each element by 3 via previous() and set()");
        while (iterator.hasPrevious()) {
            int x = iterator.previous();
            iterator.set(x + x + x);
        }
        StdOut.println(list);
        StdOut.println();


        // remove all elements that are multiples of 4 via next() and remove()
        StdOut.println("remove elements that are a multiple of 4 via next() and remove()");
        while (iterator.hasNext()) {
            int x = iterator.next();
            if (x % 4 == 0) iterator.remove();
        }
        StdOut.println(list);
        StdOut.println();


        // remove all even elements via previous() and remove()
        StdOut.println("remove elements that are even via previous() and remove()");
        while (iterator.hasPrevious()) {
            int x = iterator.previous();
            if (x % 2 == 0) iterator.remove();
        }
        StdOut.println(list);
        StdOut.println();


        // add elements via next() and add()
        StdOut.println("add elements via next() and add()");
        while (iterator.hasNext()) {
            int x = iterator.next();
            iterator.add(x + 1);
        }
        StdOut.println(list);
        StdOut.println();

        // add elements via previous() and add()
        StdOut.println("add elements via previous() and add()");
        while (iterator.hasPrevious()) {
            int x = iterator.previous();
            iterator.add(x * 10);
            iterator.previous();
        }
        StdOut.println(list);
        StdOut.println();
    }
}