/*
 * Implementation of Stack using Arrays
 */
public class Stack {

	static int size = 10;
	static double array[] = new double [size];
	static int last = -1;
	

	/**
	 * pops the last element
	 */
	public static void pop()
	{
		// No elements to be pop
		if (last == -1)
		{
			System.out.println("No elements to be pushed!");
		}
		else
		{
			System.out.println(array[0] + " is pushed");
			last--;
		}
		
	}
	
	
	/**
	 * pushes a value to the array
	 * @param value
	 */
	public static void push(double value)
	{
		// the stack is full!
		if(last == size - 1)
		{
			resize();
		}
		
		array[++last] = value;
	}
	
	
	/**
	 * resizes the array when it's full
	 */
	public static void resize()
	{
		size = size * 2;
		double newArray[] = new double[size]; 
		for (int i = 0; i < array.length; i++) 
		{
			newArray[i] = array[i];
		}
		
		array = newArray.clone();
	}

}
