import java.util.ArrayList;

public class MyCollection
{
	ArrayList<Object> list = new ArrayList<Object>();
	
	public boolean add(Object o)
	{
		if (o == null) return false;
		if (o.equals(this)) return false;
		if (o.getClass().equals(Tainted.class)) return false;
		
		list.add(o);
		return true;
	}
	
}
