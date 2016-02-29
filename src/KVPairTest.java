//import static org.junit.Assert.*;
import student.TestCase;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Jazmine Zurita and Jessica McCready    
 * @version Feb 3 2016
 *
 */
public class KVPairTest extends TestCase {

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * Tests the KVPair
     */
    @Test
    public void testKV() {
        Point p = new Point("a", 1, 2);
        KVPair<String, Point> k = new KVPair<String, Point>("a", p);

        assertEquals("a", k.key());
        assertEquals(p, k.value());
        assertEquals("(a, 1, 2)", p.toString());
        assertEquals("a, (a, 1, 2))", k.toString());
    }


    /**
     * Tests when two pairs are the same
     */
    @Test
    public void testCompareToPairs()
    {
        Point rec = new Point("a", 1, 2);
        KVPair<String, Point> p = new KVPair<String, Point>(rec.getName(), rec);

        Point other = new Point("a", 1, 2);
        KVPair<String, Point> b = new KVPair<
                String, Point>(other.getName(), other);

        assertEquals(0, p.compareTo(b));
    }

    /**
     * Tests when two pairs are not the same
     */
    @Test
    public void testCompareToNotPairs()
    {
        Point rec = new Point("a", 1, 2);
        KVPair<String, Point> p = new KVPair<String, Point>(rec.getName(), rec);

        Point nu = new Point("k", 1, 3);
        KVPair<String, Point> n = new KVPair<String, Point>(nu.getName(), rec);

        assertEquals(-10, p.compareTo(n));
    }


    /**
     * Tests when two names match
     */
    @Test
    public void testCompareToName()
    {
        Point rec = new Point("a", 1, 2);
        KVPair<String, Point> p = new KVPair<String, Point>(rec.getName(), rec);

        Point idk = new Point("a", 1, 1);

        assertEquals(0, p.compareTo(idk.getName()));
    }

    /**
     * Tests when two names do not match
     */
    @Test
    public void testCompareToNoName()
    {
        Point rec = new Point("a", 1, 2);
        KVPair<String, Point> p = new KVPair<String, Point>(rec.getName(), rec);

        Point no = new Point("b", 1, 2);

        assertEquals(-1, p.compareTo(no.getName()));
    }
}
