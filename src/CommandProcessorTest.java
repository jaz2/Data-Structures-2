//import static org.junit.Assert.*;
import java.io.BufferedWriter;
import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import student.TestCase;
import org.junit.Test;


// -------------------------------------------------------------------------
/**
 *  Tests the CommandProcessor
 *
 *  @author Jazmine Zurita
 *  @version Jan 25, 2016
 */

public class CommandProcessorTest extends TestCase
{
    /**
     *  This method sets up the tests that follow.
     */
    public void setUp()
    {
        //Point1 r = new Point1();
    }

    /**
     * Tests when the insert is inside rectangl
     * @throws IOException 
     */
    @Test
    public void testInsertInBounds() throws IOException
    {
        String s = "insert a 1 1";
        File f = new File("test.txt");
        FileWriter fi = new FileWriter(f);
        BufferedWriter w = new BufferedWriter(fi);
        w.write(s);
        w.close();
        new CommandProcessor(f);
        String output = systemOut().getHistory();
        assertFuzzyEquals("Point inserted: (a, 1, 1)", output);
    }

    /**
     * Tests when the x is out of bounds
     * @throws IOException
     */
    @Test
    public void testInsOutXGreat() throws IOException
    {
        String s = "insert a 1025 1";
        File f = new File("test.txt");
        FileWriter fi = new FileWriter(f);
        BufferedWriter w = new BufferedWriter(fi);
        w.write(s);
        w.close();
        new CommandProcessor(f);
        String output = systemOut().getHistory();
        assertFuzzyEquals("Point rejected: (a, 1025, 1)", output);
    }

    /**
     * Tests when the insert x is out of bounds
     * @throws IOException 
     */
    @Test
    public void testInsertOutOfBoundsXLess() throws IOException
    {
        String s = "insert a -1 1";
        File f = new File("test.txt");
        FileWriter fi = new FileWriter(f);
        BufferedWriter w = new BufferedWriter(fi);
        w.write(s);
        w.close();
        new CommandProcessor(f);
        String output = systemOut().getHistory();
        assertFuzzyEquals("Point rejected: (a, -1, 1)", output);
    }

    /**
     * Tests when both are outside of world box
     * @throws IOException
     */
    public void testInsertBothLessThan() throws IOException
    {
        String s = "insert a -1 -1";
        File f = new File("test.txt");
        FileWriter fi = new FileWriter(f);
        BufferedWriter w = new BufferedWriter(fi);
        w.write(s);
        w.close();
        new CommandProcessor(f);
        String output = systemOut().getHistory();
        assertFuzzyEquals("Point rejected: (a, -1, -1)", output);
    }

    /**
     * Tests when the insert y is out of bounds
     * @throws IOException 
     */
    @Test
    public void testInsertOutOfBoundsYLess() throws IOException
    {
        String s = "insert a 1 -1";
        File f = new File("test.txt");
        FileWriter fi = new FileWriter(f);
        BufferedWriter w = new BufferedWriter(fi);
        w.write(s);
        w.close();
        new CommandProcessor(f);
        String output = systemOut().getHistory();
        assertFuzzyEquals("Point rejected: (a, 1, -1)", output);
    }

    /**
     * Tests when the points are on 0 and 1024
     * @throws IOException 
     */
    @Test
    public void testStillInsBounds() throws IOException
    {
        String s = "insert a 0 0";
        File f = new File("test.txt");
        FileWriter fi = new FileWriter(f);
        BufferedWriter w = new BufferedWriter(fi);
        w.write(s);
        w.close();
        new CommandProcessor(f);
        String output = systemOut().getHistory();
        assertFuzzyEquals("Point inserted: (a, 0, 0)", output);
    }

   

    /**
     * Tests when the x is at 1024
     * @throws IOException
     */
    @Test
    public void testOutInsX() throws IOException
    {
        String s = "insert a 1024 0";
        File f = new File("test.txt");
        FileWriter fi = new FileWriter(f);
        BufferedWriter w = new BufferedWriter(fi);
        w.write(s);
        w.close();
        new CommandProcessor(f);
        String output = systemOut().getHistory();
        assertFuzzyEquals("Point rejected: (a, 1024, 0)", output);
    }

