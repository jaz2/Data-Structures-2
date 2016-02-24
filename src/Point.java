/**
 * 
 */

/**
 * In charge of handling identity of points
 * @author Jazmine Zurita and Jessica McCready
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
	 * @param id
	 * @param xcoord
	 * @param ycoord
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
        String s = getX() + ", " + getY();
        return s;
    }

    /**
     * Returns true if rectangles are equal
     * @param re the rectangle to compare to
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
