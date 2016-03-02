

/**
 * 
 */

/**
 * @author Jazmine Zurita and Jessica McCready
 * @version Feb 22 2016
 *
 */
public class PRQuadLeaf implements PRQuadNode {

	/**
	 * the linked list
	 */
	List l;

	/**
	 * For testing purposes
	 */
	PRQuadNode u;

	/**
	 * For the db to use
	 * on remove
	 */
	String nam;

	/**
	 * Handles the points
	 * @param p the point we're adding 
	 * 
	 */
	public PRQuadLeaf(Point p)
	{
		l = new List(); 
		l.insert(p);
	}

	/**
	 * is empty method
	 * @return false
	 */
	@Override
	public boolean isEmpty() {
		return false;
	}

	/**
	 * Checks if it is a leaf
	 * @return true
	 */
	@Override
	public boolean isLeaf() {
		return true;
	}

	/**
	 * For testing purposes
	 * @return the node
	 */
	public PRQuadNode getInstance()
	{
		return u;
	}

	//    /**
	//     * To print points in regionsearch
	//     */
	//    public void printVisited()
	//    {
	//        for (int i = 0; i <= l.length() - 1; i++)
	//        {
	//            System.out.print("Point found: ");
	//            System.out.println(l.moveToPos(i).toString());
	//        }
	//    }

	/**
	 * Prints out
	 * @param s the spaces
	 */
	public void printPoints(int s)
	{
		for (int i = 0; i <= l.length() - 1; i++)
		{
			printSpaces(s);
			System.out.println(l.moveToPos(i).toString());
		}
	}

	/**
	 * Prints spaces
	 * @param n the number of spaces
	 */
	public void printSpaces(int n)
	{
		//print n*2 spaces
		for (int i = 0; i < n; i++)
		{
			System.out.print("  ");
		}
	}

	/**
	 * regionSearch for the quad leaf
	 * @param rx the x coord
	 * @param ry the y coord
	 * @param rw the width
	 * @param rh the length
	 * @param nx nodes x
	 * @param ny the nodes y
	 * @param nl the nodes length
	 * @return 1 when found 
	 */
	@Override
	public int regionSearch(int rx, int ry, int rw, 
			int rh, int nx, int ny, int nl)
	{
		for (int i = 0; i <= l.length() - 1; i++)
		{
			Point p = (Point) l.moveToPos(i);
			if ((rx <= p.getX()) && (p.getX() <= rw + rx) 
					&& (ry <= p.getY()) && (p.getY() <= rh + ry))
			{
				System.out.print("Point found: ");
				System.out.println(l.moveToPos(i).toString());
			}
		}    
		return 1;
	}

	/**
	 * Checks duplicate points in the leaf nodes
	 */
	@Override
	public void duplicates()
	{
		//leaf then look at points and see if duplicates
		//(if size >3 dont have to check, if size <=3 then check)
		if (l.length() > 3) //all dups
		{
			System.out.println("(" + ((Point)l.moveToPos(0)).getX()
					+ ", " + ((Point)l.moveToPos(0)).getY() + ")");
		}
		else if (l.length() == 3)
		{
			if (l.moveToPos(0).equals(l.moveToPos(1)))
			{
				System.out.println("(" + ((Point)l.moveToPos(0)).getX() 
						+ ", " + ((Point)l.moveToPos(0)).getY() + ")");
			}
			else if (l.moveToPos(1).equals(l.moveToPos(2)))
			{
				System.out.println("(" + ((Point)l.moveToPos(1)).getX() 
						+ ", " + ((Point)l.moveToPos(1)).getY() + ")");
			}
			else if (l.moveToPos(0).equals(l.moveToPos(2)))
			{
				System.out.println("(" + ((Point)l.moveToPos(0)).getX() 
						+ ", " + ((Point)l.moveToPos(0)).getY() + ")");
			}

		}
		else if (l.length() == 2)
		{
			if (l.moveToPos(0).equals(l.moveToPos(1)))
			{
				System.out.println("(" + ((Point)l.moveToPos(0)).getX() 
						+ ", " + ((Point)l.moveToPos(0)).getY() + ")");
			}
		}
		//else length is 1 so no duplicates
	}

	/**
	 * Inserts into a leaf and splits based on number of points
	 * @param p the point
	 * @param xco the x
	 * @param yco the y
	 * @param length the length
	 * @return the nodes
	 */
	@Override
	public PRQuadNode insert(Point p, int xco, int yco, int length) {
		{
			if (l.length() <= 2)
			{
				l.insert(p);
				u = this;
				return this;
			}
			//if my size is already > 3 they must all be duplicates 
			//so only check the first element
			if (l.length() > 3)
			{
				if (p.equals(l.moveToPos(0))) //p same so add
				{
					l.insert(p);
					u = this;
					return this;
				}
				else  //p diff so split
				{
					PRQuadInternal in = new PRQuadInternal();
					in.insert(p, xco, yco, length);
					for (int i = 0; i < l.length(); i++)
					{
						Point p1 = (Point) l.moveToPos(i);
						in.insert(p1, xco, yco, length);
					}
					u = in;
					return in;
				}
			}            
			else // we are 3
			{
				// check every elem with this one if different split
				for (int i = 0; i < l.length(); i++)
				{
					if (!p.equals(l.moveToPos(i))) //p diff 
					{
						//split
						PRQuadInternal in = new PRQuadInternal();
						in.insert(p, xco, yco, length);
						for (int j = 0; j < l.length(); j++)
						{
							Point p1 = (Point) l.moveToPos(j);
							in.insert(p1, xco, yco, length);
						}
						u = in;
						return in;
					}
				}
				// p same as all, so add
				l.insert(p);
				u = this;
				return this;
			}
		}
	}

	/**
	 * Removes node if found
	 * @param x the x coord 
	 * @param y the y coord
	 * @param tx the trees x
	 * @param ty the trees y
	 * @param len the trees length
	 * @return node to be removed
	 */
	@Override
	public PRQuadNode remove(int x, int y, int tx, int ty, int len)
	{ //make a var to get the point -> var is called "r"
		//make a point and use compareTo (equals)
		Point p = new Point(null, x, y);
		nam = l.getName(p);
		l.remove(p);
		//removes first inst of dup
		//return this node 
		//leaf has to become a fly (use merge)
		if (l.isEmpty())
		{
			return Flyweight.fly;
		}
		else 
		{
			return this;
		}
	}

	/**
	 * For the internal
	 */
	public PRQuadNode merge()
	{
		return this;
	}
}