    /**
     * Tests when the y is at 1024
     * @throws IOException
     */
    @Test
    public void testOutInsY() throws IOException
    {
        String s = "insert a 2 1024";
        File f = new File("test.txt");
        FileWriter fi = new FileWriter(f);
        BufferedWriter w = new BufferedWriter(fi);
        w.write(s);
        w.close();
        new CommandProcessor(f);
        String output = systemOut().getHistory();
        assertFuzzyEquals("Point rejected: (a, 2, 1024)", output);
    }

    /**
     * Tests when y is 0 
     * @throws IOException
     */
    @Test
    public void testInsBoundsY() throws IOException
    {
        String s = "insert a 100 0";
        File f = new File("test.txt");
        FileWriter fi = new FileWriter(f);
        BufferedWriter w = new BufferedWriter(fi);
        w.write(s);
        w.close();
        new CommandProcessor(f);
        String output = systemOut().getHistory();
        assertFuzzyEquals("Point inserted: (a, 100, 0)", output);
    }

    /**
     * Tests when the y is out of bounds
     * @throws IOException
     */
    @Test
    public void testInsOutYGreat() throws IOException
    {
        String s = "insert a 1 1025";
        File f = new File("test.txt");
        FileWriter fi = new FileWriter(f);
        BufferedWriter w = new BufferedWriter(fi);
        w.write(s);
        w.close();
        new CommandProcessor(f);
        String output = systemOut().getHistory();
        assertFuzzyEquals("Point rejected: (a, 1, 1025)", output);
    }

    /**
     * Tests when the insert width is out of bounds
     * @throws IOException 
     */
    @Test
    public void testInsertOutOfBoundsWLess() throws IOException
    {
        String s = "insert a -1 1";
        File f = new File("test.txt");
        FileWriter fi = new FileWriter(f);
        BufferedWriter w = new BufferedWriter(fi);
        w.write(s);
        w.close();
        new CommandProcessor(f);
        String output = systemOut().getHistory();
        assertFuzzyEquals("Point rejected: (a, -1, 1)", output);
    }

    /**
     * Tests when the width is acceptable
     * @throws IOException
     */
    @Test
    public void testInsOutWOK() throws IOException
    {
        String s = "insert a 1 1";
        File f = new File("test.txt");
        FileWriter fi = new FileWriter(f);
        BufferedWriter w = new BufferedWriter(fi);
        w.write(s);
        w.close();
        new CommandProcessor(f);
        String output = systemOut().getHistory();
        assertFuzzyEquals("Point inserted: (a, 1, 1)", output);
    }

    /**
     * Tests when the insert height is acceptable
     * @throws IOException 
     */
    @Test
    public void testInsertOutOfBoundsHOK() throws IOException
    {
        String s = "insert a 1 1";
        File f = new File("test.txt");
        FileWriter fi = new FileWriter(f);
        BufferedWriter w = new BufferedWriter(fi);
        w.write(s);
        w.close();
        new CommandProcessor(f);
        String output = systemOut().getHistory();
        assertFuzzyEquals("Point inserted: (a, 1, 1)", output);
    }

    /**
     * Tests when the x + w in bounds
     * @throws IOException
     */
    public void testInsTotalinBounds() throws IOException
    {
        String s = "insert a 1000 10";
        File f = new File("test.txt");
        FileWriter fi = new FileWriter(f);
        BufferedWriter w = new BufferedWriter(fi);
        w.write(s);
        w.close();
        new CommandProcessor(f);
        String output = systemOut().getHistory();
        assertFuzzyEquals("Point inserted: (a, 1000, 10)", output);
    }

