/**
 * 
 */

/**
 * @author Jazmine Zurita and Jessica McCready
 * @version March 2 2016
 *
 */
public interface PRQuadNode {

    /**
     * checks if the node is a leaf
     * @return true or false
     */
    public boolean isLeaf();

    /**
     * Checks if the node is empty
     * @return true or false
     */
    public boolean isEmpty();

    /**
     * Searches within a region for points
     * @param x the x coord of region
     * @param y the y coord of region
     * @param w the width of region
     * @param l the length of region
     * @param nx the tree x
     * @param ny the tree y
     * @param nl the tree length
     * @return the number of things in region
     */
    public int regionSearch(int x, int y, int w, int l, int nx, int ny, int nl);

    /**
     * Returns instances of duplicate points
     */
    public void duplicates();

    /**
     * Inserts a point
     * @param p the point
     * @param x the tree x
     * @param y the tree y
     * @param length the tree length
     * @return the node
     */
    public PRQuadNode insert(Point p, int x, int y, int length);

    /**
     * Removes a point
     * @param n name of node
     * @param x x coord of node
     * @param y y coord of node
     * @param tx the trees x
     * @param ty the trees y
     * @param len the length of tree
     * @return the node removed
     */
    public PRQuadNode remove(String n, int x, int y, int tx, int ty, int len);

    /**
     * The merge method for internal
     * @return the new node 
     */
    public PRQuadNode merge();
}
