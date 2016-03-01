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
public class PRQuadInternalTest extends TestCase {

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * Tests that it returns a leaf in this region
     */
    @Test
    public void testNw() {
        Point p = new Point(null, 4, 5);
        PRQuadInternal i = new PRQuadInternal();
        i.insert(p, 0, 0, 1024);
        assertEquals(PRQuadLeaf.class, i.nw().getClass());
        assertEquals(PRQuadInternal.class, i.getInstance().getClass());
    }

    /**
     * Tests that it returns a leaf in this region
     */
    @Test
    public void testNe() {
        Point p = new Point(null, 1000, 4);
        PRQuadInternal i = new PRQuadInternal();
        i.insert(p, 0, 0, 1024);
        assertEquals(PRQuadLeaf.class, i.ne().getClass());
        assertEquals(PRQuadInternal.class, i.getInstance().getClass());
    }

    /**
     * Tests that it returns a leaf in this region
     */
    @Test
    public void testSw() {
        Point p = new Point(null, 4, 1000);
        PRQuadInternal i = new PRQuadInternal();
        i.insert(p, 0, 0, 1024);
        assertEquals(PRQuadLeaf.class, i.sw().getClass());
        assertEquals(PRQuadInternal.class, i.getInstance().getClass());
    }

    /**
     * Tests that it returns a leaf in this region
     */
    @Test
    public void testSe() {
        Point p = new Point(null, 800, 900);
        PRQuadInternal i = new PRQuadInternal();
        i.insert(p, 0, 0, 1024);
        assertEquals(PRQuadLeaf.class, i.se().getClass());
        assertEquals(PRQuadInternal.class, i.getInstance().getClass());
    }

    public void testRsNw()
    { 
        PRQuadInternal in = new PRQuadInternal();
        Point p = new Point("hi", 800, 900);
        in.insert(p, 0, 0, 1024);
        in.regionSearch(0, 0, 100, 700, 0, 0, 1024);
        in.regionSearch(0, 0, 700, 100, 0, 0, 1024);
        in.regionSearch(0, 0, 100, 100, 0, 0, 1024);
        String output = systemOut().getHistory();
        assertEquals("f", output);
    }


    public void testRSonRecCornerTR()
    {
        Point p = new Point("hi", 800, 600);
        PRQuadtree tree = new PRQuadtree(0, 0, 1024);
        tree.insert(p);
        tree.regionSearch(100, 600, 700, 500);
        String output = systemOut().getHistory();
        assertEquals("Points intersecting region (100, 600, 700, 500):\n"
                + "Point found: (hi, 800, 600)\n"
                + "1 quadtree nodes visited\n", output);
    }

    public void testNWw4points()
    {
        PRQuadtree tree = new PRQuadtree(0, 0, 1024);
        tree.insert(new Point("r1", 1, 20));
        tree.insert(new Point("r2", 600, 20));
        tree.insert(new Point("r34", 1, 600));
        tree.insert(new Point("r9", 600, 600));
        tree.regionSearch(0, 0, 500, 500);
        String output = systemOut().getHistory();
        assertEquals("Points intersecting region (0, 0, 500, 500):\n"
                + "Point found: (r1, 1, 20)\n"
                + "2 quadtree nodes visited\n", output);        
    }

    public void testNEw4points()
    {
        PRQuadtree tree = new PRQuadtree(0, 0, 1024);
        tree.insert(new Point("r1", 1, 20));
        tree.insert(new Point("r2", 600, 20));
        tree.insert(new Point("r34", 1, 600));
        tree.insert(new Point("r9", 600, 600));
        tree.regionSearch(500, 0, 500, 500); 
        String output = systemOut().getHistory();
        assertEquals("Points intersecting region (500, 0, 500, 500):\n"
                + "Point found: (r2, 600, 20)\n"
                + "3 quadtree nodes visited\n", output);        
    }

    public void testSEw4points()
    {
        PRQuadtree tree = new PRQuadtree(0, 0, 1024);
        tree.insert(new Point("r1", 1, 20));
        tree.insert(new Point("r2", 600, 20));
        tree.insert(new Point("r34", 1, 600));
        tree.insert(new Point("r9", 600, 600));
        tree.regionSearch(500, 500, 500, 500);
        String output = systemOut().getHistory();
        assertEquals("Points intersecting region (500, 500, 500, 500):\n"
                + "Point found: (r9, 600, 600)\n"
                + "5 quadtree nodes visited\n", output);        
    }

    public void testSEw4points2()
    {
        PRQuadtree tree = new PRQuadtree(0, 0, 1024);
        tree.insert(new Point("r1", 1, 20));
        tree.insert(new Point("r2", 600, 20));
        tree.insert(new Point("r34", 1, 600));
        tree.insert(new Point("r9", 600, 600));
        tree.regionSearch(580, 580, 500, 500);
        String output = systemOut().getHistory();
        assertEquals("Points intersecting region (580, 580, 500, 500):\n"
                + "Point found: (r9, 600, 600)\n"
                + "2 quadtree nodes visited\n", output);        
    }

    public void testSEw4points3()
    {
        PRQuadtree tree = new PRQuadtree(0, 0, 1024);
        tree.insert(new Point("r1", 1, 20));
        tree.insert(new Point("r2", 600, 20));
        tree.insert(new Point("r34", 1, 600));
        tree.insert(new Point("r9", 600, 600));
        tree.regionSearch(500, 580, 500, 500);
        String output = systemOut().getHistory();
        assertEquals("Points intersecting region (500, 580, 500, 500):\n"
                + "Point found: (r9, 600, 600)\n"
                + "3 quadtree nodes visited\n", output);        
    }
}
