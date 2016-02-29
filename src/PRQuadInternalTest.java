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
        Point p = new Point(null, 4, 900);
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
    
    /**
     * Tests the region search in the internal
     */
    @Test
    public void testRegSearc()
    {
         Point p = new Point("hi", 800, 900);
         PRQuadInternal in = new PRQuadInternal();
         in.insert(p, 0, 0, 1024);
         in.regionSearch(800, 900, 4, 80, 0, 0, 1024);
         String output = systemOut().getHistory();
         assertEquals("Points intersecting region (800,900, 4, 80):\n" 
                   + "Point not found: (hi, 800, 900)\n"
                   + "2 quadtree nodes visited", output);
    }
}
