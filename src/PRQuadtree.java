

/**
 * Stores the points into leaves
 * @author Jazmine Zurita and Jessica McCready
 * @version Feb 21 2016
 *
 */
public class PRQuadtree{
	
	/**
	 * The root 
	 */
	public PRQuadNode root;
	

	/**
	 * The x coord
	 */
	int x;

	/**
	 * The y coord
	 */
	int y;

	/**
	 * The length
	 */
	int length;

	/**
	 * The PRQuadtree constructor
	 * 
	 * @param xcoord the x coord
	 * @param ycoord the y coord
	 * @param len the height/weight
	 */
	public PRQuadtree(int xcoord, int ycoord, int len)
	{
		root = Flyweight.fly; //don't initialize vals in fly, initialize a new node obj and store it there
		x = xcoord;
		y = ycoord;
		length = len;
	}

	/**
	 * The insert method 
	 * 
	 * @param node  checks node
	 * @param p  the point to be added
	 * @param loX  the lower x bound to check
	 * @param hiX  the higher x bound to check
	 * @param loY  the lower y bound to check
	 * @param hiY  the higher y bound to check
	 * @return the node
	 */
	public PRQuadNode insert(Point p, int x, int y, int length)
	{ //try and make it node-centric (within the node class to avoid copying it over)
		root = root.insert(p, x, y, length);
		return root;
	}
}
