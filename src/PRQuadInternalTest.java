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

	@Test
	public void testNW() {
		Point p = new Point(null, 4, 5);
		PRQuadInternal i = new PRQuadInternal();
		i.insert(p, 4, 5, 1024);
		assertEquals(PRQuadLeaf.class, i.getInstance());
	}

}
