/*
 * Implementation of linked list
 */
public class LinkedList 
{
	double value;
	LinkedList next;
	
	/**
	 *  Initialize the node with value
	 * @param val
	 */
	public LinkedList(double value)
	{
		this.value = value;
	}
	
	
	/**
	 * Checks if value exists in the linked list
	 * @param head which the first of the linked list
	 * @param value which the value we're looking for
	 * @return true if found, false otherwise
	 */
	public static boolean find(LinkedList head, int value)
	{
		// loop through the linked list until you find the value
		for(LinkedList search = head; search.next != null; search = search.next)
		{
			// value found, return true!
			if (search.value == value)
			{
				System.out.println("Value found!");
				return true;
			}
		}
		// value not found, return false!
		return false;
	}
	
	
	/**
	 * Traverses the linked list
	 * @param head
	 */
	public static void traversing(LinkedList head)
	{
		// loop through the linked list and print its values
		for(LinkedList search = head; search != null; search = search.next)
		{
			System.out.println(search.value);
		}
	}
	
	
	/**
	 * Deletes the node with the passing value
	 * @param head
	 * @param value
	 */
	public static void delete(LinkedList head, int value)
	{
		// the head contains the value then let it equals the next value
		if (head.value == value)
		{
			head = head.next;
			return;
		}
		
		// loop through the linked list until you find the value to be deleted
		for(LinkedList search = head; search.next != null; search = search.next)
		{
			if (search.next.value == value)
			{
				search.next = search.next.next;
				return;
			}
		}
		
	}
	
	
	/**
	 * Inserts a specific new value after specific place
	 * @param head
	 * @param value which would be followed by the new value
	 * @param newValue which is the new value
	 */
	public static void insert(LinkedList head, int value, int newValue)
	{
		// Loop through the linked list
		for(LinkedList search = head; search != null; search = search.next)
		{
			// we found the value, so we insert after it
			if(search.value == value)
			{
				LinkedList newNode = new LinkedList(newValue);
				newNode.next = search.next;
				search.next = newNode;
				return;
			}
		}	
	}
}
