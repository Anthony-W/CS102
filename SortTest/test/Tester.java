import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Tester {

	@Test
	void test()
	{
		Integer[] arr = {10,5,13,75,2,10,20,57,100,1};
		
		MySorts.QuickSort(arr);
		for(int i =0; i <arr.length;i++) {
			System.out.println(arr[i]);
		}
	}

}
