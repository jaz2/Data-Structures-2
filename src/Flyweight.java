/**
 * 
 */

/**
 * @author Jazmine Zurita and Jessica McCready
 * @version Feb 20 2016
 *
 */
public class Flyweight implements PRQuadNode{

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
     * When the node is empty, convert to a leaf
     * @return lef
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

}
