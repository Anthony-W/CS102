public class Main {

	public static void main(String[] args) {
		/*
		int[] list = new int[27];
		for (int i = 0; i < 27; i++) {
			list[i] = i;
		}
		for (int i = -1; i < 28; i++) {
			System.out.println(trinarySearch(list, i));
		}
		*/
	}

	public static <T extends Comparable<T>> int trinarySearch(T[] list, T target)
	{
		int min = 0;
		int max = list.length-1;
		int mid1 = min + (max - min) / 3;
		int mid2 = min + (max - min) * 2/3;
		
		while (min <= max)
		{
			
			if (list[mid1].equals(target))
			{
				return mid1;
			}
			else if (list[mid1].compareTo(target) == 1)
			{
				max = mid1-1;
			}
			else
			{
				if (list[mid2].equals(target))
				{
					return mid2;
				}
				else if (list[mid2].compareTo(target) == 1)
				{
					min = mid1+1;
					max = mid2-1;
				}
				else
				{
					min = mid2+1;
				}
			}
			
			mid1 = min + (max - min) / 3;
			mid2 = min + (max - min) * 2/3;
		}
		return -1;
	}
	
	
}

