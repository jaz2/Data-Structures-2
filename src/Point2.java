import java.io.File;
import java.io.FileNotFoundException;

//On my honor: 
// 
// - I have not used source code obtained from another student, 
// or any other unauthorized source, either modified or 
// unmodified. 
// 
// - All source code and documentation used in my program is 
// either my original work, or was derived by me from the 
// source code published in the textbook for this course. 
// 
// - I have not discussed coding details about this project with 
// anyone other than my partner (in the case of a joint 
// submission), instructor, ACM/UPE tutors or the TAs assigned 
// to this course. I understand that I may discuss the concepts 
// of this program with other students, and that another student 
// may help me debug my program so long as neither of us writes 
// anything during the discussion or modifies any computer file 
// during the discussion. I have violated neither the spirit nor 
// letter of this restriction.
//
// Jazmine Zurita and Jessica McCready

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