    /**
     * Tests when the x is at 1024
     * @throws IOException
     */
    @Test
    public void testOutRemX() throws IOException
    {
        String s = "remove 1024 0";
        File f = new File("test.txt");
        FileWriter fi = new FileWriter(f);
        BufferedWriter w = new BufferedWriter(fi);
        w.write(s);
        w.close();
        new CommandProcessor(f);
        String output = systemOut().getHistory();
        assertFuzzyEquals("Point rejected: (1024, 0)", output);
    }

    /**
     * Tests when the y is at 1024
     * @throws IOException
     */
    @Test
    public void testOutRemY() throws IOException
    {
        String s = "remove 2 1024";
        File f = new File("test.txt");
        FileWriter fi = new FileWriter(f);
        BufferedWriter w = new BufferedWriter(fi);
        w.write(s);
        w.close();
        new CommandProcessor(f);
        String output = systemOut().getHistory();
        assertFuzzyEquals("Point rejected: (2, 1024)", output);
    }

    /**
     * Tests when y is 0 
     * @throws IOException
     */
    @Test
    public void testRemBoundsY() throws IOException
    { // FOR NOW
        String s = "insert a 100 0\n"
                + "remove 100 0";
        File f = new File("test.txt");
        FileWriter fi = new FileWriter(f);
        BufferedWriter w = new BufferedWriter(fi);
        w.write(s);
        w.close();
        new CommandProcessor(f);
        String output = systemOut().getHistory();
        assertFuzzyEquals("Point inserted: (a, 100, 0)\n"
                + "Point removed: (a, 100, 0)", output);
    }

    /**
     * Tests when the y is out of bounds
     * @throws IOException
     */
    @Test
    public void testRemOutYGreat() throws IOException
    {
        String s = "remove 1 1025";
        File f = new File("test.txt");
        FileWriter fi = new FileWriter(f);
        BufferedWriter w = new BufferedWriter(fi);
        w.write(s);
        w.close();
        new CommandProcessor(f);
        String output = systemOut().getHistory();
        assertFuzzyEquals("Point rejected: (1, 1025)", output);
    }


    /**
     * Tests when remove is called by coordinates
     * @throws IOException
     */
    @Test
    public void testRemoveCoord() throws IOException
    { //TODO check if this works
        String d = "remove 1 1";
        File f = new File("test.txt");
        FileWriter fi = new FileWriter(f);
        BufferedWriter w = new BufferedWriter(fi);
        w.write(d);
        w.close();
        new CommandProcessor(f);
        String output = systemOut().getHistory();
        assertFuzzyEquals("Point not found: (1, 1)", output);
    }
    
    /**
     * Tests when the x is out of bounds
     * @throws IOException
     */
    @Test
    public void testRemOutXGreat() throws IOException
    {
        String s = "remove 1025 1";
        File f = new File("test.txt");
        FileWriter fi = new FileWriter(f);
        BufferedWriter w = new BufferedWriter(fi);
        w.write(s);
        w.close();
        new CommandProcessor(f);
        String output = systemOut().getHistory();
        assertFuzzyEquals("Point rejected: (1025, 1)", output);
    }

    /**
     * Tests when the remove x is out of bounds
     * @throws IOException 
     */
    @Test
    public void testRemoveOutOfBoundsXLess() throws IOException
    {
        String s = "remove -1 1";
        File f = new File("test.txt");
        FileWriter fi = new FileWriter(f);
        BufferedWriter w = new BufferedWriter(fi);
        w.write(s);
        w.close();
        new CommandProcessor(f);
        String output = systemOut().getHistory();
        assertFuzzyEquals("Point rejected: (-1, 1)", output);
    }

    /**
     * Tests when both are outside of world box
     * @throws IOException
     */
    public void testRemoveBothLessThan() throws IOException
    {
        String s = "remove -1 -1";
        File f = new File("test.txt");
        FileWriter fi = new FileWriter(f);
        BufferedWriter w = new BufferedWriter(fi);
        w.write(s);
        w.close();
        new CommandProcessor(f);
        String output = systemOut().getHistory();
        assertFuzzyEquals("Point rejected: (-1, -1)", output);
    }

