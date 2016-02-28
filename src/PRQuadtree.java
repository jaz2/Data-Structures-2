

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
     * @param xcoord the xcoord
     * @param ycoord the ycoord
     * @param len the length
     * @return the root
     */
    public PRQuadNode insert(Point p)
    {
        root = root.insert(p, 0, 0, 1024);
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
    
    public void regionSearch(int xc, int yc, int w, int l)
    {
    	System.out.println("Points intersecting region (" + xc + ", " 
                + yc + ", " + w + ", " + l + "):");
    	int r = regionSearch(root, xc, yc, w, l, 0, 0, 1024);
    	System.out.println(r + " quadtree nodes visited");
    }

    /**
     * Searches within the region
     * @param node the node in the tree
     * @param x the x coord
     * @param y the y coord
     * @param w the width
     * @param l the length
     * @return number of nodes visited
     */
    private int regionSearch(PRQuadNode node, int x, int y, int w, int l, int nx, int ny, int nl)
    {
        if (nx <= x && ny <= y && nl <= l)
        {
        	if (node.getClass().equals(Flyweight.class))
        	{
        		return 1;
        	}
        	if (node.isLeaf())
        	{
        		((PRQuadLeaf)node).printVisited();
        		return 1;
        	}
        	else //is internal
        	{
        		return 1 + regionSearch(((PRQuadInternal) node).nw(), 
                        x, y, l /2, l / 2, nx, ny, nl / 2)
        	            + regionSearch(((PRQuadInternal) node).ne(), 
        	                    x + (l / 2), y, l / 2, l / 2, 
        	                    nx + (1 / 2), ny, nl / 2)
        	            + regionSearch(((PRQuadInternal) node).sw(), 
        	                    x, y + (l / 2), l / 2, l / 2, nx, 
        	                    ny + (1 / 2), nl / 2)
        	            + regionSearch(((PRQuadInternal) node).se(), 
        	                    x + (l / 2), y + (l / 2), l / 2, l / 2, 
        	                    nx + (l / 2), ny + (1 / 2), nl / 2);
        	}
        }
        else 
        {
        	
        	if (node.getClass().equals(Flyweight.class))
        	{
        		return 0;
        	}
        	if (node.isLeaf())
        	{
        		return 0;
        	}
        	else //is internal
        	{
        		return 0 + regionSearch(((PRQuadInternal) node).nw(), 
                        x, y, l /2, l / 2, nx, ny, nl / 2)
        	            + regionSearch(((PRQuadInternal) node).ne(), 
        	                    x + (l / 2), y, l / 2, l / 2, 
        	                    nx + (1 / 2), ny, nl / 2)
        	            + regionSearch(((PRQuadInternal) node).sw(), 
        	                    x, y + (l / 2), l / 2, l / 2, nx, 
        	                    ny + (1 / 2), nl / 2)
        	            + regionSearch(((PRQuadInternal) node).se(), 
        	                    x + (l / 2), y + (l / 2), l / 2, l / 2, 
        	                    nx + (l / 2), ny + (1 / 2), nl / 2);
        	}        }
    }

    /**
     * Searches for duplicates 
     */
    public void duplicates()
    {}
}
