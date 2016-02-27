

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
    LList<Point> l;
    
    /**
     * For testing purposes
     */
    PRQuadNode u;

    /**
     * Handles the points
     * @param p the point we're adding 
     * 
     */
    public PRQuadLeaf(Point p)
    {
        l = new LList<Point>(0); 
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
    
    /**
     * Prints out
     * @param s the spaces
     */
    public void printPoints(int s)
	{
		for(int i = 0; i <= l.length()-1; i++)
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
     * Inserts into a leaf and splits based on number of points
     * @return the nodes
     */
    @Override
    public PRQuadNode insert(Point p, int x, int y, int length) {
        if (l.length() <= 2)
        {
            l.insert(p);
            u = this;
            return this;
        }
        else 
        { //check duplicates if they are the same you don't split
            int count = 0; //if they are not then count to 4 and split
            for (int i = 0; i <= l.length() - 2; i++)
            {
                if (l.moveToPos(i).equals(l.moveToPos(i + 1)))    
                {
                    count++;
                }
            }
            if (count == l.length() - 1)
            {
                if (l.moveToPos(l.length() - 1).equals(p)) //they are the same
                {
                    l.insert(p);
                    u = this;
                    return this;

                }
                else //split
                {
                    PRQuadInternal in = new PRQuadInternal();
                    in.insert(p, x, y, length);
                    for (int i = 0; i <= l.length() - 1; i++)
                    {
                    	Point m = (Point)l.moveToPos(i);
                    	in.insert(m, x, y, length);
                    }
                    u = in;
                    return in;
                }
            }                    
            else //are not the same
            { //split
                PRQuadInternal in = new PRQuadInternal();
                in.insert(p, x, y, length);
                for (int i = 0; i <= l.length() - 1; i++)
                {
                	Point m = (Point)l.moveToPos(i);
                	in.insert(m, x, y, length);
                }
                u = in;
                return in;
            }    
        }

    }
}


