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
public class PRQuadLeafTest extends TestCase{

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
		le.insert(k, 2, 3, 9);
		assertEquals(PRQuadLeaf.class, le.getInstance().getClass());
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
		le.insert(k, 2, 3, 9);
		
		Point m = new Point(null, 1, 2);
		le.insert(m, 1, 2, 4);
		
		assertEquals(PRQuadLeaf.class, le.getInstance().getClass());
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
		le.insert(k, 2, 3, 9);
		
		Point m = new Point(null, 1, 2);
		le.insert(m, 1, 2, 4);
		
		Point u = new Point(null, 1, 4);
		le.insert(u, 1, 4, 5);		
		
		assertEquals(PRQuadInternal.class, le.getInstance().getClass());
	}
	
	/**
	 * Leaf should already have three identical points,
	 * calls leaf to have another point added but not same
	 */
	@Test
	public void testInsertFourthNot2() {
		Point p = new Point(null, 3, 4);
		PRQuadLeaf le = new PRQuadLeaf(p);
		
		Point k = new Point(null, 3, 4);
		le.insert(k, 3, 4, 9);
		
		Point m = new Point(null, 3, 4);
		le.insert(m, 3, 4, 4);
		
		Point u = new Point(null, 1, 4);
		le.insert(u, 3, 4, 5);		
		
		assertEquals(PRQuadInternal.class, le.getInstance().getClass());
	}
	
	/**
	 * Leaf should already have three identical points,
	 * calls leaf to have another point added that is same
	 */
	@Test
	public void testInsertFourthYes() {
		Point p = new Point(null, 3, 4);
		PRQuadLeaf le = new PRQuadLeaf(p);
		
		Point k = new Point(null, 3, 4);
		le.insert(k, 3, 4, 9);
		
		Point m = new Point(null, 3, 4);
		le.insert(m, 3, 4, 4);
		
		Point u = new Point(null, 3, 4);
		le.insert(u, 3, 4, 5);		
		
		assertEquals(PRQuadLeaf.class, le.getInstance().getClass());
	}

	/**
	 * Leaf should already have four identical points,
	 * calls leaf to have another point added that is same
	 */
	@Test
	public void testInsertFifthYes() {
		Point p = new Point(null, 3, 4);
		PRQuadLeaf le = new PRQuadLeaf(p);
		
		Point k = new Point(null, 3, 4);
		le.insert(k, 3, 4, 9);
		
		Point m = new Point(null, 3, 4);
		le.insert(m, 3, 4, 4);
		
		Point u = new Point(null, 3, 4);
		le.insert(u, 3, 4, 5);	
		
		Point j = new Point(null, 3, 4);
		le.insert(j, 3, 4, 5);	
		
		assertEquals(PRQuadLeaf.class, le.getInstance().getClass());
	}	
}
