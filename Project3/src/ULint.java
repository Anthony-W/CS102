import java.util.ListIterator;

public class ULint implements Comparable<ULint>
{
    protected DoublyLinkedList<Integer> _rep;


    /**
     * Stores integer values in two  from largest place to smallest place:
     *      38456351 is stored as:  head 3 8 4 5 6 3 5 1 tail
     *      @throws NumberFormatException if the input integer is negative.
     */
    public ULint(int value) throws NumberFormatException
    {
    	_rep = new DoublyLinkedList<Integer>();
    	
    	value = reverseInt(value);
    	while (value > 0)
    	{
    		_rep.add(value % 10);
    		value /= 10;
    	}
    }
    
    /**
     * reverses the digits of an integer
     * @param num starting number
     * @return reversed number
     */
    private int reverseInt(int num)
    {
    	int reversed = 0;
    	int lastDigit;
    	while (num > 0)
    	{
    		lastDigit = num % 10;
    		reversed = reversed*10 + lastDigit;
    		num /= 10;
    	}
    	return reversed;
    }

    /**
     * Compares this object with the specified object for order.
     * @param that -- another unsigned arbitrary length integer
     * @return a negative integer, zero, or a positive integer as this object
     *         is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(ULint that)
    {
    	DoublyLinkedList thatList = that._rep;
    	if (_rep.size() > thatList.size()) return 1;
    	if (_rep.size() < thatList.size()) return -1;
    	
    	ListIterator itThis = _rep.end();
    	ListIterator itThat = thatList.end();
    	
    	while(itThis.hasPrevious())
    	{
    		Integer thisCurrent = (Integer) itThis.previous();
    		Integer thatCurrent = (Integer) itThat.previous();

    		int result = thisCurrent.compareTo(thatCurrent);
    		
    		if (result != 0) return result;
    	}
    	
    	return 0;
    }

    /**
     * @return the value of this object as an int.
     * @throws NumberFormatException according to Integer.parseInt
     */
    public int intValue() throws NumberFormatException
    {
    	return Integer.parseInt(toString());
    }
    
    /**
     * @return a string-based representation of this object as an integer.
     */
    @Override
    public String toString()
    {
    	String result = "";
    	for(Integer i : _rep)
    		result += i;
    	return result;
    }

    /**
     * @param obj -- some object
     * @return {@code true} if obj is an ULint and equates (==) to this.
     */
    @Override
    public boolean equals(Object obj)
    {
    	if (!(obj instanceof ULint)) return false;
    	
    	ULint other = (ULint) obj;
    	DoublyLinkedList<Integer> otherList = other._rep;
    	if (_rep.size() != otherList.size()) return false;
    	
    	ListIterator itThis = _rep.end();
    	ListIterator itOther = otherList.end();
    	
    	while(itThis.hasPrevious())
    	{
    		if (!itThis.previous().equals(itOther.previous())) return false;
    	}
    	
    	return true;
    }
}