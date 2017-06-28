/*
 * Implementation of Insertion Sort on Array of Integers
 */
public class InsertionSort
{
	public static void insertionSort(int array[])
	{
		// Insertion sort
		for (int i = 0; i < array.length; i++)
		{
			// check if the current element smaller the the previous to start shifting
			for (int j = i; j > 0 && array[j] < array[j -1]; j--) 
			{
				// Swapping
				int temp = array[j];
				array[j] = array[j -1];
				array[j - 1] = temp;
			}
			
		}
		
		// Print the array to the screen
		for (int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
			
	}
}
