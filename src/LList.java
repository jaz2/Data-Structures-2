
/**
 * 
 */

// Linked list implementation
/**
 * 
 * @author Jazmine Zurita and Jessica McCready
 * @version Feb 22 2016
 *
 * @param <Point> the point class
 */
class LList<Point> {

    /**
     * Pointer to the header node of the list
     */
    private Link<Point> head;

    /**
     * Pointer to the last element in the list
     */
    private Link<Point> tail;

    /**
     * Access to current element
     */
    private Link<Point> curr;

    /**
     * Size of the list
     */
    private int listSize;

    /**
     * Constructor for the list
     * @param size the size of the list
     */
    LList(int size) 
    { 
        this(); 
    }     

    /**
     * Resets the size and list
     */
    LList() 
    { 
        clear(); 
    }

    /**
     * Resets all items in the list
     */
    public void clear() {
        curr = tail = new Link<Point>(null); // Create trailer
        head = new Link<Point>(tail);        // Create header
        listSize = 0;
    }

    /**
     * Inserts element at current position
     * @param it the element to be inserted
     * @return true or false
     */
    @SuppressWarnings("unchecked")
    public boolean insert(Object it) {
        curr.setNext(new Link<Point>(curr.element(), curr.next()));
        curr.setElement((Point)it);
        if (tail == curr) 
            tail = curr.next();  // New tail
        listSize++;
        return true;
    }

    /**
     * Inserts into the tail
     * @param it item to be inserted
     * @return true or false
     */
    @SuppressWarnings("unchecked")
    public boolean append(Object it) {
        tail.setNext(new Link<Point>(null));
        tail.setElement((Point)it);
        tail = tail.next();
        listSize++;
        return true;
    }

    /**
     * Removes and returns the current element
     * @return
     */
    public Object remove () {
        if (curr == tail) return null;          // Nothing to remove
        Object it = curr.element();             // Remember value
        curr.setElement(curr.next().element()); // Pull forward the next element
        if (curr.next() == tail) 
            tail = curr;   // Removed last, move tail
        curr.setNext(curr.next().next());       // Point around unneeded link
        listSize--;                             // Decrement element count
        return it;                              // Return value
    }

    /**
     * Moves the position to the beginning
     */
    public void moveToStart() 
    { 
        curr = head.next(); 
    }

    /**
     * Sets the current to the end
     */
    public void moveToEnd() 
    { 
        curr = tail; 
    }

    /**
     * Move current back by one
     */
    public void prev() {
        if (head.next() == curr) 
            return; // No previous element
        Link<Point> temp = head;
        // March down list until we find the previous element
        while (temp.next() != curr) 
            temp = temp.next();
        curr = temp;
    }

    // Move curr one step right; no change if now at end
    /**
     * The next element
     */
    public void next() 
    { 
        if (curr != tail) 
            curr = curr.next(); 
    }

    /**
     * The length
     * @return the number 
     */
    public int length() 
    { 
        return listSize; 
    }

    /**
     * Return the position of curr element
     * @return the element
     */
    public int currPos() {
        Link<Point> temp = head.next();
        int i;
        for (i=0; curr != temp; i++)
            temp = temp.next();
        return i;
    }

    /**
     * moves to the ith posiion
     * @param pos the position
     * @return the element at the pos
     */
    public Object moveToPos(int pos) {
        if ((pos < 0) || (pos > listSize)) 
        {
            return false;
        }
        curr = head.next();
        for (int i = 0; i < pos; i++) 
        {
            curr = curr.next();
        }
        return curr.element();
    }

    /**
     * True if it is at end
     * @return true or false
     */
    public boolean isAtEnd() 
    { 
        return curr == tail; 
    }

    /**
     * Returns the current elements value
     * If it's at the tail it is null
     * @return the element
     */
    public Object getValue() 
    {
        return curr.element();
    }
}
