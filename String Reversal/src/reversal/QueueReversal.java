/**
 * This class implements the reverse method using
 * a queue/ArrayList
 *
 * @author Anthony Wessel
 * @date   2/12/2018
 */

package reversal;

import java.util.LinkedList;
import java.util.Queue;

public class QueueReversal implements ReverseString
{
    public String reverse(String s)
    {
    	if (s.length() == 0) return s;
    	
        Queue<Character> queue = new LinkedList<Character>();
        
        for (int i = s.length()-1; i >= 0 ; i--)
        {
        	queue.add(s.charAt(i));
        }
        
        String result = "";
        for (int i = 0; i < s.length(); i++)
        {
        	result += queue.remove();
        }
        
        return result;
    }
}
