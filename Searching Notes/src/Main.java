import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(4);
		list.add(7);
		list.add(10);
		list.add(11);
		System.out.println(booleanContains(list, 1));

	}
	
	private static int linearContains(ArrayList<String> list, String target, boolean sorted)
	{
		for (int i = 0; i < list.size(); i++)
		{
			if (target.equals(list.get(i))) return i;
			
			if (sorted && target.compareTo(list.get(i)) == -1)
			{
				return -1;			}
		}
		
		return -1;
	}
	
	private static int booleanContains(ArrayList<Integer> list, Integer target)
	{
		int min = 0;
		int max = list.size() - 1;
		int mid = (min+max)/2;
		
		
		while(min <= mid) {
			
			int comparison = list.get(mid).compareTo(target);
			
			if (comparison == 0) {
				return mid;
			} else if (comparison == -1) {
				min = mid;
			} else {
				max = mid;
			}
			
			mid = (min+max)/2;
		}
		
		return -1;
	}

}
