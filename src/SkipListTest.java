import static org.junit.Assert.*;

import student.TestCase;
import student.TestableRandom;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
 * @author Jazmine Zurita and Jessica McCready
 * @version Feb 02 2016
 *
 */
public class SkipListTest extends TestCase
{
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * Tests the insert in SkipList
     */
    @Test
    public void testInsert() {
        Point re = new Point("a", 1, 2);
        KVPair<String, Point> p = new KVPair<String, Point>(re.getName(), re);
        SkipList<String, Point> s = new SkipList<String, Point>();
        assertTrue(s.insert(p));
        assertEquals(null, s.head.element());
    }

    /**
     * Tests when insert is not null
     */
    @Test
    public void testInsertMore()
    {
        Point re = new Point("a", 1, 2);
        KVPair<String, Point> p = new KVPair<String, Point>(re.getName(), re);
        SkipList<String, Point> s = new SkipList<String, Point>();
        s.insert(p);

        Point uh = new Point("b", 3, 4);
        KVPair<String, Point> k = new KVPair<String, Point>(uh.getName(), uh);
        s.insert(k);
        assertEquals(null, s.head.element());
    }

    /**
     * Tests remove by coord when succesful
     */
    @Test
    public void testRemoveCoordYes()
    {
        SkipList<String, Point> s = new SkipList<String, Point>();
        Point y = new Point("a", 0, 1);
        KVPair<String, Point> l = new KVPair<String, Point>(y.getName(), y);
        s.insert(l);

        Point re = new Point("b", 1, 2);
        KVPair<String, Point> p = new KVPair<String, 
                Point>(re.getName(), re);        
        s.insert(p);

        Point f = new Point("f", 5, 200);
        KVPair<String, Point> g = new KVPair<String, Point>(f.getName(), f);
        s.insert(g);

        s.removeByCoord(re);
        String output = systemOut().getHistory();
        assertFuzzyEquals("Point removed: (b, 1, 2)", output);
    }

    /**
     * Tests when there is more than one instance
     */
    @Test
    public void testRemoveCoordMult()
    {
        SkipList<String, Point> s = new SkipList<String, Point>();

        Point i = new Point("q", 0, 0);
        KVPair<String, Point> w = new KVPair<String, Point>(i.getName(), i);
        s.insert(w);

        Point re = new Point("a", 1, 2);
        KVPair<String, Point> p = new KVPair<String, Point>(re.getName(), re);

        s.insert(p);

        Point nu = new Point("a", 2, 4);
        KVPair<String, Point> m = new KVPair<String, Point>(nu.getName(), nu);
        s.insert(m);

        Point eh = new Point("k", 6, 10);
        KVPair<String, Point> n = new KVPair<String, Point>(eh.getName(), eh);
        s.insert(n);

        s.removeByCoord(re);
        String output = systemOut().getHistory();
        assertFuzzyEquals("Point removed: (a, 1, 2)", output);
    }

    /**
     * Tests when two Point have same dimensions 
     * but different names
     */
    public void testRemoveCoordDouble()
    {
        SkipList<String, Point> s = new SkipList<String, Point>();

        Point i = new Point("a", 1, 1);
        KVPair<String, Point> w = new KVPair<String, Point>(i.getName(), i);
        s.insert(w);

        Point re = new Point("b", 1, 1);
        KVPair<String, Point> p = new KVPair<String, Point>(re.getName(), re);

        s.insert(p);

        Point nu = new Point("c", 2, 4);
        KVPair<String, Point> m = new KVPair<String, Point>(nu.getName(), nu);
        s.insert(m);

        Point eh = new Point("k", 6, 10);
        KVPair<String, Point> n = new KVPair<String, Point>(eh.getName(), eh);
        s.insert(n);

        s.removeByCoord(i);
        String output = systemOut().getHistory();
        assertFuzzyEquals("Point removed: (a, 1, 1)", output);
    }
    
    /**
     * Tests when you cannot find something
     * in remove
     */
    @Test
    public void testRemoveCoordNah()
    {
        Point re = new Point("a", 1, 2);
        KVPair<String, Point> p = new KVPair<String, Point>(re.getName(), re);
        SkipList<String, Point> s = new SkipList<String, Point>();
        s.insert(p);
        
        Point m = new Point(null, 1, 2);

        s.removeByCoord(m);
        String outt = systemOut().getHistory();
        assertFuzzyEquals("Point not removed: (1, 2)", outt);
    }
    
