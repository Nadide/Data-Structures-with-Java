/**
 * @author Lewis and Chase
 *
 * Represents a linked implementation of a stack.
 */
package datastructures;

import datastructures.exceptions.*;
import java.util.Iterator;

public class LinkedStack<T> implements StackADT<T> {

    /**
     * indicates number of elements stored
     */
    private int count;
    /**
     * pointer to top of stack
     */
    private LinearNode<T> top;

    /**
     * Creates an empty stack.
     */
    public LinkedStack() {
        count = 0;
        top = null;
    }

    /**
     * Adds the specified element to the top of this stack.
     *
     * @param element element to be pushed on stack
     */
    public void push(T element) {
        LinearNode<T> temp = new LinearNode<T>(element);
        temp.setNext(top);
        top = temp;
        count++;
    }

    /**
     * Removes the element at the top of this stack and returns a reference to
     * it. Throws an EmptyCollectionException if the stack is empty.
     *
     * @return T element from top of stack
     * @throws EmptyStackException on pop from empty stack
     */
    public T pop() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("Stack");
        }

        T result = top.getElement();
        top = top.getNext();
        count--;
        return result;
    }

    /**
     * Returns a reference to the element at the top of this stack. The element
     * is not removed from the stack.
     *
     * @return element on top of stack
     * @throws EmptyCollectionException if the stack is empty
     */
    public T peek() throws EmptyCollectionException {
        return top.getElement();
    }

    /**
     * Returns true if this stack is empty and false otherwise.
     *
     * @return true if stack is empty
     */
    public boolean isEmpty() {
        return (top == null);
    }

    /**
     * Returns the number of elements in this stack.
     *
     * @return number of elements in the stack
     */
    public int size() {
        return count;
    }

    /**
     * Returns a string representation of this stack.
     *
     * @return string representation of the stack
     */
    public String toString() {
        String result = "";
        LinearNode<T> temp = top;
        for (; temp !=  null; temp=temp.getNext()) 
             result = result + temp.getElement() + "\n";

        return result;
    }

}
