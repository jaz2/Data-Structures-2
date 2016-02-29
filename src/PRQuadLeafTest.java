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
	 * When RX is less than x
	 */
	public void regionSearchRXE()
	{
		Point p = new Point("a", 1, 2);
		PRQuadLeaf lf = new PRQuadLeaf(p);		
		
		assertEquals(1, lf.regionSearch(0, 0, 10, 10, 0, 0, 1024));
	}
	
	/**
	 * When RX is equal to x of node
	 */
	public void regionSearchRXL()
	{
		Point p = new Point("a", 1, 1);
		PRQuadLeaf lf = new PRQuadLeaf(p);		
		
		assertEquals(1, lf.regionSearch(1, 1, 5, 5, 0, 0, 1024));
	}
	
	/**
	 * When RX is greater than x of node
	 */
	public void regionSearchRXG()
	{
		Point p = new Point("a", 1, 2);
		PRQuadLeaf lf = new PRQuadLeaf(p);		
		
		assertEquals(0, lf.regionSearch(100, 100, 10, 10, 0, 0, 1024));
	}
	
	/**
	 * When x is less than rx + rw
	 */
	public void regionSearchXL()
	{
		Point p = new Point("a", 5, 2);
		PRQuadLeaf lf = new PRQuadLeaf(p);		
		
		assertEquals(1, lf.regionSearch(0, 100, 10, 10, 0, 0, 1024));
	}
	
	/**
	 * Tests when x is equal to rx + rw
	 */
	public void regionSearchXE()
	{
		Point p = new Point("a", 10, 2);
		PRQuadLeaf lf = new PRQuadLeaf(p);		
		
		assertEquals(1, lf.regionSearch(5, 100, 5, 10, 0, 0, 1024));
	}
	
	/**
	 * Tests when x is greater than rx + rw
	 */
	public void regionSearchXG()
	{
		Point p = new Point("a", 1000, 2);
		PRQuadLeaf lf = new PRQuadLeaf(p);		
		
		assertEquals(0, lf.regionSearch(100, 100, 10, 10, 0, 0, 1024));
	}
	
	/**
	 * When RY is less than y
	 */
	public void regionSearchRYE()
	{
		Point p = new Point("a", 1, 2);
		PRQuadLeaf lf = new PRQuadLeaf(p);		
		
		assertEquals(1, lf.regionSearch(0, 0, 10, 10, 0, 0, 1024));
	}
	
	/**
	 * When RY is equal to y of node
	 */
	public void regionSearchRYL()
	{
		Point p = new Point("a", 1, 1);
		PRQuadLeaf lf = new PRQuadLeaf(p);		
		
		assertEquals(1, lf.regionSearch(1, 1, 5, 5, 0, 0, 1024));
	}
	
	/**
	 * When RY is greater than y of node
	 */
	public void regionSearchRYG()
	{
		Point p = new Point("a", 1, 2);
		PRQuadLeaf lf = new PRQuadLeaf(p);		
		
		assertEquals(0, lf.regionSearch(0, 100, 10, 10, 0, 0, 1024));
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
