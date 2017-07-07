package finalProject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
/**
 * Read the text file, which includes runner information.
 */

public class RunnerTextFile implements RunnerDAO {
	
	private Path runnersPath = null;
    private ArrayList<Runner> runners = null;
    private File runnersFile = null;
    
    /**
     * Construct a runner text file.
     */
    public RunnerTextFile()
    {
    	    runnersPath = Paths.get("FinalTextData.txt");
    	    runnersFile = runnersPath.toFile();
		runners = this.getRunners();
    }
	
    /**
     * Get a runner with specific name.
     * @param code the name of runner
     * @return runner information
     */
	public Runner getRunner(String code) {
		for (Runner r : runners)
        {
            if (r.getName().equals(code))
                return r;
        }
        return null;
	}

	/**
	 * Get all the runners in the text file.
	 * @return the arraylist comprised of all the runners
	 */
	public ArrayList<Runner> getRunners() {
		// if the runners file has already been read, don't read it again
        if (runners != null)
            return runners;        

        runners = new ArrayList<>();        
        
        if (Files.exists(runnersPath))  // prevent the FileNotFoundException
        {
            try (BufferedReader in = 
                     new BufferedReader(
                     new FileReader(runnersFile)))
            {
                // read all runners stored in the file
                // into the array list
                String line = in.readLine();
                while(line != null)
                {
                    String[] columns = line.split(" ");
                    String name = columns[0];
                    String speed = columns[1];
                    String percentage = columns[2];
                    Runner r = new Runner(name, Integer.parseInt(speed), Integer.parseInt(percentage));

                    runners.add(r);

                    line = in.readLine();                    
                }
                in.close();
            }
            catch(IOException e)
            {
                System.out.println(e);
                return null;
            }
        }
        return runners;
	}

}