    /**
     * Tests when you cannot find something but the x 
     * is equal in remove
     *
     */
    @Test
    public void testRemoveCoordNahX()
    {
        Point re = new Point("a", 1, 5);
        KVPair<String, Point> p = new KVPair<String, Point>(re.getName(), re);
        SkipList<String, Point> s = new SkipList<String, Point>();
        s.insert(p);
        
        Point m = new Point(null, 1, 2);

        s.removeByCoord(m);
        String outt = systemOut().getHistory();
        assertFuzzyEquals("Point not removed: (1, 2)", outt);
    }
    
    /**
     * Tests when you cannot find something but the y 
     * is equal in remove
     *
     */
    @Test
    public void testRemoveCoordNahY()
    {
        Point re = new Point("a", 1, 2);
        KVPair<String, Point> p = new KVPair<String, Point>(re.getName(), re);
        SkipList<String, Point> s = new SkipList<String, Point>();
        s.insert(p);
        
        Point m = new Point(null, 1, 2);

        s.removeByCoord(m);
        String outt = systemOut().getHistory();
        assertFuzzyEquals("Point not removed: (1, 2)", outt);
    }
    
    /**
     * Tests when you cannot find something but the width 
     * is equal in remove
     *
     */
    @Test
    public void testRemoveCoordNahW()
    {
        Point re = new Point("a", 1, 2);
        KVPair<String, Point> p = new KVPair<String, Point>(re.getName(), re);
        SkipList<String, Point> s = new SkipList<String, Point>();
        s.insert(p);
        
        Point m = new Point(null, 1, 2);

        s.removeByCoord(m);
        String outt = systemOut().getHistory();
        assertFuzzyEquals("Point not removed: (1, 2)", outt);
    }   

    /**
     * Tests when x.forward[i] is null
     */
    @Test
    public void testRemoveCoordNull()
    {
        SkipList<String, Point> s = new SkipList<String, Point>();
        Point hm = new Point(null, 1, 2);
        s.removeByCoord(hm);
        String output = systemOut().getHistory();
        assertFuzzyEquals("Point not removed: (1, 2)", output);
    }

    /**
     * Tests remove by name when successful
     */
    @Test
    public void testRemoveNameYasM()
    {
        SkipList<String, Point> s = new SkipList<String, Point>();
        Point y = new Point("a", 0, 1);
        KVPair<String, Point> l = new KVPair<String, Point>(y.getName(), y);
        s.insert(l);

        Point re = new Point("b", 1, 2);
        KVPair<String, Point> p = new KVPair<String, 
                Point>(re.getName(), re);        
        s.insert(p);

        Point f = new Point("f", 5, 200);
        KVPair<String, Point> g = new KVPair<String, Point>(f.getName(), f);
        s.insert(g);

        s.removeByName("a");
        String output = systemOut().getHistory();
        assertFuzzyEquals("Point removed: (a, 0, 1)", output);
    }
    
    /**
     * Tests remove by name when successful on first
     * element
     */
    @Test
    public void testRemoveNameYasF()
    {
        SkipList<String, Point> s = new SkipList<String, Point>();
        Point y = new Point("a", 0, 1);
        KVPair<String, Point> l = new KVPair<String, Point>(y.getName(), y);
        s.insert(l);

        Point re = new Point("b", 1, 2);
        KVPair<String, Point> p = new KVPair<String, 
                Point>(re.getName(), re);        
        s.insert(p);

        Point f = new Point("f", 5, 200);
        KVPair<String, Point> g = new KVPair<String, Point>(f.getName(), f);
        s.insert(g);

        s.removeByName("b");
        String output = systemOut().getHistory();
        assertFuzzyEquals("Point removed: (b, 1, 2)", output);
    }
    
    /**
     * Tests remove by name when successful on last 
     * element
     */
    @Test
    public void testRemoveNameYasL()
    {
        SkipList<String, Point> s = new SkipList<String, Point>();
        Point y = new Point("a", 0, 1);
        KVPair<String, Point> l = new KVPair<String, Point>(y.getName(), y);
        s.insert(l);

        Point re = new Point("b", 1, 2);
        KVPair<String, Point> p = new KVPair<String, 
                Point>(re.getName(), re);        
        s.insert(p);

        Point f = new Point("f", 5, 200);
        KVPair<String, Point> g = new KVPair<String, Point>(f.getName(), f);
        s.insert(g);

        s.removeByName("f");
        String output = systemOut().getHistory();
        assertFuzzyEquals("Point removed: (f, 5, 200)", output);
    }

