
/**
 * The Internal node class
 * @author Jazmine Zurita and Jessica McCready
 * @version Feb 22 2016
 */
public class PRQuadInternal implements PRQuadNode { 

	/**
	 * For testing purposes
	 */
	PRQuadNode u;

	/**
	 * The nw quadrant
	 */
	PRQuadNode nw;

	/**
	 * The ne quadrant
	 */
	PRQuadNode ne;

	/**
	 * The sw quadrant
	 */
	PRQuadNode sw;

	/**
	 * The se quadrant
	 */
	PRQuadNode se;    

	/**
	 * Creates an internal node
	 */
	public PRQuadInternal()
	{ 
		nw = Flyweight.fly;
		ne = Flyweight.fly;
		sw = Flyweight.fly;
		se = Flyweight.fly;
	}

	/**
	 * Returns the sw 
	 * @return sw
	 */
	public PRQuadNode sw()
	{
		return sw;
	}

	/**
	 * Returns the se
	 * @return se
	 */
	public PRQuadNode se()
	{
		return se;
	}

	/**
	 * Returns the nw
	 * @return nw
	 */
	public PRQuadNode nw()
	{
		return nw;
	}

	/**
	 * Returns the ne
	 * @return ne
	 */
	public PRQuadNode ne()
	{
		return ne;
	}

	/**
	 * Returns if it is a leaf or no
	 * @return false
	 */
	@Override
	public boolean isLeaf() {
		return false;
	}

	/**
	 * Return if it is empty
	 * @return false
	 */
	@Override
	public boolean isEmpty() {
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
	 * Checks duplicates in internal
	 */
	@Override
	public void duplicates()
	{
		nw.duplicates();
		ne.duplicates();
		se.duplicates();
		sw.duplicates();        
	}

	/**
	 * QuadInternal implementation
	 * of quadtree
	 * 
	 * @param rx the x coord
	 * @param ry the y coord
	 * @param rw the width
	 * @param rh the length
	 * @param nx nodes x
	 * @param ny the nodes y
	 * @param nl the nodes length
	 * @return c for the count
	 */
	@Override
	public int regionSearch( int rx, int ry, int rw, 
			int rh, int nx, int ny, int nl) 
	{
		int mid = nl / 2;
		int c = 1;

		if (mid >= rx && mid + ny >= ry) //NW
		{
			c = c + nw.regionSearch(rx, ry, rw, rh, nx, ny, mid);
		}
		if (mid + nx <= rx + rw && mid >= ry)  //NE
		{
			c = c + ne.regionSearch(rx, ry, rw, rh, nx + mid, ny, mid);
		}
		if (mid + nx >= rx && mid + ny <= ry + rh)  //SW
		{
			c = c + sw.regionSearch(rx, ry, rw, rh, nx, ny + mid, mid);
		}
		if (mid + nx <= rx + rw && mid + ny <= ry + rh)  //SE
		{
			c = c + se.regionSearch(rx, ry, rw, rh, nx + mid, ny + mid, mid);
		}
		return c;
	}

	/**
	 * Inserts in the regions based on where it is
	 * @param p the point 
	 * @param x the xcoord
	 * @param y the ycoord
	 * @param length the length
	 * @return this 
	 */
	@Override
	public PRQuadNode insert(Point p, int x, int y, int length) {
		int nuLen = length / 2;
		if (p.getX() <= x + nuLen && p.getY() <= y + nuLen) //nw
		{
			nw = nw.insert(p, x, y, nuLen);
		}
		else if (p.getX() > x + nuLen && p.getY() <= y + nuLen) //ne
		{ 
			ne = ne.insert(p, x + nuLen, y, nuLen);
		}
		else if (p.getX() <= x + nuLen) //&& p.getY() > y + nuLen) //sw
		{ 
			if (p.getY() > y + nuLen)
				sw = sw.insert(p, x, y + nuLen, nuLen);
		}
		else
			//if (p.getX() > x + nuLen && p.getY() > y + nuLen) //se
		{ 
			se = se.insert(p, x + nuLen, y + nuLen, nuLen);
		}
		u = this;
		return this;
	}

	/**
	 * 
	 */
	public PRQuadNode remove(int px, int py, int tx, int ty, int len)
	{
		int nuLen = len / 2;
		if (px <= tx + nuLen) //&& py <= ty + nuLen) //nw
		{
			if (py <= ty + nuLen) //nw 
			{
				nw = nw.remove(px, py, tx, ty, nuLen);
			}
			else //sw = py < ty + nuLen
			{
				sw = sw.remove(px, py, tx, ty + nuLen, nuLen);
			}
		}
		else 
		{
			if (py <= ty + nuLen) //ne
			{
				ne = ne.remove(px, py, tx + nuLen, ty, nuLen);
			}
			else //if (p.getX() > x + nuLen && p.getY() > y + nuLen) //se
			{
				se = se.remove(px, py, tx + nuLen, ty + nuLen, nuLen);
			}
		}
		u = this;
		return this;
	}
}
