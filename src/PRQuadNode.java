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
	
	public void duplicates();
	
	public PRQuadNode insert(Point p, int x, int y, int length);

}
