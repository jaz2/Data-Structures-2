/**
 * 
 */

/**
 * @author Jazz
 *
 */
public class Flyweight implements PRQuadNode{

	//global static rep of itself to return that
	public static Flyweight fly = new Flyweight();
	public PRQuadLeaf l;
	
	/**
	 * Checks if it is a leaf of not
	 */
	@Override
	public boolean isLeaf() {
		return false;
	}

	/**
	 * When the node is empty, convert to a leaf
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
	 * @return
	 */
	public PRQuadNode getInstance()
	{
		return l;
	}

	/**
	 * Checks if node is empty
	 */
	@Override
	public boolean isEmpty() 
	{
		return true;
	}

}