    /**
     * Tests when there is more than one instance
     */
    @Test
    public void testRemoveNameMult()
    {
        SkipList<String, Point> s = new SkipList<String, Point>();

        Point i = new Point("q", 0, 0);
        KVPair<String, Point> w = new KVPair<String, Point>(i.getName(), i);
        s.insert(w);

        Point re = new Point("a", 1, 2);
        KVPair<String, Point> p = new KVPair<String, Point>(re.getName(), re);

        s.insert(p);

        Point nu = new Point("a", 2, 4);
        KVPair<String, Point> m = new KVPair<String, Point>(nu.getName(), nu);
        s.insert(m);

        Point eh = new Point("k", 6, 10);
        KVPair<String, Point> n = new KVPair<String, Point>(eh.getName(), eh);
        s.insert(n);

        s.removeByName("a");
        String output = systemOut().getHistory();
        assertFuzzyEquals("Point removed: (a, 2, 4)", output);
    }

    /**
     * Tests when you cannot find something
     * in remove
     */
    @Test
    public void testRemoveNameNah()
    {
        Point re = new Point("a", 1, 2);
        KVPair<String, Point> p = new KVPair<String, Point>(re.getName(), re);
        SkipList<String, Point> s = new SkipList<String, Point>();
        s.insert(p);

        s.removeByName("b");
        String outt = systemOut().getHistory();
        assertFuzzyEquals("Point not found: b", outt);
    }
    
    /**
     * Tests when you cannot find something
     * in remove checking compareTo
     */
    @Test
    public void testRemoveNameNah2()
    {
        Point re = new Point("b", 1, 2);
        KVPair<String, Point> p = new KVPair<String, Point>(re.getName(), re);
        SkipList<String, Point> s = new SkipList<String, Point>();
        s.insert(p);
        s.removeByName("a");
        String outt = systemOut().getHistory();
        assertFuzzyEquals("Point not found: a", outt);
    }

    /**
     * Tests when x.forward[i] is null
     */
    @Test
    public void testRemoveNameNull()
    {
        SkipList<String, Point> s = new SkipList<String, Point>();
        s.removeByName("roar");
        String output = systemOut().getHistory();
        assertFuzzyEquals("Point not found: roar", output);
    }
    
    /**
     * tests when the element should be in middle but not
     */
    public void testSearch270()
    {
        Point re = new Point("a", 1, 2);
        KVPair<String, Point> p = new KVPair<String, Point>(re.getName(), re);
        SkipList<String, Point> s = new SkipList<String, Point>();
        s.insert(p);

        Point nu = new Point("c", 2, 2);
        KVPair<String, Point> n = new KVPair<String, Point>(nu.getName(), nu);
        s.insert(n);
        
        Point or = new Point("d", 2, 8);
        KVPair<String, Point> me = new KVPair<String, Point>(or.getName(), or);
        s.insert(me);
        s.search("b");
        String output = systemOut().getHistory();
        assertFuzzyEquals("Point not found: b", output);
    }

    /**
     * Tests when multiple searches then other stuff
     */
    public void testSearchSame4()
    {
        Point re = new Point("a", 1, 2);
        KVPair<String, Point> p = new KVPair<String, Point>(re.getName(), re);
        SkipList<String, Point> s = new SkipList<String, Point>();
        s.insert(p);

        Point nu = new Point("a", 2, 2);
        KVPair<String, Point> n = new KVPair<String, Point>(nu.getName(), nu);
        s.insert(n);
        
        Point or = new Point("a", 2, 8);
        KVPair<String, Point> me = new KVPair<String, Point>(or.getName(), or);
        s.insert(me);
        
        Point or1 = new Point("b", 2, 8);
        KVPair<String, Point> me1 = new KVPair<String, Point>(or1.getName(), or1);
        s.insert(me1);
        
        s.search("a");
        String output = systemOut().getHistory();
        assertFuzzyEquals("(a, 2, 8)\n"
                + "(a, 2, 2)\n"
                + "(a, 1, 2)", output);
    }
    
    /**
     * Tests search when not found
     */
    @Test
    public void testSearchNot()
    {
        Point re = new Point("a", 1, 2);
        KVPair<String, Point> p = new KVPair<String, Point>(re.getName(), re);
        SkipList<String, Point> s = new SkipList<String, Point>();
        s.insert(p);
        s.search("b");
        String output = systemOut().getHistory();
        assertFuzzyEquals("Point not found: b", output);
    }

    /**
     * Tests when x.forward[i] is null
     */
    @Test
    public void testSearchNull()
    {
        SkipList<String, Point> s = new SkipList<String, Point>();
        s.search("roar");
        String output = systemOut().getHistory();
        assertFuzzyEquals("Point not found: roar", output);
    }

