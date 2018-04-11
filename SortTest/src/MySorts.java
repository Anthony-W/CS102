public class MySorts
{

	public static <T extends Comparable<T>> void QuickSort(T[] list)
	{
		QuickSort(list, 0, list.length);
	}
	
	private static <T extends Comparable<T>> void QuickSort(T[] list, int front, int end)
	{
		if (front-end <= 1) return;
		
		int originalFront = front;
		int originalEnd = end;
		T mid = list[end-1];
		end--;
		
		while(front <= end)
		{
			while(front <= end && list[front].compareTo(mid) <= 0) front++;
			while(front < end && list[end].compareTo(mid) >= 0) end--;
			
			T temp = list[front];
			list[front] = list[end];
			list[end] = temp;
		}
		
		T temp = list[front];
		list[front] = mid;
		list[originalEnd-1] = temp;
		
		
		QuickSort(list, originalFront, end-1);
		QuickSort(list, front+1, originalEnd);
	}
}
