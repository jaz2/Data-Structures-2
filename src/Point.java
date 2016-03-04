/**
 * 
 */

/**
 * In charge of handling identity of points
 * @author Jazmine Zurita and Jessica McCready
 * @version March 2 2016
 *
 */
public class Point {
    /**
     * Name of the point
     */
    String name;

    /**
     * The x coord
     */
    int x;

    /**
     * The y coord
     */
    int y;

    /**
     * The constructor of the Point class
     * 
     * @param id name of the string
     * @param xcoord points x
     * @param ycoord points y
     */
    public Point(String id, int xcoord, int ycoord)
    {
        name = id;
        x = xcoord;
        y = ycoord;
    }

    /**
     * Returns the name of the Point
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns the x 
     * @return the y
     */
    public int getX()
    {
        return x;
    }

    /**
     * Returns the y 
     * @return the y
     */
    public int getY()
    {
        return y;
    }

    /**
     * Returns the toString of the four values
     * @return the string
     */
    public String toString()
    {
        String s = "(" + getName() + ", " + getX() + ", " + getY() + ")";
        return s;
    }

    /**
     * Returns true if rectangles are equal
     * @param p the point to compare to
     * @return true or false
     */
    @Override
    public boolean equals(Object p)
    {       
        if (x == ((Point) p).getX() && y == ((Point) p).getY())
            return true;
        else return false;
    }
}
