/**
* This class represents an arbitrarily sized integer
* using a doubly linked list. These integers can be
* compared, but cannot be changed after they are
* constructed
*
* @author Anthony Wessel
* @date 3/28/2018
*/

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
    	//throw exception for negative number
    	if (value < 0) throw new NumberFormatException();
    	
    	//initialize list
    	_rep = new DoublyLinkedList<Integer>();

    	//convert input to string
    	String strValue = Integer.toString(value);
    	
    	//populate list
    	for (int i = 0; i < strValue.length(); i++)
    	{
    		//get the next character as a string
    		String next = Character.toString(strValue.charAt(i));
    		
    		//parse string to an integer and add it to the list
    		_rep.add(Integer.parseInt(next));
    	}
    	
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
    	//get list from parameter
    	DoublyLinkedList thatList = that._rep;
    	
    	//check for different number of digits
    	if (_rep.size() > thatList.size()) return 1;
    	if (_rep.size() < thatList.size()) return -1;
    	
    	//get iterators
    	ListIterator itThis = _rep.begin();
    	ListIterator itThat = thatList.begin();
    	
    	//check each digit individually
    	while(itThis.hasNext())
    	{
    		//get the next digit
    		Integer thisCurrent = (Integer) itThis.next();
    		Integer thatCurrent = (Integer) itThat.next();

    		//compare digits
    		int result = thisCurrent.compareTo(thatCurrent);
    		
    		//if there is a difference, return, otherwise keep looking
    		if (result != 0) return result;
    	}
    	
    	//they are equal
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
    	
    	//add each digit
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
    	//cannot compare ULint to anything that isn't a ULint
    	if (!(obj instanceof ULint)) return false;
    	
    	//cast the input to a ULint
    	ULint other = (ULint) obj;
    	
    	//get the list from the input ULint
    	DoublyLinkedList<Integer> otherList = other._rep;
    	
    	//check for different number of digits
    	if (_rep.size() != otherList.size()) return false;
    	
    	//get iterators
    	ListIterator itThis = _rep.end();
    	ListIterator itOther = otherList.end();
    	
    	//check each digit
    	while(itThis.hasPrevious())
    	{
    		if (!itThis.previous().equals(itOther.previous())) return false;
    	}
    	
    	return true;
    }
}