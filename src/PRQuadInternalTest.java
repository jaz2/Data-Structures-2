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
        assertFalse(i.isEmpty());
        assertFalse(i.isLeaf());
    }

    /**
     * Tests that it returns a leaf in this region
     */
    @Test
    public void testSw() {
        Point p = new Point(null, 4, 600);
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
     * Tests the sw y is less
     */
    @Test
    public void testinsertSWYL()
    {
        Point p = new Point(null, 1, 1);
        PRQuadInternal i = new PRQuadInternal();        
        i.insert(p, 0, 0, 1024);
        assertEquals(Flyweight.class, i.sw().getClass());
        assertEquals(Flyweight.class, i.se().getClass());
    }

    /**
     * Tests the sw when y is greater
     */
    @Test
    public void testinsertSWYG()
    {
        Point p = new Point(null, 1, 700);
        PRQuadInternal i = new PRQuadInternal();        
        i.insert(p, 0, 0, 1024);
        assertEquals(PRQuadLeaf.class, i.sw().getClass());
        assertEquals(Flyweight.class, i.se().getClass());
    }

    /**
     * Tests when y is equal
     */
    @Test
    public void testinsertSWYE()
    {
        Point p = new Point(null, 1, 512);
        PRQuadInternal i = new PRQuadInternal();        
        i.insert(p, 0, 0, 1024);
        assertEquals(Flyweight.class, i.sw().getClass());
        assertEquals(Flyweight.class, i.se().getClass());
    }

    /**
     * Tests when first case is true but last case is false
     */
    @Test
    public void testinsertSWYF()
    {
        Point p = new Point(null, 1, 500);
        PRQuadInternal i = new PRQuadInternal();        
        i.insert(p, 0, 0, 1024);
        assertEquals(Flyweight.class, i.sw().getClass());
        assertEquals(Flyweight.class, i.se().getClass());
    }

    /**
     * Tests the region search 
     */
    @Test
    public void testRSonRecCornerTR()
    {
        Point p = new Point("hi", 800, 600);
        PRQuadtree tree = new PRQuadtree(0, 0, 1024);
        tree.insert(p);
        tree.regionSearch(100, 600, 700, 500);
        String output = systemOut().getHistory();
        assertEquals("Points intersecting region (100, 600, 700, 500):\n"
                + "Point found: (hi, 800, 600)\n"
                + "1 quadtree nodes visited\n", output);
    }

    /**
     * Tests the region search nw
     */
    @Test
    public void testNWw4points()
    {
        PRQuadtree tree = new PRQuadtree(0, 0, 1024);
        tree.insert(new Point("r1", 1, 20));
        tree.insert(new Point("r2", 600, 20));
        tree.insert(new Point("r34", 1, 600));
        tree.insert(new Point("r9", 600, 600));
        tree.regionSearch(0, 0, 500, 500);
        String output = systemOut().getHistory();
        assertEquals("Points intersecting region (0, 0, 500, 500):\n"
                + "Point found: (r1, 1, 20)\n"
                + "2 quadtree nodes visited\n", output);        
    }

    /**
     * Tests the NE regionsearch
     */
    @Test
    public void testNEw4points()
    {
        PRQuadtree tree = new PRQuadtree(0, 0, 1024);
        tree.insert(new Point("r1", 1, 20));
        tree.insert(new Point("r2", 600, 20));
        tree.insert(new Point("r34", 1, 600));
        tree.insert(new Point("r9", 600, 600));
        tree.regionSearch(500, 0, 500, 500); 
        String output = systemOut().getHistory();
        assertEquals("Points intersecting region (500, 0, 500, 500):\n"
                + "Point found: (r2, 600, 20)\n"
                + "3 quadtree nodes visited\n", output);        
    }

    /**
     * Tests the SW regionSearch and insert
     */
    @Test
    public void testSWw4points()
    {
        PRQuadtree tree = new PRQuadtree(0, 0, 1024);
        tree.insert(new Point("r1", 1, 20));
        tree.insert(new Point("r2", 600, 20));
        tree.insert(new Point("r34", 1, 600));
        tree.insert(new Point("r9", 600, 600));
        tree.regionSearch(0, 500, 500, 500); 
        String output = systemOut().getHistory();
        assertEquals("Points intersecting region (0, 500, 500, 500):\n"
                + "Point found: (r34, 1, 600)\n"
                + "3 quadtree nodes visited\n", output); 
    }

    /**
     * Tests the SE regionSearch
     */
    @Test
    public void testSEw4points()
    {
        PRQuadtree tree = new PRQuadtree(0, 0, 1024);
        tree.insert(new Point("r1", 1, 20));
        tree.insert(new Point("r2", 600, 20));
        tree.insert(new Point("r34", 1, 600));
        tree.insert(new Point("r9", 600, 600));
        tree.regionSearch(500, 500, 500, 500);
        String output = systemOut().getHistory();
        assertEquals("Points intersecting region (500, 500, 500, 500):\n"
                + "Point found: (r9, 600, 600)\n"
                + "5 quadtree nodes visited\n", output);        
    }

    /** 
     * Tests the SE region search with 2 visited
     */
    @Test
    public void testSEw4points2()
    {
        PRQuadtree tree = new PRQuadtree(0, 0, 1024);
        tree.insert(new Point("r1", 1, 20));
        tree.insert(new Point("r2", 600, 20));
        tree.insert(new Point("r34", 1, 600));
        tree.insert(new Point("r9", 600, 600));
        tree.regionSearch(580, 580, 500, 500);
        String output = systemOut().getHistory();
        assertEquals("Points intersecting region (580, 580, 500, 500):\n"
                + "Point found: (r9, 600, 600)\n"
                + "2 quadtree nodes visited\n", output);        
    }

    /**
     * Tests the SE with 3 visited
     */
    @Test
    public void testSEw4points3()
    {
        PRQuadtree tree = new PRQuadtree(0, 0, 1024);
        tree.insert(new Point("r1", 1, 20));
        tree.insert(new Point("r2", 600, 20));
        tree.insert(new Point("r34", 1, 600));
        tree.insert(new Point("r9", 600, 600));
        tree.regionSearch(500, 580, 500, 500);
        String output = systemOut().getHistory();
        assertEquals("Points intersecting region (500, 580, 500, 500):\n"
                + "Point found: (r9, 600, 600)\n"
                + "3 quadtree nodes visited\n", output);        
    }
    
    /**
     * Tests the remove method 
     */
    @Test
    public void testRemove1()
    {
        PRQuadtree t = new PRQuadtree(0, 0, 1024);
        t.insert(new Point("r1", 1, 20));
        t.insert(new Point("r2", 600, 20));
        t.insert(new Point("r34", 1, 600));
        t.insert(new Point("r9", 600, 600));
        t.remove("r9", 600, 600);
        t.regionSearch(500, 580, 500, 500);
        String output = systemOut().getHistory();
        assertEquals("Points intersecting region (500, 580, 500, 500):\n"
                + "1 quadtree nodes visited\n", output);   
    }
    
    /**
     * Tests when remove is in the ne section
     */
    @Test
    public void testRemoveNEYes()
    {
        PRQuadtree tree = new PRQuadtree(0, 0, 1024);
        tree.insert(new Point("r1", 1, 20));
        tree.insert(new Point("r2", 600, 20));
        tree.insert(new Point("r34", 1, 600));
        tree.insert(new Point("r9", 600, 600));
        tree.remove("r2", 600, 20);
        tree.regionSearch(500, 0, 500, 500); 
        String output = systemOut().getHistory();
        assertEquals("Points intersecting region (500, 0, 500, 500):\n"
                + "1 quadtree nodes visited\n", output);      
    }

    /**
     * Tests first merge
     */
    @Test
    public void testMerge1()
    {
        PRQuadtree tree = new PRQuadtree(0, 0, 1024);
        tree.insert(new Point("r_r", 5, 5));
        tree.insert(new Point("rec", 5, 600));
        tree.insert(new Point("r_42", 600, 5));
        tree.insert(new Point("far", 600, 600));
        tree.insert(new Point("a", 5, 5));
        tree.insert(new Point("b", 5, 600));
        tree.insert(new Point("c", 600, 5));
        tree.insert(new Point("d", 600, 600));
        tree.insert(new Point("aa", 5, 5));
        tree.insert(new Point("bb", 5, 600));
        tree.insert(new Point("cc", 600, 5));
        tree.insert(new Point("dd", 600, 600));
        tree.insert(new Point("a2", 4, 5));
        tree.insert(new Point("b2", 3, 600));
        tree.insert(new Point("c2", 601, 5));
        tree.insert(new Point("d2", 601, 600));
        tree.root.merge();
        assertEquals(tree.root.getClass(), PRQuadInternal.class);
    }

    /**
     * Tests second merge
     */
    @Test
    public void testMerge2()
    {
        PRQuadtree tree = new PRQuadtree(0, 0, 1024);
        tree.insert(new Point("r_r", 5, 5));
        tree.insert(new Point("rec", 5, 600));
        tree.insert(new Point("r_42", 600, 5));
        tree.insert(new Point("far", 600, 600));
        tree.insert(new Point("a", 5, 5));
        tree.insert(new Point("b", 5, 600));
        tree.insert(new Point("c", 600, 5));
        tree.insert(new Point("d", 600, 600));
        tree.insert(new Point("aa", 5, 5));
        tree.insert(new Point("bb", 5, 600));
        tree.insert(new Point("cc", 600, 5));
        tree.insert(new Point("dd", 600, 600));
        //    tree.insert(new Point("a2", 4, 5));
        tree.insert(new Point("b2", 3, 600));
        tree.insert(new Point("c2", 601, 5));
        tree.insert(new Point("d2", 601, 600));
        tree.root.merge();
        assertEquals(tree.root.getClass(), PRQuadInternal.class);
    }

    /**
     * Tests merge again
     */
    @Test
    public void testMerge3()
    {
        PRQuadtree tree = new PRQuadtree(0, 0, 1024);
        tree.insert(new Point("r_r", 5, 5));
        tree.insert(new Point("rec", 5, 600));
        tree.insert(new Point("r_42", 600, 5));
        tree.insert(new Point("far", 600, 600));
        tree.insert(new Point("a", 5, 5));
        tree.insert(new Point("b", 5, 600));
        tree.insert(new Point("c", 600, 5));
        tree.insert(new Point("d", 600, 600));
        tree.insert(new Point("aa", 5, 5));
        tree.insert(new Point("bb", 5, 600));
        tree.insert(new Point("cc", 600, 5));
        tree.insert(new Point("dd", 600, 600));
        //    tree.insert(new Point("a2", 4, 5));
        //    tree.insert(new Point("b2", 3, 600));
        //    tree.insert(new Point("c2", 601, 5));
        tree.insert(new Point("d2", 601, 600));
        tree.root.merge();
        assertEquals(tree.root.getClass(), PRQuadInternal.class);
    }

    /**
     * Tests the Merge method
     */
    @Test
    public void testMerge4()
    {
        PRQuadtree tree = new PRQuadtree(0, 0, 1024);
        tree.insert(new Point("r_r", 5, 5));
        tree.insert(new Point("rec", 5, 600));
        tree.insert(new Point("r_42", 600, 5));
        tree.insert(new Point("far", 600, 600));
        tree.insert(new Point("a", 5, 5));
        tree.insert(new Point("b", 5, 600));
        tree.insert(new Point("c", 600, 5));
        tree.insert(new Point("d", 600, 600));
        tree.insert(new Point("aa", 5, 5));
        tree.insert(new Point("bb", 5, 600));
        tree.insert(new Point("cc", 600, 5));
        tree.insert(new Point("dd", 600, 600));
        tree.insert(new Point("b2", 3, 600));
        tree.insert(new Point("d2", 601, 600));
        tree.root.merge();
        assertEquals(tree.root.getClass(), PRQuadInternal.class);
    }

    /**
     * Tests merge leaf
     */
    @Test
    public void testMerge1leaf()
    {
        PRQuadtree tree = new PRQuadtree(0, 0, 1024);
        tree.insert(new Point("r_r", 5, 5));
        tree.insert(new Point("a", 5, 5));
        tree.insert(new Point("aa", 5, 5));
        tree.insert(new Point("a2", 4, 5));
        tree.remove("a2", 4, 5);
        tree.root.merge();
        assertEquals(tree.root.getClass(), PRQuadLeaf.class);
    }

    /**
     * Tests merge for a new leaf
     */
    @Test
    public void testMergeNewLeaf()
    {
        PRQuadtree tree = new PRQuadtree(0, 0, 1024);
        tree.insert(new Point("r_r", 5, 600)); 
        tree.insert(new Point("r_r", 5, 600)); 
        tree.insert(new Point("a", 5, 5));
        tree.insert(new Point("aa", 600, 5));
        tree.insert(new Point("a2", 4, 5));
        tree.remove("a2", 4, 5);
        tree.root.merge();
        assertEquals(tree.root.getClass(), PRQuadInternal.class);
    }
}
