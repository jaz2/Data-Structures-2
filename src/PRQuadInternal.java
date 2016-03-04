
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
     * The remove for internal
     * @param n the name of the point
     * @param px the points x
     * @param py the points y
     * @param tx the trees x
     * @param ty the trees y
     * @param len the length
     * @return the node
     */
    @Override
    public PRQuadNode remove(String n, int px, int py, int tx, int ty, int len)
    { //check if children have the necessary conditions to become a flyweight
        //just like how leafs decompose to internals, 
        //internals will decompose to flyweight
        //also check if size is less than four or greater than 
        //or equal to one and make internal a leaf
        //check if all empty except one, which has 100 
        //things but all the same, just return that leaf
        int nuLen = len / 2;
        if (px <= tx + nuLen) //&& py <= ty + nuLen) //nw
        {
            if (py <= ty + nuLen) //nw 
            {
                nw = nw.remove(n, px, py, tx, ty, nuLen);
                nw = nw.merge();
            }
            else //sw = py < ty + nuLen
            {
                sw = sw.remove(n, px, py, tx, ty + nuLen, nuLen);
                sw = sw.merge();
            }
        }
        else 
        {
            if (py <= ty + nuLen) //ne
            {
                ne = ne.remove( n, px, py, tx + nuLen, ty, nuLen);
                ne = ne.merge();
            }
            else //if (p.getX() > x + nuLen && p.getY() > y + nuLen) //se
            {
                se = se.remove( n, px, py, tx + nuLen, ty + nuLen, nuLen);
                se = se.merge();
            }
        }
        u = this;
        return merge();
    }

    /**
     * Checks the children of the internal
     * to determine whether it should be a 
     * leaf or fly weight or remain
     * @return the node
     */
    public PRQuadNode merge()
    {
        int total = 0;
        PRQuadLeaf sum = null;
        List list = new List();
        if (nw.getClass().equals(this.getClass()) 
                || (ne.getClass().equals(this.getClass()))
                || (sw.getClass().equals(this.getClass()))
                || (se.getClass().equals(this.getClass())))
        {
            return this;
        }
        if (nw.isLeaf())
        {
            for (int i = 0; i < ((PRQuadLeaf)nw).l.length(); i++)
            {
                list.insert(((PRQuadLeaf)nw).l.moveToPos(i));
            }
            sum = (PRQuadLeaf) nw;
            total++;
        }
        if (ne.isLeaf())
        {
            for (int i = 0; i < ((PRQuadLeaf)ne).l.length(); i++)
            {
                list.insert(((PRQuadLeaf)ne).l.moveToPos(i));
            }
            sum = (PRQuadLeaf) ne;
            total++;
        }
        if (sw.isLeaf())
        {
            for (int i = 0; i < ((PRQuadLeaf)sw).l.length(); i++)
            {
                list.insert(((PRQuadLeaf)sw).l.moveToPos(i));
            }
            sum = (PRQuadLeaf) sw;
            total++;
        }
        if (se.isLeaf())
        {
            for (int i = 0; i < ((PRQuadLeaf)se).l.length(); i++)
            {
                list.insert(((PRQuadLeaf)se).l.moveToPos(i));
            }
            sum = (PRQuadLeaf) se;
            total++;
        }
        if (total == 1)
        {
            return sum;
        }
        if (total > 1)
        {
            if (list.length() > 3)
            {
                return this;
            }
            else 
            {
                PRQuadLeaf nu = new PRQuadLeaf(list.moveToPos(0));
                for (int i = 1; i < list.length(); i++)
                {
                    nu.l.insert(list.moveToPos(i));
                }
            }
        }
        return this; //see if this is right
    }
}
