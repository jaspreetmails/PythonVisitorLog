package finalProject;
import java.util.Random;
/**
 * Gets runner run.
 *
 */
public class ThreadRunner extends Thread{
	
	private String runnerName;
	private int runnerSpeed;
	private int restPercentage;
	private static volatile Object obj = new Object();
	
	/**
	 * Construct a threadRunner with its name, Runner Speed and Rest Percentage
	 * @param name name of the runner
	 * @param speed running speed of the runner
	 * @param percentage rest percentage of the runner
	 */
	
	public ThreadRunner(String name, int speed, int percentage)
	{
		this.runnerName = name;
		this.runnerSpeed = speed;
		this.restPercentage = percentage;
	}
	
	/**
	 * Let a runner run.
	 */
	
	@Override
    public void run()
    {
		int count = 0;
		Thread ct = Thread.currentThread();
		
		while (!isInterrupted())
		{
			Random rn = new Random();
			int runOrRest = rn.nextInt(100) + 1;	
			
			if (!(runOrRest <= this.restPercentage))
			{
				
			if(count < 1000) 
				{ 
					count = count + this.runnerSpeed;
					if(ct.isInterrupted()==false)
                    System.out.println(this.runnerName + ": " + count);
				}	
							
			else
				{   
				
			        
					System.out.println(this.runnerName + ": " + "I finished!");
					System.out.println();
                    Main.finished();
					break;
				}
				
				

			}
		
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println(this.runnerName + ": You beat me fair and square.");
				System.out.println();
				break;
			}
		}
    }

}
