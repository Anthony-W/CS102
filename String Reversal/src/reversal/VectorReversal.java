package reversal;

import java.util.Iterator;
import java.util.Vector;

public class VectorReversal implements ReverseString{

	public String reverse(String str) {
		
		Vector<Character> v = new Vector<Character>();
		
		for (int i = 0; i < str.length(); i++)
		{
			v.add(str.charAt(str.length()-(i+1)));
		}
		
		String result = "";
		Iterator it = v.iterator();
		while (it.hasNext()) {
			result += it.next();
		}
		s
		return result;
	}

}
