/*
 * Implementation of Merge Sort
 */
public class MergeSort {

	/**
	 * sorts the array by applying the divide part!
	 * @param mainArray
	 */
	public static void mergeSort(int mainArray[])
	{
		if (mainArray.length == 1)
		{
			return;
		}
		// length for the sub-arrays
		int lengthA = mainArray.length / 2;
		int lengthB = mainArray.length - lengthA;
		
		// create sub-arrays to divide the main array inside of them
		int subArrayA [] = new int[lengthA];
		int subArrayB [] = new int[lengthB];
		
		// update the length of b to be 0 to fill its array after array a got filled
		lengthB = 0;
		
		
		// fill the sub-arrays
		for(int i = 0; i < mainArray.length; i++)
		{
			// fill the array a until the i equals its length then move to array b
			if(i < lengthA)
			{
				subArrayA[i] = mainArray[i];
			}
			else
			{
				subArrayB[lengthB++] = mainArray[i];
			}
		}
		
		
		// sort the sub-arrays using merge sort recursively
		mergeSort(subArrayA);
		mergeSort(subArrayB);
		
		merge(subArrayA, subArrayB, mainArray);
	}
	
	
	/**
	 * sorts the array by applying the merge part
	 * @param a which is the first sub-array
	 * @param b which is the second sub-array
	 * @param main which is the main array
	 */
	public static void merge(int[] a, int[] b, int[] main)
	{
		
		// counters to keep track of the indexes left in the sub-arrays
		int counterA = 0, counterB = 0;
		for (int i = 0; i < main.length; i++)
		{
			// array A has been completely added to main so loop through just B
			if(counterA == a.length)
			{
				for (int j = counterB; j < b.length; j++)
				{
					main[i++] = b[j];
				}
				break;
			}
			
			// array B has been completely added to main so loop through just A
			else if(counterB == b.length)
			{
				for (int j = counterA; j < a.length; j++)
				{
					main[i++] = a[j];
				}
				break;
			}
			
			// a has smaller value so added it first
			else if (a[counterA] < b[counterB])
			{
				main[i] = a[counterA++];
			}
			
			// b has smaller value so added it first ( ignore similarity )
			else
			{
				main[i] = b[counterB++];
			}
		}
		
	}

}
