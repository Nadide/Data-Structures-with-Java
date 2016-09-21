/**
 * ArrayList represents an array implementation of a list. The front of
 * the list is kept at array index 0. This class will be extended
 * to create a specific kind of list.
 *
 * @author Dr. Lewis
 * @author Dr. Chase
 * @version 1.0, 08/13/08
 */
package datastructures;

import datastructures.exceptions.*;
import java.util.Iterator;

public class ArrayList<T> implements ListADT<T>, Iterable<T> {

    protected final int DEFAULT_CAPACITY = 100;
    private final int NOT_FOUND = -1;
    protected int rear;
    protected T[] list;

    /**
     * Creates an empty list using the default capacity.
     */
    public ArrayList() {
        rear = 0;
        list = (T[]) (new Object[DEFAULT_CAPACITY]);
    }

    /**
     * Creates an empty list using the specified capacity.
     *
     * @param initialCapacity the integer value of the size of the array list
     */
    public ArrayList(int initialCapacity) {
        rear = 0;
        list = (T[]) (new Object[initialCapacity]);
    }

    @Override
    public T removeFirst() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T removeLast() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Removes and returns the specified element.
     *
     * @param element the element to be removed and returned from the list
     * @return the removed element
     * @throws ElementNotFoundException if an element not found exception occurs
     */
    public T remove(T element) {
        T result;
        int index = find(element);
        if (index == NOT_FOUND) {
            throw new ElementNotFoundException("list");
        }
        result = list[index];
        rear--;
// shift the appropriate elements
        for (int scan = index; scan < rear; scan++) {
            list[scan] = list[scan + 1];
        }
        list[rear] = null;
        return result;
    }

    @Override
    public T first() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T last() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Returns the array index of the specified element, or the constant
     * NOT_FOUND if it is not found.
     *
     * @param target the element that the list will be searched for
     * @return the integer index into the array containing the target element,
     * or the NOT_FOUND constant
     */
    private int find(T target) {
        int scan = 0, result = NOT_FOUND;
        boolean found = false;
        if (!isEmpty()) {
            while (!found && scan < rear) {
                if (target.equals(list[scan])) {
                    found = true;
                } else {
                    scan++;
                }
            }
        }
        if (found) {
            result = scan;
        }
        return result;
    }

    /**
     * Returns true if this list contains the specified element.
     *
     * @param target the element that the list is searched for
     * @return true if the target is in the list, false if otherwise
     */
    public boolean contains(T target) {
        return (find(target) != NOT_FOUND);
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Returns an iterator for the elements currently in this list.
     *
     * @return an iterator for the elements in this list
     */
    public Iterator<T> iterator() {
        return new ArrayIterator<T>(list, rear);
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //-----------------------------------------------------------------
    //  Returns a string representation of this list. 
    //-----------------------------------------------------------------
    public String toString() {
        String result = "";

        for (int scan = 0; scan < rear; scan++) {
            result = result + list[scan].toString() + "\n";
        }

        return result;
    }

    //-----------------------------------------------------------------
    //  Creates a new array to store the contents of the list with
    //  twice the capacity of the old one.
    //-----------------------------------------------------------------
    protected void expandCapacity() {
        T[] larger = (T[]) (new Object[list.length * 2]);

        for (int scan = 0; scan < list.length; scan++) {
            larger[scan] = list[scan];
        }

        list = larger;
    }
}
