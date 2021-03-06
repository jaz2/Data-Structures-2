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

    /**
     * The quad tree
     */
    PRQuadtree tree;

    /**
     * Point p 
     */
    Point p;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() 
    {
        tree = new PRQuadtree(0, 0, 1024);
        p = new Point("ayy", 0, 12);

    }

    /**
     * Tests dump with no inserts
     */
    @Test
    public void testDumpNoInserts()
    {
        tree.dump();
        String output = systemOut().getHistory();
        assertFuzzyEquals("QuadTree dump:\n"
                + "Node at 0, 0, 1024: Empty\n"
                + "1 quadtree nodes printed", output);
    }

    /**
     * Tests dump with one insert
     */
    @Test
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

    /**
     * Tests insert with same then dif
     */
    @Test
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

    /**
     * Tests the same in insert
     */
    @Test
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

    /**
     * Tests dump from the test
     */
    @Test
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

    /**
     * Tests regionsearch nw
     */
    @Test
    public void testRsNW() 
    {
        tree.insert(new Point("r_r", 1, 20));
        tree.insert(new Point("rec", 10, 30));
        tree.insert(new Point("r_42", 1, 20));
        tree.insert(new Point("far", 200, 200)); 
        tree.regionSearch(0, 0, 25, 25);
        String output = systemOut().getHistory();
        assertEquals("Points intersecting region (0, 0, 25, 25):\n"
                + "Point found: (r_42, 1, 20)\n"
                + "Point found: (r_r, 1, 20)\n"
                + "4 quadtree nodes visited\n", output);
    }

    /**
     * Tests when rs is empty
     */
    @Test
    public void testRSempty() 
    { 
        tree.regionSearch(0, 0, 24, 99);
        String output = systemOut().getHistory();
        assertEquals("Points intersecting region (0, 0, 24, 99):\n"
                + "1 quadtree nodes visited\n", output);        
    }

    /**
     * Tests se of rs
     */
    @Test
    public void testRsSE() 
    {
        tree.insert(new Point("r_r", 1, 20));
        tree.insert(new Point("rec", 10, 30));
        tree.insert(new Point("r_42", 1, 20));
        tree.insert(new Point("far", 200, 200));
        tree.regionSearch(600, 600, 700, 700);
        String output = systemOut().getHistory();
        assertEquals("Points intersecting region (600, 600, 700, 700):\n"
                + "2 quadtree nodes visited\n", output);
    }
}
