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
	
	/**
	 * Checks if it is a leaf of not
	 */
	@Override
	public boolean isLeaf() {
		if (this.getClass().equals(PRQuadLeaf.class))
			return true;
		return false;
	}

	/**
	 * When the node is empty, convert to a leaf
	 */
	@Override
	public PRQuadNode insert(Point p, int x, int y, int length)
	{
		PRQuadNode node = this;
		PRQuadLeaf lef = new PRQuadLeaf(p);
		return lef;
	}

	@Override
	public boolean isEmpty() 
	{
		return true;
	}

}
