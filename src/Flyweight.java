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
    public PRQuadNode u;

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
    {
        //do nothing
    }

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
        u = lef;
        return lef;
    }

    /**
     * Tries to remove an empty node
     * @param n the string name of point
     * @param x the point x coord 
     * @param y the point y coord
     * @param tx the trees x
     * @param ty the trees y
     * @param len the trees length
     * @return node to be removed
     */
    @Override
    public PRQuadNode remove(String n, int x, int y, int tx, int ty, int len)
    {
        u = this;
        return this;
    }

    /**
     * For testing purposes
     * @return the l 
     */
    public PRQuadNode getInstance()
    {
        return u;
    }

    /**
     * For the internal
     * @return the merged fly
     */
    public PRQuadNode merge()
    {
        return this;
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
     * Returns node count for 
     * tree's regionSearch method
     * @param x the x coord
     * @param y the y coord
     * @param w the width
     * @param l the length
     * @param nx nodes x
     * @param ny the nodes y
     * @param nl the nodes length
     * @return 1
     */
    @Override
    public int regionSearch(int x, int y, int w, int l, int nx, int ny, int nl) 
    {
        return 1;
    }
}
