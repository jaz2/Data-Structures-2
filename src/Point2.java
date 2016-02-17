import java.io.File;
import java.io.FileNotFoundException;

/**
 * { your description of the project here }
 */

/**
 * The class containing the main method, the entry point of the application.
 *
 * @author Jazmine Zurita and Jessica McCready
 * @version {put something here}
 */
public class Point2
{

    /**
     * The entry point of the application.
     *
     * @param args
     *            The name of the command file passed in as a command line
     *            argument.
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        //System.out.println("Hello, World");
        String input = args[0].trim();
        
        File f = new File(input);
        CommandProcessor cmd = new CommandProcessor(f);
    }
}
