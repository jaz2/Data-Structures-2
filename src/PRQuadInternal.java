

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
		if (p.getX() >= x + nuLen && p.getY() <= y + nuLen /*in.NE*/) //TODO!!!!!
		{ 
			NE = NE.insert(p, nuLen + x, y, nuLen);
		}
		if (p.getX() >= x + nuLen && p.getY() <= y + nuLen /*in.NE*/)//CHANGE
		{
			NW = NW.insert(p, x, y, length);
		}
		if (in SE)
		{
			SE = SE.insert();
		}
		if (in SW)
		{
			SW = SW.insert();
		}
		return in;
	}

}
