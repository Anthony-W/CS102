public class MySorts
{

	public static <T extends Comparable<T>> void QuickSort(T[] list)
	{
		QuickSort(list, 0, list.length);
	}
	
	private static <T extends Comparable<T>> void QuickSort(T[] list, int front, int end)
	{
		System.out.println(front + " " + end);
		for(int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println("");
		
		if (end-front <= 1) return;
		
		int originalFront = front;
		int originalEnd = end;
		T mid = list[end-1];
		end--;
		
		while(front <= end)
		{
			while(front != end && list[front].compareTo(mid) <= 0) front++;
			while(front != end && list[end].compareTo(mid) >= 0) end--;
			
			if (front < end)
			{
				T temp = list[front];
				list[front] = list[end];
				list[end] = temp;
			}
			else
			{
				T temp = list[front];
				list[front] = mid;
				list[originalEnd-1] = temp;
				break;
			}
		}
		
		QuickSort(list, originalFront, end);
		QuickSort(list, front+1, originalEnd);
	}
}
