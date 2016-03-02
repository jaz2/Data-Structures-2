
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

     /**
      * The PRQuadtree instance
      */
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
      * @return
      */
     public void insert(String id, int x, int y)
     {
          Point p = new Point(id, x, y);
          KVPair<String, Point> k = new KVPair<String, Point>(id, p);
          skip.insert(k); 
          pr.insert(p);
     }

     /**
      * Dumps using the skip list 
      * and quad tree
      */
     public void dump()
     {
          skip.dump();
          pr.dump();
     }

     /**
      * Call the pr quad tree region search
      * @param xc the xcoord
      * @param yc the ycoord
      * @param w the width
      * @param l the lenfth
      */
     public void regionSearch(int xc, int yc, int w, int l)
     {
          pr.regionSearch(xc, yc, w, l);
     }

     /**
      * Calls the pr quad trees duplicates
      */
     public void duplicates()
     {
          pr.duplicates();
     }

     /**
      * Searches for the key
      * @param k the key
      */
     public void search(String k)
     {
          skip.search(k);
     }

     /**
      * Searches through the SkipList first 
      * and then retrieves the point to find 
      * the coordinates
      * @param name
      */
     public void removeN(String name)
     { //use this to get the point and remove it in quadtree
          skip.removeByName(name);
          if (skip.found == true)
          {
        	  pr.remove(skip.val.x, skip.val.y);
          }          
     }

     /**
      * Removes in the quad tree returns 
      * node to get name to remove 
      * by name in skip
      * @param x
      * @param y
      */
     public void removeC(int x, int y)
     {
          pr.remove(x, y);
          //skip.removeByName(string);
     }
}