    /**
     * Tests when search is successful
     * and when you add another not found
     */
    @Test
    public void testSearchYes()
    {
        Point re = new Point("a", 1, 2);
        KVPair<String, Point> p = new KVPair<String, Point>(re.getName(), re);
        SkipList<String, Point> s = new SkipList<String, Point>();
        s.insert(p);
        s.search("a");
        String output = systemOut().getHistory();
        assertFuzzyEquals("(a, 1, 2)", output);
    }

    /**
     * Tests when search is successful
     * and when you add another not found
     */
    @Test
    public void testSearchNah()
    {
        Point re = new Point("a", 1, 2);
        KVPair<String, Point> p = new KVPair<String, Point>(re.getName(), re);
        SkipList<String, Point> s = new SkipList<String, Point>();
        s.insert(p);

        s.search("b");
        String outt = systemOut().getHistory();
        assertFuzzyEquals("Point not found: b", outt);
    }


    /**
     * Tests when search is the same
     */
    @Test
    public void testSearchSame()
    {
        Point re = new Point("a", 1, 2);
        KVPair<String, Point> p = new KVPair<String, Point>(re.getName(), re);
        SkipList<String, Point> s = new SkipList<String, Point>();
        s.insert(p);

        Point nu = new Point("a", 2, 2);
        KVPair<String, Point> n = new KVPair<String, Point>(nu.getName(), nu);
        s.insert(n);
        s.search("a");
        String output = systemOut().getHistory();
        assertFuzzyEquals("(a, 2, 2)\n"
                + "(a, 1, 2)", output);
    }

    /**
     * Tests when search is the and continues to search
     */
    @Test
    public void testSearchSame3()
    {
        Point re = new Point("a", 1, 2);
        KVPair<String, Point> p = new KVPair<String, Point>(re.getName(), re);
        SkipList<String, Point> s = new SkipList<String, Point>();
        s.insert(p);

        Point nu = new Point("a", 2, 2);
        KVPair<String, Point> n = new KVPair<String, Point>(nu.getName(), nu);
        s.insert(n);

        Point or = new Point("a", 2, 8);
        KVPair<String, Point> me = new KVPair<String, Point>(or.getName(), or);
        s.insert(me);

        s.search("a");
        String output = systemOut().getHistory();
        assertFuzzyEquals("(a, 2, 8)\n"
                + "(a, 2, 2)\n"
                + "(a, 1, 2)", output);
    }

    /**
     * Tests when there are no inserts
     */
    @Test
    public void testDumpNoInserts()
    {
        TestableRandom.setNextInts(2, 2, 2);
        SkipList<String, Point> s = new SkipList<String, Point>();
        s.dump();
        String output = systemOut().getHistory();
        assertFuzzyEquals("SkipList dump: \n"
                + "Node has depth 1, Value (null)\n"
                + "SkipList size is: 0", output);
    }

    /**
     * Test when there is one insert for dump
     */
    @Test
    public void testDumpWith1Insert()
    {
        TestableRandom.setNextInts(3, 3, 3);
        Point re = new Point("a", 1, 2);
        KVPair<String, Point> p = new KVPair<String, Point>(re.getName(), re);
        SkipList<String, Point> s = new SkipList<String, Point>();
        SkipList<String, Point> s1 = new SkipList<String, Point>();
        s.insert(p);
        s1.controlledInsert(p, 1);
        s1.dump();
        String output = systemOut().getHistory();
        assertFuzzyEquals("SkipList dump: \n"
                + "Node has depth 1, Value (null)\n"
                + "Node has depth 1, Value (a, 1, 2)\n"
                + "SkipList size is: 1", output);
    }

    /**
     * Tests when there are two inserts for dump
     */
    @Test
    public void testDumpWith2Inserts()
    {
        TestableRandom.setNextInts(2, 2, 2);
        Point re = new Point("a", 1, 2);
        KVPair<String, Point> p = new KVPair<String, Point>(re.getName(), re);
        SkipList<String, Point> s = new SkipList<String, Point>();
        s.controlledInsert(p, 2);
        Point re1 = new Point("hey", 1, 2);
        KVPair<String, Point> p1 = new KVPair<String, Point>(re1.getName(), re1);
        s.insert(p1);
        s.dump();
        String output = systemOut().getHistory();
        assertFuzzyEquals("SkipList dump: \n"
                + "Node has depth 2, Value (null)\n"
                + "Node has depth 2, Value (a, 1, 2)\n"
                + "Node has depth 2, Value (hey, 1, 2)\n"
                + "SkipList size is: 2", output);
    }    