    /**
     * Tests when the remove y is out of bounds
     * @throws IOException 
     */
    @Test
    public void testRemoveOutOfBoundsYLess() throws IOException
    {
        String s = "remove 1 -1";
        File f = new File("test.txt");
        FileWriter fi = new FileWriter(f);
        BufferedWriter w = new BufferedWriter(fi);
        w.write(s);
        w.close();
        new CommandProcessor(f);
        String output = systemOut().getHistory();
        assertFuzzyEquals("Point rejected: (1, -1)", output);
    }

    /**
     * Tests when the points are on 0 and 1024
     * @throws IOException 
     */
    @Test
    public void testStillRemBounds() throws IOException
    {
        String s = "remove 0 0 1024 1024";
        File f = new File("test.txt");
        FileWriter fi = new FileWriter(f);
        BufferedWriter w = new BufferedWriter(fi);
        w.write(s);
        w.close();
        new CommandProcessor(f);
        String output = systemOut().getHistory();
        assertFuzzyEquals("Point removed: (a, 0, 0, 1024, 1024)", output);
    }
    
    /**
     * Tests the case where the name is called to be removed
     */
    @Test
    public void testRemoveName() throws IOException
    {
        String d = "remove name";
        File f = new File("test.txt");
        FileWriter fi = new FileWriter(f);
        BufferedWriter w = new BufferedWriter(fi);
        w.write(d);
        w.close();
        new CommandProcessor(f);
        String output = systemOut().getHistory();
        assertFuzzyEquals("Point not removed: name", output);
    }
    
    /**
     * Tests intersections
     */
    @Test
    public void testDuplicates() throws IOException
    {
        String d = "duplicates";
        File f = new File("test.txt");
        FileWriter fi = new FileWriter(f);
        BufferedWriter w = new BufferedWriter(fi);
        w.write(d);
        w.close();
        new CommandProcessor(f);
        String output = systemOut().getHistory();
        assertFuzzyEquals("Duplicate points: ", output);
    }


    /**
     * Tests search
     */
    @Test
    public void testSearch() throws IOException
    {
        String d = "search me";
        File f = new File("test.txt");
        FileWriter fi = new FileWriter(f);
        BufferedWriter w = new BufferedWriter(fi);
        w.write(d);
        w.close();
        new CommandProcessor(f);
        String output = systemOut().getHistory();
        assertFuzzyEquals("Point not found: me", output);
    }

    /**
     * tests the region search method
     * height part
     */
    public void testRegionSearch10() throws IOException
    {
        String d = "regionsearch   2 2 0 0";
        File f = new File("test.txt");
        FileWriter fi = new FileWriter(f);
        BufferedWriter w = new BufferedWriter(fi);
        w.write(d);
        w.close();

        new CommandProcessor(f);
        String output = systemOut().getHistory();
        assertFuzzyEquals("Rectangle rejected: (2, 2, 0, 0)", output);
    }

    /**
     * tests the region search method
     */
    public void testRegionSearch11() throws IOException
    {
        String d = "regionsearch   2  2   1 0";
        File f = new File("test.txt");
        FileWriter fi = new FileWriter(f);
        BufferedWriter w = new BufferedWriter(fi);
        w.write(d);
        w.close();

        new CommandProcessor(f);
        String output = systemOut().getHistory();
        assertFuzzyEquals("Rectangle rejected: (2, 2, 1, 0)", output);
    }

    /**
     * tests the region search method
     */
    public void testRegionSearch12() throws IOException
    {
        String d = "regionsearch   2 2    0 1";
        File f = new File("test.txt");
        FileWriter fi = new FileWriter(f);
        BufferedWriter w = new BufferedWriter(fi);
        w.write(d);
        w.close();

        new CommandProcessor(f);
        String output = systemOut().getHistory();
        assertFuzzyEquals("Rectangle rejected: (2, 2, 0, 1)", output);
    }

