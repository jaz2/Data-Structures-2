

/**
 * 
 */

/**
 * @author Jazmine Zurita and Jessica McCready
 * @version Feb 22 2016
 *
 */
public class List {

    //private Point head;
    private Point curr;
    private int size;
    private Point[] l;

    public List()
    {
        l = new Point[0];
        size = 0;
    }

    /**
     * Inserts into the list
     * @param p
     */
    public void insert(Point p)
    {
        l[size] = p;
        size++;
    }

    /**
     * 
     * @param i the position 
     * @return the point at the pos
     */
    public Point moveToPos(int i)
    {
        return l[i];
    }

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
     * @return
     */
    public int length()
    {
        return size;
    }
}