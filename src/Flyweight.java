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
	
	@Override
	public boolean isLeaf() {
		if (this.getClass().equals(PRQuadLeaf.class))
			return true;
		return false;
	}

	@Override
	public PRQuadNode insert(Point p, int x, int y, int length)
	{
		PRQuadNode node = this;
		PRQuadLeaf lef = new PRQuadLeaf(p);
		return lef;
	}

}
