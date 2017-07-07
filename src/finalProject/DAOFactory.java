package finalProject;


/**
 * Decides which database is read based on the instruction.
 */
public class DAOFactory {
	
	public static RunnerDAO getRunnerDAO(String strDatabase)
    {
        RunnerDAO rDAO;
        //strDatabase = "derby";
    		switch (strDatabase) {
    		case "xml":
    	        rDAO = new RunnerXMLFile();
    			break;
    		case "derby":
    	        rDAO = new RunnerDB();
    			break;
    		case "hardCoded":
    			rDAO = new RunnerHardCoded();
    			break;
    		case "txt":
    		default:
    	        rDAO = new RunnerTextFile();
    		}
        return rDAO;
    }

}

