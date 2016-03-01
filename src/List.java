

/**
 * 
 */

/**
 * @author Jazmine Zurita and Jessica McCready
 * @version Feb 22 2016
 *
 */
public class List {

    private int len;
    private int size;
    private Point[] l;

    /**
     * Constructor for the List
     */
    public List()
    {
        l = new Point[3];
        len = 3;
        size = 0;
    }

    /**
     * Inserts into the list
     * @param p the point
     */
    public void insert(Point p)
    {
        if (size != 0 && size == len)
        {
            len = len * 2; //change 
            Point[] n = new Point[len];
            for (int i = 0; i < len / 2; i++)
            {
                n[i] = l[i];
            }
            n[size] = p;
            l = n;
            size++;
        }
        else 
        {
            l[size] = p;
            size++;
        }
    }

    /**
     * Moves to this position
     * @param i the position 
     * @return the point at the pos
     */
    public Point moveToPos(int i)
    {
        return l[i];
    }

    /**
     * Removes a point from the list
     * @param p the point
     * @return true or false
     */
    public boolean remove(Point p)
    {
        //Point n = null;
        Boolean found = false;
        for (int i = 0; i < size; i++)
        {
            if (l[i] == p)
            {
                //n = p;
                if (i == size - 1)
                {
                    size--;
                }
                else 
                {
                    for (int j = i; j < size; j++)
                    {
                        l[j] = l[j + 1];
                    }
                    size--;
                }
                found = true;
            }
        }
        return found;
    }

    /**
     * Returns the size
     * @return the size
     */
    public int length()
    {
        return size;
    }
}
