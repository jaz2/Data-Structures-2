

/**
 * 
 */

/**
 * @author Jazz
 *
 */
public class PRQuadLeaf implements PRQuadNode {

	LList<Point> l;

	/**
	 * Handles the points
	 * @param p the point we're adding 
	 * 
	 */
	public PRQuadLeaf(Point p) //IS THIS CORRECT TODO
	{
		l = new LList<Point>();// need to make our own linked list class
		l.insert(p);
	}


	@Override
	public boolean isEmpty() {
		if (l.length() == 0)
			return true;
		return false;
	}

	/**
	 * Checks if it is a leaf
	 */
	@Override
	public boolean isLeaf() {
		if (this.getClass().equals(PRQuadLeaf.class))
		{
			return true;
		}
		return false;
	}

	/**
	 * Inserts into a leaf and splits based on number of points
	 */
	@Override
	public PRQuadNode insert(Point p, int x, int y, int length) {
		if (l.length() >= 2)
		{
			l.insert(p);
			return this;
		}
		else 
		{ //check duplicates if they are the same you don't split
			int count = 0; //if they are not then count to 4 and split
			for (int i = 0; i < l.length() - 2; i++)
			{
				if (l.moveToPos(i).equals(l.moveToPos(i + 1)))	
				{
					count++;
				}
			}
			if (count == l.length() - 1)
			{
				if (l.getValue().equals(p)) //they are the same
				{
					l.insert(p);
					return this;

				}
				else //split
				{
					PRQuadInternal in = new PRQuadInternal();
					insert((Point)l.moveToPos(0), x, y, length);
					return in;
				}
			}					
			else //are not the same
			{ //split
				PRQuadInternal in = new PRQuadInternal();
				insert((Point)l.moveToPos(0), x, y, length);
				return in;
			}	
		}

	}
}


