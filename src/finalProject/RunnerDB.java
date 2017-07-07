package finalProject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 * Read the derby database, which includes runner information.
 */
public class RunnerDB implements RunnerDAO{
	
	/**
	 * Connect to the derby database.
	 * @return the connection
	 */
	private Connection connect()
    {
        Connection connection = null;
        try
        {
            String dbDirectory = "resources";
            System.setProperty("derby.system.home", dbDirectory);

            String url = "jdbc:derby:FinalDB";
            String user = "";
            String password = "";
            connection = DriverManager.getConnection(url, user, password);
        }
        catch(SQLException e)
        {
            System.err.println("Error loading database driver: " + e);
        }
        return connection;
    }

	/**
     * Get a runner with specific name.
     * @param code the name of runner
     * @return runner information
     */
	public Runner getRunner(String code) {
		try
        {
            Connection connection = connect();
            String selectRunner =
                "SELECT RunnersName, RunnersSpeed, RestPercentage " +
                "FROM FinalDerbyData " +
                "WHERE RunnersName = ?";
            PreparedStatement ps = connection.prepareStatement(selectRunner);
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();

            if (rs.next())
            {
                int speed = (int) rs.getDouble("RunnersSpeed");
                int percentage = (int) rs.getDouble("RestPercentage");
                Runner r = new Runner(code, speed, percentage);
                rs.close();
                ps.close();
                connection.close();
                return r;
            }
            else
                return null;
        }
		catch(SQLException sqle)
        {
            //sqle.printStackTrace();   // for debugging
            return null;
        }
	}

	/**
	 * Get all the runners in the derby database.
	 * @return the arraylist comprised of all the runners
	 */
	public ArrayList<Runner> getRunners() {
		try
        {
            Connection connection = connect();
            ArrayList<Runner> runners = new ArrayList<Runner>();

            String query = "SELECT RunnersName, RunnersSpeed, RestPercentage "
                         + "FROM FinalDerbyData ";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
                String name = rs.getString("RunnersName");
                int speed = (int) rs.getDouble("RunnersSpeed");
                int percentage = (int) rs.getDouble("RestPercentage");

                Runner r = new Runner(name, speed, percentage);
                runners.add(r);
            }
            rs.close();
            ps.close();
            connection.close();
            return runners;
        }
        catch(SQLException sqle)
        {
            //sqle.printStackTrace();  // for debugging
            return null;
        }
	}

}
