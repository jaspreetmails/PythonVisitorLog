package finalProject;
import java.util.Scanner;

/**
 * Validate different input.
 */
public class Validator {

	public static int getInt(Scanner sc, String prompt) {
		int i = 0;
		boolean isValid = false;
		while (isValid == false)
		{
			System.out.print(prompt);
			if (sc.hasNextInt())
			{
				i = sc.nextInt();
				isValid = true;
			}
			else
			{
				System.out.println("Error! Invalid integer value. Try again.");
			}
			sc.nextLine();  // discard any other data entered on the line
		}
		return i;
	}
	
    public static String getLine(Scanner sc, String prompt)
    {
        System.out.print(prompt);
        String s = sc.nextLine();        // read the whole line
        return s;
    }
    
	public static String getChoiceString(Scanner sc, String prompt,
			String s)
	{
		String c = "";
		boolean isValid = false;
        while (isValid == false)
        {
        	System.out.print(prompt);
        	String d = sc.nextLine(); // detect empty input(enter)
        	if (!d.equals(""))
        	{
        		if (d.equalsIgnoreCase(s))
        		{
        			c = s;
        			isValid = true;
        		}        			
        		else
        		{
        			System.out.println("Error! Entry is invalid. Try again.");
        		}
        	}
        	else                                                                        
        	{                                                                              	
        		System.out.println("Error! This entry is required. Try again.");            	
        	}                                                                              	
        }	
    return c;		
	}

}

