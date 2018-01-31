package reversal;

public class RecursiveReversal implements ReverseString{
	public String reverse(String s)
    {
		if (s.length() == 0) return s;
		
        char last = s.charAt(s.length()-1);
        s = s.substring(0, s.length()-1);
        
        return last + reverse(s);
    }
}
