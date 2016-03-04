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
	
	public void duplicates();
	
	public PRQuadNode insert(Point p, int x, int y, int length);
	
	public PRQuadNode remove(String n, int x, int y, int tx, int ty, int len);
	
	public PRQuadNode merge();
}
