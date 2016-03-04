import java.io.File;
import java.io.FileNotFoundException;

/**
 * This project implements the PRQuadtree for spatial record
 */

/**
 * The class containing the main method, the entry point of the application.
 *
 * @author Jazmine Zurita and Jessica McCready
 * @version March 4 2016
 */
public class Point2
{

    /**
     * The entry point of the application.
     * This program was compiled on iOS using Eclipse Mars
     *
     * @param args
     *            The name of the command file passed in as a command line
     *            argument.
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        if (args == null)
        {
            System.out.println("Hello, World");
        }
        else 
        {
            String input = args[0].trim();
            File f = new File(input);
            CommandProcessor com = new CommandProcessor(f);
        }
    }
}
