/*
 * Implementation of Selection Sort on Array of Integers
 */
public class SelectionSort 
{
	public static void selectionSort(int array[])
	{
		// ٍSelection sort
		for (int i = 0; i < array.length; i++)
		{
			int rememberSmallest = i;
			
			// Find the smallest element 
			for (int j = i; j < array.length; j++) 
			{
				if(array[rememberSmallest] > array[j])
				{
					rememberSmallest = j;
				}
			}
			
			// Swapping
			int temp = array[i];
			array[i] = array[rememberSmallest];
			array[rememberSmallest] = temp;
			
		}
		
		// Print the array to the screen
		for (int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
			
	}
}
