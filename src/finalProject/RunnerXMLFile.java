package finalProject;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 * Read the XML file, which includes runner information.
 */
public class RunnerXMLFile implements RunnerDAO {
	
	private Path runnersPath = null;
    private ArrayList<Runner> runners = null;

    /**
     * Construct a runner XML file.
     */
	public RunnerXMLFile()
	{
		runnersPath = Paths.get("FinalXMLData.xml");
		runners = this.getRunners();
	}
	
	/**
     * Get a runner with specific name.
     * @param n name of runner
     * @return runner information
     */
	public Runner getRunner(String n) {
		for (Runner r : runners)
        {
            if (r.getName().equals(n))
                return r;
        }
        return null;
	}
	
	/**
	 * Get all the runners in the XML file.
	 * @return the arraylist comprised of all the runners
	 */
	public ArrayList<Runner> getRunners() {
		// if the XML file has already been read, don't read it again
        if (runners != null)
            return runners;        

        runners = new ArrayList<>();        
        Runner r = null;        
        if (Files.exists(runnersPath))  // prevent the FileNotFoundException
        {
            // create the XMLInputFactory object
            XMLInputFactory inputFactory = XMLInputFactory.newFactory();
            try
            {
                // create a XMLStreamReader object
                FileReader fileReader =
                    new FileReader(runnersPath.toFile());
                XMLStreamReader reader =
                    inputFactory.createXMLStreamReader(fileReader);

                // read the runners from the file
                while (reader.hasNext())
                {
                    int eventType = reader.getEventType();
                    switch (eventType)
                    {
                        case XMLStreamConstants.START_ELEMENT:
                            String elementName = reader.getLocalName();
                         
                            if (elementName.equals("Runner"))
                            {
                            	 r = new Runner();
                                String name = reader.getAttributeValue(0);
                                r.setName(name);
                            }
                            if (elementName.equals("RunnersMoveIncrement"))
                            {
                                String speedText = reader.getElementText();
                                int speed = Integer.parseInt(speedText);
                                r.setSpeed(speed);
                            }
                            if (elementName.equals("RestPercentage"))
                            {
                                String percentageText = reader.getElementText();
                                int percentage = Integer.parseInt(percentageText);
                                r.setPercentage(percentage);
                            }
                            break;
                        case XMLStreamConstants.END_ELEMENT:
                            elementName = reader.getLocalName();
                            if (elementName.equals("Runner"))
                            {
                                runners.add(r);
                            }
                            break;
                        default:
                            break;
                    }
                    reader.next();
                }
                reader.close();
            }
            catch (IOException | XMLStreamException e)
            {
                System.out.println(e);
                return null;
            }
        }
        return runners;
	}

}
