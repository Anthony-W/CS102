package reversal;

import java.util.LinkedList;
import java.util.Queue;

public class QueueReversal implements ReverseString
{
    public String reverse(String s)
    {
    	if (s.length() == 0) return s;
    	
        Queue<Character> queue = new LinkedList<Character>();
        
        for (int i = 0; i < s.length(); i++)
        {
        	queue.add(s.charAt(s.length()-(i+1)));
        }
        
        String result = "";
        for (int i = 0; i < s.length(); i++)
        {
        	result += queue.remove();
        }
        
        return result;
    }
}