    /**
     * tests the region search method
     */
    public void testRegionSearc13() throws IOException
    {
        String d = "regionsearch   2 2 1 -1";
        File f = new File("test.txt");
        FileWriter fi = new FileWriter(f);
        BufferedWriter w = new BufferedWriter(fi);
        w.write(d);
        w.close();

        new CommandProcessor(f);
        String output = systemOut().getHistory();
        assertFuzzyEquals("Rectangle rejected: (2, 2, 1, -1)", output);
    }

    /**
     * tests the region search method
     */
    public void testRegionSearc14() throws IOException
    {
        String d = "regionsearch   2 2 -1 1";
        File f = new File("test.txt");
        FileWriter fi = new FileWriter(f);
        BufferedWriter w = new BufferedWriter(fi);
        w.write(d);
        w.close();

        new CommandProcessor(f);
        String output = systemOut().getHistory();
        assertFuzzyEquals("Rectangle rejected: (2, 2, -1, 1)", output);
    }

    /**
     * tests the region search method
     */
    public void testRegionSearc15() throws IOException
    {
        String d = "regionsearch   2 2 -1 -1";
        File f = new File("test.txt");
        FileWriter fi = new FileWriter(f);
        BufferedWriter w = new BufferedWriter(fi);
        w.write(d);
        w.close();

        new CommandProcessor(f);
        String output = systemOut().getHistory();
        assertFuzzyEquals("Rectangle rejected: (2, 2, -1, -1)", output);
    }

    /**
     * tests the region search method
     */
    public void testRegionSearc16() throws IOException
    {
        String d = "regionsearch   5 5 20 20";
        File f = new File("test.txt");
        FileWriter fi = new FileWriter(f);
        BufferedWriter w = new BufferedWriter(fi);
        w.write(d);
        w.close();

        new CommandProcessor(f);
        String output = systemOut().getHistory();
        assertFuzzyEquals("Points intersecting "
                + "region (5, 5, 20, 20):\n"
                + "1 quadtree nodes visited", output);
    }


    /**
     * tests the region search method
     */
    public void testRegionSearc17() throws IOException
    {
        String d = "regionsearch   2 2 0 -1";
        File f = new File("test.txt");
        FileWriter fi = new FileWriter(f);
        BufferedWriter w = new BufferedWriter(fi);
        w.write(d);
        w.close();

        new CommandProcessor(f);
        String output = systemOut().getHistory();
        assertFuzzyEquals("Rectangle rejected: (2, 2, 0, -1)", output);
    }

    /**
     * tests the region search method
     */
    public void testRegionSearc18() throws IOException
    {
        String d = "regionsearch   2 2 -1 0";
        File f = new File("test.txt");
        FileWriter fi = new FileWriter(f);
        BufferedWriter w = new BufferedWriter(fi);
        w.write(d);
        w.close();

        new CommandProcessor(f);
        String output = systemOut().getHistory();
        assertFuzzyEquals("Rectangle rejected: (2, 2, -1, 0)", output);
    }


    /**
     * Tests the dump
     * @throws IOException 
     */
    @Test 
    public void testDump() throws IOException
    {
        String d = "dump";
        File f = new File("test.txt");
        FileWriter fi = new FileWriter(f);
        BufferedWriter w = new BufferedWriter(fi);
        w.write(d);
        w.close();
        new CommandProcessor(f);
        String output = systemOut().getHistory();
        assertFuzzyEquals("SkipList dump:\n Node has "
                + "depth 1, Value (null)\n SkipList size is: 0\n" 
                + "QuadTree dump:\n"
                + "Node at 0, 0, 1024: Empty\n" 
                + "1 quadtree nodes printed", output);
    }

    /**
     * Tests when it is not a dump or anything else
     * @throws IOException
     */
    @Test
    public void testNotDump() throws IOException
    {
        String x = "test should not work";
        File f = new File("test.txt");
        FileWriter fi = new FileWriter(f);
        BufferedWriter w = new BufferedWriter(fi);
        w.write(x);
        w.close();
        new CommandProcessor(f);
        String output = systemOut().getHistory();
        assertFuzzyEquals("", output);
    }
}
