

/**
 * Stores the points into leaves
 * @author Jazmine Zurita and Jessica McCready
 * @version Feb 21 2016
 *
 */
public class PRQuadtree{

	/**
	 * Used to look at leaf and internal
	 * @author Jazmine Zurita and Jessica McCready
	 *
	 */
	abstract class PRQuadNode{}

	/**
	 * The leaf object
	 * @author Jazmine Zurita and Jessica McCready
	 *
	 */
	public class PRQuadLeaf extends PRQuadNode
	{
		Link<Point> l;

		/**
		 * Handles the points
		 * @param p the point we're adding 
		 * 
		 */
		public PRQuadLeaf(Point p) //IS THIS CORRECT TODO
		{
			l = new Link<Point>();// need to make our own linked list class
			l.setElement(p);
			
		}
	}

	/**
	 * For the internal node of PRQuadtree
	 * @author Jazmine Zurita and Jessica McCready
	 *
	 */
	public class PRQuadInternal extends PRQuadNode
	{
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
		{ //TODO ask about flyweight
			NE = fly;
			NW = fly;
			SE = fly;
			SW = fly;
		}
	}
	
	/**
	 * The root 
	 */
	public PRQuadNode root;

	/**
	 * Instance of the node which is set to null
	 * MAY BE USED FOR FLYWEIGHT
	 */
	public PRQuadNode fly;
	
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
		root = null;
		fly = null; //don't initialize vals in fly, initialize a new node obj and store it there
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
	public PRQuadNode insert(PRQuadNode node, Point p, int xco, int yco, int length)
	{ //try and make it node-centric (within the node class to avoid copying it over)
		if (node == null) //should point to a fly and when u create it should point to a leaf
		{
			node = fly;
			PRQuadLeaf lef = new PRQuadLeaf(p);
			node = lef;
			return lef;
		}
		if (node.getClass().equals(PRQuadLeaf.class))
		{
			PRQuadLeaf lef = (PRQuadLeaf)node; //here is when u make it internal
			
		}
		if (node.getClass().equals(PRQuadInternal.class))
		{
			PRQuadInternal in = (PRQuadInternal)node;
			int nuLen = length/2;
			if (p.getX() >= xco + nuLen && p.getY() <= yco + nuLen /*in.NE*/) //TODO!!!!!
			{ 
				in.NE = insert(in.NE, p, nuLen + xco, yco, nuLen);
			}
			if (in == in.NW)
			{}
			return in;
		}
		return node;
	}
}
