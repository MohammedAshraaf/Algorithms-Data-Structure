import java.util.Scanner;

import javax.xml.crypto.dsig.SignedInfo;

public class Facebook {
	
	// prepare the data for the program 
	static Scanner input = new Scanner(System.in);
	static String firstName[] 	= new String[1];
	static String lastName[] 	= new String[1];
	static String email[] 		= new String[1];
	static String password[]	= new String[1];
	static boolean firstTime = true;

	
	
	public static void main(String[] args) 
	{
		
		
		// loop until the user close the program
		while(true)
		{
			welcome();
			choice();
			// new lines to make the lay out looks good |8
			System.out.println("\n \n");
		}
		

	}
	
	
	
	/**
	 * Welcomes the user and offer options
	 */
	private static void welcome()
	{
		System.out.println("Welcome To Facebook Al-Azhar :D ");
		System.out.println("1-Sign up \t\t 2-Sign in");
		System.out.println("3-Search by Email \t 4-Search by FirstName");
		System.out.println("5-Delete \t\t OR Press any other key to close!");
	}
	
	
	
	/**
	 * prompts user for his choice
	 */
	public static void choice()
	{
		String x = input.nextLine();
		switch (x) 
		{
			case "1":
				signUp();
				break;

			case "2":
				signIn();
				break;
			case "3":
				searchHandler(1);
				break;
			case "4":
				searchHandler(2);
				break;
			case "5":
				delete();
				break;
			default:
				System.exit(0);
		}
	}
	
	
	/**
	 * Sings the user up
	 */
	public static void signUp()
	{
		// if this the first time to sign up
		if(firstTime)
		{
			System.out.print("Enter You first Name: ");
			firstName[0] = input.nextLine();
			System.out.print("Enter You Last Name: ");
			lastName[0] = input.nextLine();
			System.out.print("Enter You Email: ");
			email[0] = input.nextLine();
			System.out.print("Enter You Password: ");
			password[0] = input.nextLine();
			System.out.println("Thank You!, Now you can sign in :)");
			firstTime = false;
			
		}
		// increase the size of the arrays and sign him up
		else
		{
			
			increaseFirstNameSize();
			increaseLastNameSize();;
			increaseEmailSize();
			increasePasswordSize();
			
			System.out.println("Thank You!, Now you can sign in :)");
		}
	}
	
	
	/**
	 * signs users in 
	 */
	public static void signIn()
	{
		// if this is the first 
		if(firstTime)
		{
			System.out.println("There is no accounts!");
			return;
		}
		
		// counter to prevent users from keep signing in after Five times
		int count = 0;
		while(count++ != 5)
		{
			// prompt the user for email
			System.out.print("Please Enter Your Email: ");
			String checkedEmail = input.nextLine();
			
			// prompt the user for Password
			System.out.print("Please Enter Your Password: ");
			String checkedPassword = input.nextLine();
			
			
			// search
			int position = search(checkedEmail, email);
			
			// Found or fail!
			if(position != -1)
			{
				// compare the password within the same position as the email with the input
				if(password[position].compareTo(checkedPassword) == 0)
				{
					System.out.println("You've Sined in successfully :D");
					return;
				}
				
			}
			else
			{
				System.out.println("Invalid email or password");
			}
		}
		
		// failed to sing him in after five times
		System.out.println("Sorry Can't sign in .. going back to the main menu");
			
	}
	
	
	
	/**
	 * handles the search type
	 * @param kindOfSearch
	 */
	public static void searchHandler(int kindOfSearch)
	{
		// if there is no accounts .. fail
		if (firstTime)
		{
			System.out.println("No Accounts to search for");
			return;
		}
		
		String userInput;
		int position;
		if(kindOfSearch == 1)
		{
			// prompt for email
			System.out.print("Please Enter Your Email");
			userInput = input.nextLine();
			position = search(userInput, email);
		}
		else
		{
			// prompt for email
			System.out.print("Please Enter Your FirstName");
			userInput = input.nextLine();
			position = search(userInput, firstName);
		}
		
		
		// if position found
		if(position == -1)
		{
			System.out.println("User not Found!");
		}
		else
		{
			System.out.println("User Found!");
		}
	}
	
	
	
	/**
	 * searches for specific input within specific array
	 * @param userInput
	 * @param array
	 * @return
	 */
	public static int search(String userInput, String array[])
	{
		for (int i = 0; i < array.length; i++)
		{
			// found the email
			if(array[i].compareToIgnoreCase(userInput) == 0)
			{
				return i;
			}
		}
		return -1;
	}
	
	
	
	/**
	 * deletes all data from this specific position
	 * @param position
	 */
	public static void delete()
	{
		if (firstTime)
		{
			System.out.println("No Accounts to be deleted!");
			return;
		}
		System.out.println("Please Enter your Email");
		String userEmail = input.nextLine();
		int position = search(userEmail, email);
		
		if(position == -1)
		{
			System.out.println("Email Not Found!");
			return;
		}
		int lenght = email.length -1;
		
		// create sub arrays to carry the new collection of data
		String subEmail[] = new String [lenght];
		String subFirst[] = new String [lenght];
		String subLast[] = new String [lenght];
		String subPassword[] = new String [lenght];

		
		// copy the data except for the deleted one
		for(int i = 0, j = 0; i < email.length; i++)
		{
			// skip this data 
			if(i == position)
				continue;
			
			// fill the sub arrays with the current information
			subEmail[i] = email[i];
			subFirst[i] = firstName[i];
			subLast[i] = lastName[i];
			subPassword[i] = password[i];
			j++;
		}
		
		// copy the data
		firstName = subFirst.clone();
		lastName = subLast.clone();
		email = subEmail.clone();
		password = subPassword.clone();
		
		// Done 
		System.out.println("The user haas been deleted! :(");
		
		if(email.length == 0)
			firstTime = true;

	}
	
	
	/**
	 * Increases the size of the First Name array to add new person!
	 */
	public static void increaseFirstNameSize()
	{
		String array[] = new String[firstName.length +1];
		for (int i = 0; i < array.length -1; i++) 
		{
			array[i] = firstName[i];
		}
		firstName = array.clone();
		System.out.println("Enter You first Name");
		firstName[firstName.length -1] = input.nextLine();

		
	}
	
	
	/**
	 * Increases the size of the last Name array to add new person!
	 */
	public static void increaseLastNameSize()
	{
	
		String array[] = new String[lastName.length +1];
		for (int i = 0; i < array.length -1; i++) 
		{
			array[i] = lastName[i];
		}
		
		lastName = array.clone();
		System.out.println("Enter You Last Name");
		lastName[lastName.length -1] = input.nextLine();
	}
	
	
	/**
	 * Increases the size of the Email array to add new person!
	 */
	public static void increaseEmailSize()
	{
		String array[] = new String[email.length +1];
		for (int i = 0; i < array.length -1; i++) 
		{
			array[i] = email[i];
		}
		
		email = array.clone();
		System.out.println("Enter You Last Email");
		email[email.length -1] = input.nextLine();
		
	}
	
	
	/**
	 * Increases the size of the Password array to add new person!
	 */
	public static void increasePasswordSize()
	{
		String array[] = new String[password.length +1];
		for (int i = 0; i < array.length -1; i++) 
		{
			array[i] = password[i];
		}
		
		password = array.clone();
		System.out.println("Enter You Password");
		password[password.length -1] = input.nextLine();
	}
	
}
