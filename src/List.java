

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
     * Finds the name of the point
     * @param name the name 
     * @param p the point
     * @return the string
     */
    public String getName(String name, Point p)
    {
        String s = null;
        if (name == null)
        {
            for (int i = 0; i < size; i++)
            {
                if (l[i].equals(p))
                {
                    s = l[i].name;
                    remove(l[i]);
                    return s;
                }
            }
            return null;
        }
        else 
        {
            boolean removed = false;
            int i = 0;
            while (i < size && !removed)
            {
                if (l[i].equals(p) && l[i].getName().equals(name))
                {
                    remove(l[i]);
                    removed = false;
                    return name;
                }
                i++;
            }
        }
        return null;
    }

    /**
     * Removes a point from the list
     * @param p the point
     * @return true or false
     */
    public boolean remove(Point p)
    {
        Boolean found = false;
        for (int i = 0; i < size && !found; i++)
        {
            if (l[i].equals(p) && l[i].getName().equals(p.getName()))
            {
                if (i == size - 1)
                {
                    size--;
                }
                else 
                {
                    for (int j = i; j < size - 1; j++)
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

    /**
     * Returns true if size is 0,
     * false otherwise
     * @return t or f
     */
    public boolean isEmpty()
    {
        return size == 0;
    }

    //    /**
    //     * Checks if the points are unique or 
    //     * the same
    //     * @return true or false
    //     */
    //    public boolean isUnique()
    //    {
    //        //leaf then look at points and see if duplicates
    //        //(if size >3 dont have to check, if size <=3 then check)
    //        if (size > 3) //all dups
    //        {
    //            return false;
    //        }
    //        else if (size == 3)
    //        {
    //            if (l[0].equals(l[1]))
    //            {
    //                return false;
    //            }
    //            else if (l[1].equals(l[2]))
    //            {
    //                return false;
    //            }
    //            else if (l[0].equals(l[2]))
    //            {
    //                return false;
    //            }
    //        }
    //        else if (size == 2)
    //        {
    //            if (l[0].equals(l[1]))
    //            {
    //                return false;
    //            }
    //        }
    //        return true;
    //    }
}
