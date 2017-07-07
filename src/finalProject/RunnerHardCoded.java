package finalProject;

import java.util.ArrayList;

public class RunnerHardCoded implements RunnerDAO  {
	
	private ArrayList<Runner> runners = new ArrayList<> ();
	
	/**
     * Construct a RunnerHardCoded.
     */
	public RunnerHardCoded()
	{
		Runner r1 = new Runner("Tortoise", 10, 0);
		Runner r2 = new Runner("Hare", 100, 90);
		runners.add(r1);
		runners.add(r2);
		//runners = this.getRunners();
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
	 * Get all the runners hard-coded in this method.
	 * @return the arraylist comprised of all the runners
	 */
	public ArrayList<Runner> getRunners() { 
		
		return runners;
	}
	
	

}
