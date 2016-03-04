

/**
 * Stores the points into leaves
 * @author Jazmine Zurita and Jessica McCready
 * @version Feb 21 2016
 *
 */
public class PRQuadtree {

    /**
     * The root 
     */
    public PRQuadNode root;


    /**
     * The x coord
     */
    int x;

    /**
     * The y coord
     */
    int y;

    /**
     * The length
     */
    int length;

    //    /**
    //     * The name of the point for remove
    //     */
    //    static String name = null;

    /**
     * The PRQuadtree constructor
     * 
     * @param xcoord the x coord
     * @param ycoord the y coord
     * @param len the height/weight
     */
    public PRQuadtree(int xcoord, int ycoord, int len)
    {
        root = Flyweight.fly; 
        x = xcoord;
        y = ycoord;
        length = len;
    }

    /**
     * The insert method
     * @param p the point to be inserted
     * @return the root
     */
    public PRQuadNode insert(Point p)
    {
        root = root.insert(p, 0, 0, 1024);
        return root;
    }

    /**
     * Removes the point
     * @param n name of point
     * @param px the points x
     * @param py the points y
     * @return the node containing point
     */
    public PRQuadNode remove(String n, int x, int y)
    {
        root = root.remove(n, x, y, 0, 0, 1024);
        return root;
    }

    /**
     * the dump method
     * print size
     * If can't keep tree size variable, then
     * maybe have dump return int and 
     * keep track of size in there
     */
    public void dump()
    {
        System.out.println("QuadTree dump:");
        int d = dump(root, 0, 0, 0, 1024);
        System.out.println(d + " quadtree nodes printed");
    }

    /**
     * When this is called it dumps the quad nodes
     * @param node the node 
     * @param s the space
     * @param xcoord the x coord
     * @param ycoord the y coord
     * @param len the length
     * @return the number
     */
    private int dump(PRQuadNode node, int s, int xcoord, int ycoord, int len)
    {    
        printSpaces(s);
        if (node.getClass().equals(Flyweight.class)) //empty
        {    
            System.out.println("Node at " + xcoord + ", " + ycoord + ", " 
                    + len + ": Empty");
            return 1;
        }
        if (node.getClass().equals(PRQuadInternal.class))
        {
            System.out.println("Node at " + xcoord + ", " + ycoord + ", " 
                    + len + ": Internal");
            return 1 + dump(((PRQuadInternal) node).nw(), 
                    s + 1, xcoord, ycoord, len / 2)
                    + dump(( (PRQuadInternal) node).ne(), s + 1, 
                        xcoord + (len / 2), ycoord, len / 2)
                    + dump(((PRQuadInternal) node).sw(), s + 1, 
                        xcoord, ycoord + (len / 2), len / 2)
                    + dump(((PRQuadInternal) node).se(), s + 1, 
                        xcoord + (len / 2), ycoord + (len / 2), len / 2);
        }
        else //node leaf
        {
            System.out.println("Node at " + xcoord + ", " + ycoord + ", " 
                    + len + ":");
            ((PRQuadLeaf) node).printPoints(s);
            return 1;
        }

    }

    /**
     * Helper for dump
     * Determines the amount of spaces needed
     * @param n the spaces needed
     */
    public void printSpaces(int n)
    {
        //print n*2 spaces
        for (int i = 0; i < n; i++)
        {
            System.out.print("  ");
        }
    }

    /**
     * The trees implementation of regionSearch
     * @param rx the Rectangle x coord
     * @param ry the Rectangle y coord
     * @param rw the Rectangle width
     * @param rh the Rectangle height
     */
    public void regionSearch(int rx, int ry, int rw, int rh)
    {
        System.out.println("Points intersecting region" + " (" + rx + ", " + ry
                + ", " + rw    + ", " + rh + "):");
        int r = root.regionSearch(rx, ry, rw, rh, 0, 0, 1024);
        //    int r = regionSearch(root, rx, ry, rw, rh, 0, 0, 1024);
        System.out.println(r + " quadtree nodes visited");
    }

    /**
     * The duplicates method
     * Finds any points that are
     * the same
     */
    public void duplicates()
    {
        System.out.println("Duplicate points:");
        root.duplicates();
    }
}
