/**
 * 
 */

/**
 * @author Jazmine Zurita and Jessica McCready
 * @version Feb 20 2016
 *
 */
public class Flyweight implements PRQuadNode {

    /**
     * Global static rep of itself
     */
    public static Flyweight fly = new Flyweight();
    
    /**
     * for testing purposes
     */
    public PRQuadNode l;

    /**
     * Checks if it is a leaf of not
     * @return false
     */
    @Override
    public boolean isLeaf() {
        return false;
    }
    
    /**
     * Does nothing in this class
     */
    public void duplicates()
    {}

    /**
     * When the node is empty, convert to a leaf
     * @param p the point 
     * @param x the x coord
     * @param y the y coord
     * @param length the length
     * @return leaf
     */
    @Override
    public PRQuadNode insert(Point p, int x, int y, int length)
    {
        PRQuadLeaf lef = new PRQuadLeaf(p);
        l = lef;
        return lef;
    }

    /**
     * For testing purposes
     * @return the l 
     */
    public PRQuadNode getInstance()
    {
        return l;
    }

    /**
     * Returns if empty or no
     * @return empty
     */
    @Override
    public boolean isEmpty() 
    {
        return true;
    }

    /**
     * To help with the tree's regionSearch
     */
	@Override
	public int regionSearch() 
	{
		return 1;
	}

}
