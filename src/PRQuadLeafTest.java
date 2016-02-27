import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
 * @author Jazz
 *
 */
public class PRQuadLeafTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Leaf should already have a point,
	 * calls leaf to have another point added
	 */
	@Test
	public void testInsertFirst() {
		Point p = new Point(null, 3, 4);
		PRQuadLeaf le = new PRQuadLeaf(p);
		
		Point k = new Point(null, 2, 3);
		le.insert(p, 2, 3, 9);
		assertEquals(PRQuadLeaf.class, le.getClass());
	}
	
	/**
	 * Leaf should already have two points,
	 * calls leaf to have another point added
	 */
	@Test
	public void testInsertSecond() {
		Point p = new Point(null, 3, 4);
		PRQuadLeaf le = new PRQuadLeaf(p);
		
		Point k = new Point(null, 2, 3);
		le.insert(p, 2, 3, 9);
		
		Point m = new Point(null, 1, 2);
		le.insert(m, 1, 2, 4);
		
		assertEquals(PRQuadLeaf.class, le.getClass());
	}
	
	/**
	 * Leaf should already have three points,
	 * calls leaf to have another point added but not same
	 */
	@Test
	public void testInsertFourthNot() {
		Point p = new Point(null, 3, 4);
		PRQuadLeaf le = new PRQuadLeaf(p);
		
		Point k = new Point(null, 2, 3);
		le.insert(p, 2, 3, 9);
		
		Point m = new Point(null, 1, 2);
		le.insert(m, 1, 2, 4);
		
		Point u = new Point(null, 1, 4);
		le.insert(u, 1, 4, 5);
		
		
		assertEquals(PRQuadLeaf.class, le.getClass());
	}

}
