package finalProject;
import java.util.Scanner;

/**
 * A class complete the user interaction.
 */
public class MarathonAPP extends Thread{
	
	// declare two class variables
    private static RunnerDAO runnerDAO = null;
    private static Scanner sc = null;
    
    public static void main(String args[])
    {   
    	    // display a welcome message
        System.out.println("Welcome to the Marathon Race Runner Program\n");
                
        sc = new Scanner(System.in);
        
        // perform 1 or more actions
        int action = 0;
        while (!(action ==5))
        {
            System.out.println("Select your data source:\n");
        	    displayMenu();
        	    action = Validator.getInt(sc,
                        "Enter your choice: ");
        	    if (action == 1)
        	    {
        	    	    runnerDAO = DAOFactory.getRunnerDAO("derby");
        	        Validator.getChoiceString(sc, "Enter DB name: ", "FinalDB");
        			System.out.println("Get set...Go!");
        			System.out.println();
        	        Main m = new Main(runnerDAO);
        	        m.main();        	        
        	    }
        	    else if (action == 2)
        	    {
    	    	        runnerDAO = DAOFactory.getRunnerDAO("xml");
            	    Validator.getChoiceString(sc, "Enter XML file name: ",
            	    		                                 "FinalXMLData.xml");
            	    System.out.println("Get set...Go!");
        			System.out.println();
            	    Main m = new Main(runnerDAO);
        	        m.main();            	    
        	    }
        	    else if (action == 3)
        	    {
    	    	        runnerDAO = DAOFactory.getRunnerDAO("txt");
    	    	        Validator.getChoiceString(sc, "Enter text file name: ",
                                "FinalTextData.txt");
    	    	        System.out.println("Get set...Go!");
            		System.out.println();
    	    	        Main m = new Main(runnerDAO);
            	    m.main();
        	    }
        	    
        	    else if (action == 4)
        	    {
    	    	        runnerDAO = DAOFactory.getRunnerDAO("hardCoded");
    	    	        System.out.println("Get set...Go!");
            		System.out.println();
    	    	        Main m = new Main(runnerDAO);
                	m.main();
        	    }
        	    
        	    else if (action == 5)
        	    {
        	       	System.out.println("Thank you for using my Marathon Race Program");
        	       	break;
        	    }
        	    
        	    else
        	    	{
        	    	    System.out.println("Error! Not a valid command.\n");      	
        	    	}
        	    
    	       	System.out.println("Press any key to continue...");
                try
                {
                    System.in.read();                    
                }  
                catch(Exception e1)
                {}
        	    
        }
    }
    
    /**
     * Display the menu of data type
     */

	public static void displayMenu() {
		System.out.println("1. Derby database");
		System.out.println("2. XML file");
		System.out.println("3. Text file");
		System.out.println("4. Default two runners");
		System.out.println("5. Exit");
		System.out.println();
	}

}
