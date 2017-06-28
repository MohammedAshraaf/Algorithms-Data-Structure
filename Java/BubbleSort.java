/*
 * Implementation of Bubble Sort on Array of Integers
 */
public class BubbleSort {

		public void bubbleSort(int array[])
		{
			// Bubble sort
			for (int i = 0; i < array.length; i++)
			{
				// a flag that tells whether the array is sorted or not by checking the swaps
				boolean stop = true;
				
				// each time there will be i elements sorted so we don't need to check them!
				for (int j = 0; j < array.length -1 -i; j++) 
				{
					// Swapping
					if(array[j] > array[j + 1])
					{
						int temp = array[j];
						array[j] = array[j +1];
						array[j + 1] = temp;
						
						// we have a swap
						stop = false;
					}
				}
				// No Swaps then the array is sorted
				if (stop)
				{
					System.out.println("Sorted :)");
					break;
				}
			}
			
			// Print the array to the screen
			for (int i = 0; i < array.length; i++)
			{
				System.out.print(array[i] + " ");
			}
				
		}

}
