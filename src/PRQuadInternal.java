

public class PRQuadInternal implements PRQuadNode {
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
	{ //TODO ask about flyweight
	}

	@Override
	public boolean isLeaf() {
		if (this.getClass().equals(PRQuadLeaf.class))
			return true;
		return false;
	}

	@Override
	public PRQuadNode insert(Point p, int x, int y, int length) {
		int nuLen = length/2;
		if (p.getX() <= x + nuLen && p.getY() <= y + nuLen) //NW
		{
			NW = NW.insert(p, nuLen + x, y, nuLen);
		}
		if (p.getX() > x + nuLen && p.getY() <= y + nuLen) //NE
		{ 
			NE = NE.insert(p, nuLen + x, y, nuLen);
		}
		if (p.getX() <= x + nuLen && p.getY() > y + nuLen) //SW
		{ 
			SW = SW.insert(p, nuLen + x, y, nuLen);
		}
		if (p.getX() > x + nuLen && p.getY() > y + nuLen) //SE
		{ 
			SE = SE.insert(p, nuLen + x, y, nuLen);
		}
		return this;
	}

}
