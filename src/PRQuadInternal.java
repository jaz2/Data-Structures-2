

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

    public PRQuadNode sw()
    {
        return sw;
    }

    public PRQuadNode se()
    {
        return se;
    }

    public PRQuadNode nw()
    {
        return nw;
    }

    public PRQuadNode ne()
    {
        return ne;
    }

    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public boolean isempty() {
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
     * Inserts in the regions based on where it is
     * @param p the point 
     * @paran x the xcoord
     * @param y the ycoord
     * @param length the length
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
