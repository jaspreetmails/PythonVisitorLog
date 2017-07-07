package finalProject;
import java.util.ArrayList;
/**
 *  Create thread for every runner in the database 
 *  and provide a finish method for the first-finishing runner to call
 */
public class Main extends Thread {

	private ArrayList<Runner> runners;
	private static ArrayList<Thread> threads = new ArrayList<> ();

	/**
	 * Constructs a Main.
	 * @param runnerDAO a interface with two method, getRunner and getRunners
	 */
    public Main(RunnerDAO runnerDAO)
    {
    	    runners = runnerDAO.getRunners();
    }

    /**
     * Creates and starts as many threads as the size of arraylist runners.
     */
	public void main()
	 {
	
		 for (int i = 0; i < runners.size(); i++)
		 {
			
			 Runner r = runners.get(i);
			 ThreadRunner t = new ThreadRunner(r.getName(), r.getSpeed(), r.getPercentage());
			 t.setName(r.getName());
			 threads.add((ThreadRunner) t);
			 t.start();
			 if (i == (runners.size()-1))
			 {
				 try {
					t.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
		 }
	 }
	 
	 /**
	  * Interrupts all the thread while one of the thread has finished.
	  */
	 public static void finished()
	 {
		 Thread t1 = Thread.currentThread();
		 System.out.println("The race is over! The " + t1.getName() + " is the winner.");
		 System.out.println();
		 for (Thread t: threads)
		 {
			 t.interrupt();
		 }
		 
		 
	 }
	 
	

}
