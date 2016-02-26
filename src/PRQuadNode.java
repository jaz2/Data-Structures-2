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
	
	public PRQuadNode insert(Point p, int x, int y, int length);

}
