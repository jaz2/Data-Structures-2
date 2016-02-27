import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import student.TestCase;

/**
 * 
 */

/**
 * @author Jazmine Zurita and Jessica McCready
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
    public void testNW() {
        Point p = new Point(null, 4, 5);
        PRQuadInternal i = new PRQuadInternal();
        i.insert(p, 4, 5, 1024);
        assertEquals(PRQuadLeaf.class, i.NW().getClass());
        assertEquals(PRQuadLeaf.class, i.getInstance().getClass());
    }

    /**
     * Tests that it returns a leaf in this region
     */
    @Test
    public void testNE() {
        Point p = new Point(null, 1000, 4);
        PRQuadInternal i = new PRQuadInternal();
        i.insert(p, 1000, 4, 20);
        assertEquals(PRQuadLeaf.class, i.NE().getClass());
        assertEquals(PRQuadLeaf.class, i.getInstance().getClass());
    }
    
    /**
     * Tests that it returns a leaf in this region
     */
    @Test
    public void testSW() {
        Point p = new Point(null, 4, 900);
        PRQuadInternal i = new PRQuadInternal();
        i.insert(p, 4, 900, 40);
        assertEquals(PRQuadLeaf.class, i.getInstance().getClass());
    }
    
    /**
     * Tests that it returns a leaf in this region
     */
    @Test
    public void testSE() {
        Point p = new Point(null, 800, 500);
        PRQuadInternal i = new PRQuadInternal();
        i.insert(p, 800, 500, 100);
        assertEquals(PRQuadLeaf.class, i.getInstance().getClass());
    }
}
