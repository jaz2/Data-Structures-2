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
		le.insert(k, 0, 0, 1024);
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
		le.insert(k, 0, 0, 1024);
		
		Point m = new Point(null, 1, 2);
		le.insert(m, 0, 0, 1024);
		
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
		le.insert(k, 0, 0, 1024);
		
		Point m = new Point(null, 1, 2);
		le.insert(m, 0, 0, 1024);
		
		Point u = new Point(null, 1, 4);
		le.insert(u, 0, 0, 1024);		
		
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
		le.insert(k, 0, 0, 1024);
		
		Point m = new Point(null, 3, 4);
		le.insert(m, 0, 0, 1024);
		
		Point u = new Point(null, 1, 4);
		le.insert(u, 0, 0, 1024);		
		
		assertEquals(PRQuadInternal.class, le.getInstance().getClass());
	}
	
	/**
	 * When the first item in list
	 * is not the same as point to be added, no
	 */
	public void testInsertFourthMehN()
	{
		Point p = new Point(null, 3, 4);
		PRQuadLeaf le = new PRQuadLeaf(p);
		
		Point k = new Point(null, 3, 4);
		le.insert(k, 0, 0, 1024);
		
		Point m = new Point(null, 3, 4);
		le.insert(m, 0, 0, 1024);
		
		Point j = new Point(null, 3, 4);
		le.insert(j, 0, 0, 1024);
		
		Point u = new Point(null, 1, 4);
		le.insert(u, 0, 0, 1024);		
		
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
		le.insert(k, 0, 0, 1024);
		
		Point m = new Point(null, 3, 4);
		le.insert(m, 0, 0, 1024);
		
		Point u = new Point(null, 3, 4);
		le.insert(u, 0, 0, 1024);		
		
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
		le.insert(k, 0, 0, 1024);
		
		Point m = new Point(null, 3, 4);
		le.insert(m, 0, 0, 1024);
		
		Point u = new Point(null, 3, 4);
		le.insert(u, 0, 0, 1024);	
		
		Point j = new Point(null, 3, 4);
		le.insert(j, 0, 0, 1024);	
		
		assertEquals(PRQuadLeaf.class, le.getInstance().getClass());
	}	
	
	/**
	 * Tests when 2 are the same 
	 * for duplicates
	 */
	public void testDup2same()
	{
		PRQuadtree tree = new PRQuadtree(0, 0, 1024);
		tree.insert(new Point("r_r", 1, 20));
		tree.insert(new Point("rec", 10, 30));
		tree.insert(new Point("r_42", 1, 20));
		tree.insert(new Point("far", 200, 200));
		tree.duplicates();
		String output = systemOut().getHistory();
		assertEquals("Duplicate points:\n"
			+ "(1, 20)\n", output);
	}
	
	/**
	 * Tests duplicates when empty
	 */
	public void testDupEmpty()
	{
		PRQuadtree tree = new PRQuadtree(0, 0, 1024);
		tree.duplicates();
		String output = systemOut().getHistory();
		assertEquals("Duplicate points:\n", output);
	}
	
	/**
	 * Tests duplicates with 1 point
	 */
	public void testDup1Point()
	{
		PRQuadtree tree = new PRQuadtree(0, 0, 1024);
		tree.insert(new Point("far", 200, 200));
		tree.duplicates();
		String output = systemOut().getHistory();
		assertEquals("Duplicate points:\n", output);
	}
	
	/**
	 * Test duplicates with same 
	 */
	public void testDupLotsSame()
	{
		PRQuadtree tree = new PRQuadtree(0, 0, 1024);
		Point p = new Point("ayy", 0, 12);
		tree.insert(p);
		tree.insert(p);
		tree.insert(p);
		tree.insert(p);
		tree.insert(p);
		tree.insert(p);
		tree.duplicates();
		String output = systemOut().getHistory();
		assertEquals("Duplicate points:\n"
			+ "(0, 12)\n", output);
	}
	
	/**
	 * Tests duplicates with internal
	 */
	public void testDupWithInternal()
	{
		PRQuadtree tree = new PRQuadtree(0, 0, 1024);
		Point p = new Point("ayy", 0, 12);
		tree.insert(new Point("r_r", 1, 20));
		tree.insert(new Point("rec", 10, 30));
		tree.insert(new Point("r_42", 1, 20));
		tree.insert(new Point("far", 200, 200));
		tree.insert(new Point("r_r", 1, 20));
		tree.insert(new Point("rec", 36, 30));
		tree.insert(new Point("r_42", 1, 42));
		tree.insert(new Point("far", 200, 200));
		tree.insert(p);
		tree.duplicates();
		String output = systemOut().getHistory();
		assertEquals("Duplicate points:\n"
			+ "(1, 20)\n" + "(200, 200)\n", output);
	}
}