    /**
     * Tests the controlled insert in SkipList
     */
    @Test
    public void testInsertBool() {
        Point re = new Point("a", 1, 2);
        KVPair<String, Point> p = new KVPair<String, Point>(re.getName(), re);
        SkipList<String, Point> s = new SkipList<String, Point>();
        assertTrue(s.controlledInsert(p, 2));
        assertEquals(null, s.head.element());
    }

    /**
     * Tests when the controlled insert is not null
     */
    @Test
    public void testInsertBoolMore()
    {
        Point re = new Point("a", 1, 2);
        KVPair<String, Point> p = new KVPair<String, Point>(re.getName(), re);
        SkipList<String, Point> s = new SkipList<String, Point>();
        s.controlledInsert(p, 2);

        Point uh = new Point("b", 1, 2);
        KVPair<String, Point> k = new KVPair<String, Point>(uh.getName(), uh);
        s.controlledInsert(k, 2);
        assertEquals(null, s.head.element());
    }

//    /**
//     * Tests all region search possibilites
//     */
//    @Test
//    public void testRegionSearch()
//    {
//        SkipList<String, Point> skip = new SkipList<String, Point>();
//        Point r1 = new Point("a", 1, 2);
//        KVPair<String, Point> p1 = new KVPair<String, Point>(r1.getName(), r1);
//        Point r2 = new Point("b", 1, 5);
//        KVPair<String, Point> p2 = new KVPair<String, Point>(r2.getName(), r2);
//        Point r3 = new Point("c", 4, 4);
//        KVPair<String, Point> p3 = new KVPair<String, Point>(r3.getName(), r3);
//        Point r4 = new Point("d", 6, 6);
//        KVPair<String, Point> p4 = new KVPair<String, Point>(r4.getName(), r4);
//        Point r5 = new Point("a", 11, 5);
//        KVPair<String, Point> p5 = new KVPair<String, Point>(r5.getName(), r5);
//        skip.insert(p1);
//        skip.insert(p5);
//        skip.insert(p3);
//        skip.insert(p4);
//        skip.insert(p2);
//        skip.regionsearch(1, 2, 3, 4);
//        String output = systemOut().getHistory();
//        assertFuzzyEquals("Point intersecting region (1, 2):\n"
//                + "(a, 1, 2)\n" + "(b, 1, 5)\n", output);
//        skip.regionsearch(6, 6, 2, 2);
//    }
//
//    /**
//     * Tests intersections
//     */
//    @Test
//    public void testIntersections()
//    {
//        SkipList<String, Point> skip = new SkipList<String, Point>();
//        Point r1 = new Point("a", 1, 2);
//        KVPair<String, Point> p1 = new KVPair<String, Point>(r1.getName(), r1);
//        Point r2 = new Point("b", 1, 5);
//        KVPair<String, Point> p2 = new KVPair<String, Point>(r2.getName(), r2);
//        Point r3 = new Point("c", 4, 4);
//        KVPair<String, Point> p3 = new KVPair<String, Point>(r3.getName(), r3);
//        Point r4 = new Point("d", 6, 6);
//        KVPair<String, Point> p4 = new KVPair<String, Point>(r4.getName(), r4);
//        Point r5 = new Point("a", 11, 5);
//        KVPair<String, Point> p5 = new KVPair<String, Point>(r5.getName(), r5);
//        skip.insert(p1);
//        skip.insert(p5);
//        skip.insert(p3);
//        skip.insert(p4);
//        skip.insert(p2);
//        skip.duplicates();
//        String output = systemOut().getHistory();
//        assertFuzzyEquals("(a, 1, 2 | b, 1, 5)\n"
//                + "(b, 1, 5 | a, 1, 2)\n", output);
//    }
    
    /**
     * Tests the controlled insert method
     */
    public void testControlledInsert() {
        Point re = new Point("b", 1, 2);
        KVPair<String, Point> p = new KVPair<String, Point>(re.getName(), re);
        Point re1 = new Point("c", 2, 2);
        KVPair<String, Point> p1 = new KVPair<String, Point>(re1.getName(), re1);
        Point re2 = new Point("a", 2, 7);
        KVPair<String, Point> p2 = new KVPair<String, Point>(re2.getName(), re2);
        SkipList<String, Point> s = new SkipList<String, Point>();
        s.controlledInsert(p, 4);
        s.controlledInsert(p1, 12);
        assertTrue(s.controlledInsert(p2, 6));
    }
}
