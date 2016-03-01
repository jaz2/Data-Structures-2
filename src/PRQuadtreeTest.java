import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import student.TestCase;

/**
 * 
 */

/**
 * @author Jazmine Zurita and Jessica McCready
 * @version Feb 22 2016
 *
 */
public class PRQuadtreeTest extends TestCase {
    PRQuadtree tree;
    Point p;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() 
    {
        tree = new PRQuadtree(0, 0, 1024);
        p = new Point ("ayy", 0 ,12);
        
    }

    public void testDumpNoInserts()
    {
        tree.dump();
        String output = systemOut().getHistory();
        assertFuzzyEquals("QuadTree dump:\n"
                + "Node at 0, 0, 1024: Empty\n"
                + "1 quadtree nodes printed", output);
    }

    public void testDump1Insert()
    {
        tree.insert(p);
        tree.dump();
        String output = systemOut().getHistory();
        assertFuzzyEquals("QuadTree dump:\n"
                + "Node at 0, 0, 1024:\n"
                + "(ayy, 0, 12)\n"
                + "1 quadtree nodes printed", output);
    }

    public void testInsertSameThenDiff()
    {
        tree.insert(p);
        tree.insert(p);
        tree.insert(p);
        Point p1 = new Point("a", 1000, 1000);
        tree.insert(p1);
        tree.dump();
        String output = systemOut().getHistory();
        assertFuzzyEquals("QuadTree dump:\n"
                + "Node at 0, 0, 1024: Internal\n"
                + "Node at 0, 0, 512:\n" 
                + "(ayy, 0, 12)\n"
                + "(ayy, 0, 12)\n"
                + "(ayy, 0, 12)\n"
                + "Node at 512, 0, 512: Empty\n"
                + "Node at 0, 512, 512: Empty\n"
                + "Node at 512, 512, 512:\n" 
                + "(a, 1000, 1000)\n"
                + "5 quadtree nodes printed", output);
        assertTrue(tree.root.getClass().equals(PRQuadInternal.class));
    }

    public void testInsertSame()
    {
        tree.insert(p);
        tree.insert(p);
        tree.insert(p);
        tree.dump();
        String output = systemOut().getHistory();
        assertFuzzyEquals("QuadTree dump:\n"
                + "Node at 0, 0, 1024: \n"
                + "(ayy, 0, 12)\n"
                + "(ayy, 0, 12)\n"
                + "(ayy, 0, 12)\n"
                + "1 quadtree nodes printed", output);
    }

    public void testDumpFromTest()
    {
        tree.insert(new Point("r_r", 1, 20));
        tree.insert(new Point("rec", 10, 30));
        tree.insert(new Point("r_42", 1, 20));
        tree.insert(new Point("far", 200, 200));
        tree.dump();
        String output = systemOut().getHistory();
        assertFuzzyEquals("QuadTree dump:\n"
                + "Node at 0, 0, 1024: Internal\n"
                + "Node at 0, 0, 512: Internal\n"
                + "Node at 0, 0, 256: Internal\n"
                + "Node at 0, 0, 128:\n"               
                + "(rec, 10, 30)\n"
                + "(r_42, 1, 20)\n"
                + "(r_r, 1, 20)\n"
                + "Node at 128, 0, 128: Empty\n"
                + "Node at 0, 128, 128: Empty\n"
                + "Node at 128, 128, 128:\n"
                    + "(far, 200, 200)\n"
                    + "Node at 256, 0, 256: Empty\n"
                    + "Node at 0, 256, 256: Empty\n"
                    + "Node at 256, 256, 256: Empty\n"
                    + "Node at 512, 0, 512: Empty\n"
                    + "Node at 0, 512, 512: Empty\n"
                    + "Node at 512, 512, 512: Empty\n"
                    + "13 quadtree nodes printed", output);
    }

}
