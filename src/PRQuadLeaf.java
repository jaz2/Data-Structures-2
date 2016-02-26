/**
 * 
 */

/**
 * @author Jazz
 *
 */
public class PRQuadLeaf implements PRQuadNode {

	@Override
	public boolean isLeaf() {
		if (this.getClass().equals(PRQuadLeaf.class))
		{
			return true;
		}
		return false;
	}

	@Override
	public PRQuadNode insert() {
		// TODO Auto-generated method stub
		return null;
	}

}
