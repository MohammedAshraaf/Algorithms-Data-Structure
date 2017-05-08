/*
 * Implementation of Linear and Binary search on Array of Integers
 */
public class Search 
{
	
	public static void linear(int array[], int searchable)
	{
		// go through the array index by index and find the value
		for (int i = 0; i < array.length; i++) 
		{
			if(array[i] == searchable)
			{
				System.out.println("Value Found!");
				return;
			}
		}
		System.out.println("Value Not Found");
		
	}
	
	public static void binary(int array[], int searchable, int start, int end)
	{
		// Element not found because we're out of the range
		if(start > end)
		{
			System.out.println("Value Not Found");
			return;
		}
		// get the middle and check if the element we're searching for at that index
		int middle = ( start + end ) / 2;
		if(array[middle] == searchable)
		{
			System.out.println("Value Found");
			return;
		}
		// else search in the left half 
		else if(array[middle] > searchable)
		{
			binary(array, searchable, start, middle -1);
		}
		// else search in the right half
		else
		{
			binary(array, searchable, middle +1 , end);
		}
	}
}
