package linkedListTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		/*
		MyList<Integer> list = new MyList<Integer>();
		list.add(1);
		System.out.println(list);
		
		for (int i = 0; i < 10; i++) {
			list.add(i);
			System.out.println(list.toString());
		}
		
		System.out.println(list.contains(0));
		System.out.println(list.contains(-1));
		*/
		
		List<String> list = new ArrayList<String>();
		list.add("test1");
		list.add("bad1");
		list.add("test2");
		list.add("bad2");
		list.add("test3");
		list.add("bad3");
		list.add("test4");
		list.add("bad4");
		
		printExclusive(list, "test");
		System.out.println(prune(list, "test"));
	}

	private static void printExclusive(List<String> names, String key)
	{
		names.forEach(item->{if(!item.contains(key)) System.out.println(item);});
	}
	
	private static List<String> prune(List<String> names, String key)
	{
		return names.stream().filter(String -> String.contains(key)).collect(Collectors.toList());
	}
	
}
