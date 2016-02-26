
// -------------------------------------------------------------------------
/**
 *  This class contains the SkipList and works with the CommandProcessor.
 *
 *  @author Jazmine Zurita and Jessica McCready
 *  @version Jan 24, 2016
 */

public class Database
{
    /**
     * The SkipList
     */
    public SkipList<String, Point> skip; 
    
    public PRQuadtree pr;

    /**
     * The Database constructor which creates a SkipList
     */
    public Database()
    {
        skip = new SkipList<String, Point>();
        pr = new PRQuadtree(0, 0, 1024);
    }

    /**
     * Inserts using the SkipList
     * 
     * @param id the key
     * @param x the x coord
     * @param y the y coord
     * @param w the width
     * @param h the height
     * @return
     */
    public void skipInsert(String id, int x, int y)
    {
        Point p = new Point(id, x, y);
        KVPair<String, Point> k = new KVPair<String, Point>(id, p);
        skip.insert(k); 
        pr.insert(p, 0, 0, 1024);
    }

//    /**
//     * Calls the skiplist remove by coord
//     * @param x the x coord
//     * @param y the y coord
//     * @param w the width
//     * @param h the height
//     */
//    public void skipRemoveCoord(int x, int y)
//    {
//        Rect r = new Rect(null, x, y, w, h);
//        KVPair<String, Rect> p = new KVPair<String, Rect>(null, r);
//        skip.removeByCoord(r);
//    }
    
    //    /**
    //     * Searches for the rectangle through name
    //     * 
    //     * @param id
    //     */
    //    public void skipSearch(String id)
    //    {
    //        KVPair p = new KVPair()
    //        skip.search(id);
    //    }
}
