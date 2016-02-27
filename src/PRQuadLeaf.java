

/**
 * 
 */

/**
 * @author Jazz
 *
 */
public class PRQuadLeaf implements PRQuadNode {

    LList<Point> l;
    
    PRQuadNode u;

    /**
     * Handles the points
     * @param p the point we're adding 
     * 
     */
    public PRQuadLeaf(Point p) //IS THIS CORRECT TODO
    {
        l = new LList<Point>(0);// need to make our own linked list class
        l.insert(p);
    }


    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * Checks if it is a leaf
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
    
    public void printPoints(int s)
	{
		for(int i = 0; i <= l.length()-1; i++)
		{
			printSpaces(s);
			System.out.println(l.moveToPos(i).toString());
		}
	}

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
                    in = (PRQuadInternal) in.insert((Point)l.moveToPos(0), x, y, length);
                    for (int i = 0; i <= l.length() - 1; i++)
                    {
                    	Point m = (Point)l.moveToPos(i);
                    	in = (PRQuadInternal) in.insert(m, 0, 0, 1024);
                    }
                    u = in;
                    return in;
                }
            }                    
            else //are not the same
            { //split
                PRQuadInternal in = new PRQuadInternal();
                in = (PRQuadInternal) in.insert((Point)l.moveToPos(0), x, y, length);
                for (int i = 0; i <= l.length() - 1; i++)
                {
                	Point m = (Point)l.moveToPos(i);
                	in = (PRQuadInternal) in.insert(m, 0, 0, 1024);
                }
                u = in;
                return in;
            }    
        }

    }
}


