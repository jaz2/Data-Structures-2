

public class PRQuadInternal implements PRQuadNode {

    /**
     * For testing purposes
     */
    PRQuadNode u;

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
    { 
        NW = Flyweight.fly;
        NE = Flyweight.fly;
        SW = Flyweight.fly;
        SE = Flyweight.fly;
    }

    public PRQuadNode SW()
    {
        return SW;
    }

    public PRQuadNode SE()
    {
        return SE;
    }

    public PRQuadNode NW()
    {
        return NW;
    }

    public PRQuadNode NE()
    {
        return NE;
    }

    @Override
    public boolean isLeaf() {
        return false;
    }

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
     * Inserts in the regions based on where it is
     * @param p the point 
     * @paran x the xcoord
     * @param y the ycoord
     * @param length the length
     */
    @Override
    public PRQuadNode insert(Point p, int x, int y, int length) {
        int nuLen = length / 2;
        if (p.getX() <= x + nuLen && p.getY() <= y + nuLen) //NW
        {
            NW = NW.insert(p, x, y, nuLen);
            u = NW;
            return NW;
        }
        else if (p.getX() > x + nuLen && p.getY() <= y + nuLen) //NE
        { 
            NE = NE.insert(p, x + nuLen, y, nuLen);
            u = NE;
            return NE;
        }
        else if (p.getX() <= x + nuLen && p.getY() > y + nuLen) //SW
        { 
            SW = SW.insert(p, x, y + nuLen, nuLen);
            u = SW;
            return SW;
        }
        else
            //if (p.getX() > x + nuLen && p.getY() > y + nuLen) //SE
        { 
            SE = SE.insert(p, x + nuLen, y + nuLen, nuLen);
            u = SE;
            return SE;
        }
    }
}
