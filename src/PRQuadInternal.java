

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
     * Inserts in the regions based on where it is
     * @param p the point 
     * @paran x the xcoord
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
            u = nw;
            //return this;
        }
        else if (p.getX() > x + nuLen && p.getY() <= y + nuLen) //ne
        { 
            ne = ne.insert(p, x + nuLen, y, nuLen);
            u = ne;
            //return this;
        }
        else if (p.getX() <= x + nuLen && p.getY() > y + nuLen) //sw
        { 
            sw = sw.insert(p, x, y + nuLen, nuLen);
            u = sw;
            //return this;
        }
        else
            //if (p.getX() > x + nuLen && p.getY() > y + nuLen) //se
        { 
            se = se.insert(p, x + nuLen, y + nuLen, nuLen);
            u = se;
            //return this;
        }
        return this;
    }
}
