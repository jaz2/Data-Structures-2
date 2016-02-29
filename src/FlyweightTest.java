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
public class FlyweightTest extends TestCase {
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * Tests when something is inserted
     */
    @Test
    public void testInsert() {
        Flyweight fl = new Flyweight();
        Point p = new Point(null, 3, 3);
        fl.insert(p, 3, 3, 4);
        assertEquals(PRQuadLeaf.class, fl.getInstance().getClass());
    }

}
