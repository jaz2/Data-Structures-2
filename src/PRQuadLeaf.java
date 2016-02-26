import java.util.LinkedList;

import PRQuadtree.PRQuadInternal;
import PRQuadtree.PRQuadLeaf;

/**
 * 
 */

/**
 * @author Jazz
 *
 */
public class PRQuadLeaf implements PRQuadNode {
	
	LinkedList<Point> l;

	/**
	 * Handles the points
	 * @param p the point we're adding 
	 * 
	 */
	public PRQuadLeaf(Point p) //IS THIS CORRECT TODO
	{
		l = new LinkedList<Point>();// need to make our own linked list class
		l.add(p);
	}

	@Override
	public boolean isLeaf() {
		if (this.getClass().equals(PRQuadLeaf.class))
		{
			return true;
		}
		return false;
	}

	@Override
	public PRQuadNode insert(Point p, int x, int y, int length) {
		// TODO Auto-generated method stub
		PRQuadLeaf lef = (PRQuadLeaf)this; 
		//insert
		if (lef.l.size() >= 2)
		{
			//insert
		}
		else 
		{ //check duplicates if they are the same you don't split
			int count = 0; //if they are not then count to 4 and split
			for (int i = 0; i < lef.l.size() - 2; i++)
			{
				if (lef.l.get(i).equals(lef.l.get(i + 1)))	
				{
					count++;
				}
			}
			if (count == lef.l.size() - 1)
			{
				if (lef.l.getLast().equals(p)) //they are the same
				{
					lef = insert(p, xco, yco, length);//(call insert method)
				}
				else //split
				{
					PRQuadInternal in = new PRQuadInternal();
					//do something
					return in;
				}
			}					
			else //are not the same
			{
				//split
				PRQuadInternal in = new PRQuadInternal();
				//something
				return in;
			}	
		}

	}
	}

}
