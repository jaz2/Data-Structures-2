

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
     * @param p the point
     * @param x the x
     * @param y the y
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
            //if my size is already > 3 they must all be duplicates so only check the first element
            if (l.length() > 3)
            {
                if(p.equals(l.moveToPos(0))) //p same so add
                {
                    l.insert(p);
                    u = this;
                    return this;
                }
                else  //p diff so split
                {
                    PRQuadInternal in = new PRQuadInternal();
                    in.insert(p,xco, yco, length);
                    for (int i = 0; i < l.length(); i++)
                    {
                        Point p1 = (Point) l.moveToPos(i);
                        in.insert(p1,xco, yco, length);
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
                    if(!p.equals(l.moveToPos(i))) //p diff 
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
}


