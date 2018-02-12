
public class BinarySearch
{
	/*
	 * public interface for binarySearch
	 * 
	 * @param arr array to search through
	 * @param target object to search for
	 * 
	 * @return index of target, or -1 if not in array
	 */
	public static <T extends Comparable<T>> int binarySearch(T[] arr, T target)
	{
		return binarySearch(arr, target, 0, arr.length-1);
	}
	
	/*
	 * search through an array for a specific object
	 * 
	 * @param arr array to search through
	 * @param target object to search for
	 * @param minIndex lowest index to check
	 * @param maxIndex highest index to check
	 * 
	 * @return index of target, or -1 if not in array
	 */
	private static <T extends Comparable<T>> int binarySearch(T[] arr, T target, int minIndex, int maxIndex)
	{
		//stop searching if entire array has been checked
		if (minIndex > maxIndex) return -1;
		
		
		//calculate middle index of remaining section of the array
		int mid = minIndex + (maxIndex - minIndex)/2;
		
		
		// determine whether the target has been found, or
		// which half of the array to continue searching
		int comparison = arr[mid].compareTo(target);
		
		if (comparison == 0)
			return mid;
		else if (comparison == -1)
			return binarySearch(arr, target, mid+1, maxIndex);
		else
			return binarySearch(arr, target, minIndex, mid-1);
	}
}
