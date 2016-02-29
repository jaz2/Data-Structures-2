/**
 * 
 */

/**
 * The Link point class for LList
 * @author Jazmine Zurita and Jessica McCready
 * @version Feb 22 2016
 *
 * @param <Point> the point to be used
 */
public class Link<Point> {
    private Point e; //val for this node
    private Link<Point> forward;  //should point to next node in list

    /**
     * Constructor that takes in a point and a position
     * @param it the point 
     * @param n the links item
     */
    public Link(Point it, Link<Point> n)
    {
        e = it;
        forward = n;
    }

    /**
     * Constructor that only takes in the position
     * @param n the links item
     */
    public Link(Link<Point> n)
    {
        e = null;
        forward = n;
    }

    /**
     * Returns the point
     * @return e the element
     */
    public Point element()
    {
        return e;
    }

    /**
     * Sets the point to a specific instance
     * @param it the point it will be set to
     * @return the new value 
     */
    public Point setElement(Point it)
    {
        return e = it;
    }

    /**
     * Returns the next link
     * @return next link
     */
    public Link<Point> next()
    {
        return forward;
    }

    /**
     * Sets the next link
     * @param n the next link
     * @return new next
     */
    public Link<Point> setNext(Link<Point> n)
    {
        return forward = n;
    }
}
