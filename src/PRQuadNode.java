/**
 * 
 */

/**
 * @author Jazz
 *
 */
public interface PRQuadNode {
	
	public boolean isLeaf();
	
	public boolean isEmpty();
	
	public int regionSearch(int x, int y, int w, int l, int nx, int ny, int nl);
	
	public void duplicates();
	
	public PRQuadNode insert(Point p, int x, int y, int length);
	
	public PRQuadNode remove(int x, int y);
}
