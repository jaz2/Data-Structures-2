

public class PRQuadInternal implements PRQuadNode {
	
	/**
	 * For testing purposes
	 */
	PRQuadNode u;
	
	/**
	 * The NW quadrant
	 */
	PRQuadNode NW;

	/**
	 * The NE quadrant
	 */
	PRQuadNode NE;

	/**
	 * The SW quadrant
	 */
	PRQuadNode SW;

	/**
	 * The SE quadrant
	 */
	PRQuadNode SE;	
	
	/**
	 * Creates an internal node
	 */
	public PRQuadInternal()
	{ 
		NW = Flyweight.fly;
		NE = Flyweight.fly;
		SW = Flyweight.fly;
		SE = Flyweight.fly;
	}

	@Override
	public boolean isLeaf() {
		return false;
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * For testing purposes
	 * @return the instance of the node
	 */
	public PRQuadNode getInstance()
	{
		return u;
	}
	
	/**
	 * Inserts in the regions based on where it is
	 */
	@Override
	public PRQuadNode insert(Point p, int x, int y, int length) {
		int nuLen = length/2;
		if (p.getX() <= x + nuLen && p.getY() <= y + nuLen) //NW
		{
			NW = NW.insert(p, nuLen + x, y, nuLen);
			u = NW;
		}
		if (p.getX() > x + nuLen && p.getY() <= y + nuLen) //NE
		{ 
			NE = NE.insert(p, nuLen + x, y, nuLen);
			u = NE;
		}
		if (p.getX() <= x + nuLen && p.getY() > y + nuLen) //SW
		{ 
			SW = SW.insert(p, nuLen + x, y, nuLen);
			u = SW;
		}
		if (p.getX() > x + nuLen && p.getY() > y + nuLen) //SE
		{ 
			SE = SE.insert(p, nuLen + x, y, nuLen);
			u = SE;
		}
		return this;
	}
}
