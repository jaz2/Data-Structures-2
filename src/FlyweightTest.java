import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import student.TestCase;

/**
 * 
 */

/**
 * @author Jazz
 *
 */
public class FlyweightTest extends TestCase{

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testInsert() {
		Flyweight fl = new Flyweight();
		Point p = new Point(null, 3, 3);
		fl.insert(p, 3, 3, 4);
		assertTrue(fl.equals(PRQuadLeaf.class));
	}

}
