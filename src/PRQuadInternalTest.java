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
}
