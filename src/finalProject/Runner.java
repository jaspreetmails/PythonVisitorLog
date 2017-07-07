package finalProject;
/**
 * A runner includes three personal information.
 */
public class Runner {
	
	private String name;
    private int speed;
    private int percentage;

    /**
     * Construct a runner.
     */
	public Runner()
	{
		this("", 0, 0);
	}
	
	/**
	 * Constructs a runner with personal information, its name, running speed and rest percentage.
	 * @param name the name of the runner
	 * @param speed the running speed of the runner
	 * @param percentage the rest percentage of the runner
	 */
	public Runner(String name, int speed, int percentage) {
		this.name = name;
        this.speed = speed;
        this.percentage = percentage;
	}
	
    /**
     * Sets the name of the runner. 
     * @param name the name which is given to the runner
     */
	public void setName(String name) {
		this.name = name;
	}
    
	/**
	 * Sets the running speed of the runner.
	 * @param speed the running speed which is given to the runner
	 */
	public void setSpeed(int speed) {
		this.speed = speed;		
	}

	/**
	 * Sets the rest percentage of the runner.
	 * @param percentage the the rest percentage which is given to the runner
	 */
	public void setPercentage(int percentage) {
		this.percentage = percentage;		
	}

	/**
	 * Gets the name of the runner.
	 * @return the name of the runner
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Gets the running speed of the runner.
	 * @return the running speed of the runner.
	 */
	public int getSpeed(){
		return this.speed;
	}
	
	/**
	 * Gets the rest percentage of the runner.
	 * @return the rest percentage of the runner
	 */
	public int getPercentage(){
		return this.percentage;
	}
	
	



}
