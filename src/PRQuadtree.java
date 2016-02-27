

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
     * @param x the xcoord
     * @param y the ycoord
     * @param length the length
     * @return the root
     */
    public PRQuadNode insert(Point p, int x, int y, int length)
    { //try and make it node-centric (within the node class to avoid copying it over)
        root = root.insert(p, x, y, length);
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
    public int dump(PRQuadNode node, int s, int xcoord, int ycoord, int len)
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
            return 1 + dump(((PRQuadInternal) node).NW(), s + 1, xcoord, ycoord, len / 2)
            + dump(( (PRQuadInternal) node).NE(), s + 1, xcoord + (len / 2), ycoord, len / 2)
            + dump(((PRQuadInternal) node).SW(), s + 1, xcoord, ycoord + (len / 2), len / 2)
            + dump(((PRQuadInternal) node).SE(), s + 1, xcoord + (len / 2), ycoord + (len / 2), len / 2);
        }
        else //node leaf
        {
            System.out.println("Node at " + xcoord + ", " + ycoord + ", " 
                    + len + ": ");
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
}
