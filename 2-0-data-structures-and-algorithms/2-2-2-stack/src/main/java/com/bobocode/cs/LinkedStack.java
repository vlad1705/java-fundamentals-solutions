package com.bobocode.cs;

import java.util.EmptyStackException;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * {@link LinkedStack} is a stack implementation that is based on singly linked generic nodes.
 * A node is implemented as inner static class {@link Node<T>}.
 * <p><p>
 * <strong>TODO: to get the most out of your learning, <a href="https://www.bobocode.com/learn">visit our website</a></strong>
 * <p>
 *
 * @param <T> generic type parameter
 * @author Taras Boychuk
 * @author Serhii Hryhus
 */
public class LinkedStack<T> implements Stack<T> {
    private static class Node<T> {
        T element;
        Node<T> next;

        // todo: try to delete
        public static <T> Node<T> valueOf(T element) {
            return new Node<>(element);
        }

        public Node(T element) {
            this.element = element;
        }
    }

    private Node<T> head;
    private int size;


    /**
     * This method creates a stack of provided elements
     *
     * @param elements elements to add
     * @param <T>      generic type
     * @return a new stack of elements that were passed as method parameters
     */
    public static <T> LinkedStack<T> of(T... elements) {
        LinkedStack<T> linkedStack = new LinkedStack<>();
        Stream.of(elements).forEach(linkedStack::push);
        return linkedStack;
    }

    /**
     * The method pushes an element onto the top of this stack. This has exactly the same effect as:
     * addElement(item)
     *
     * @param element elements to add
     */
    @Override
    public void push(T element) {
        Objects.requireNonNull(element);
        // todo try to replace with new Node<>(ele)
        Node<T> newNode = new Node<>(element);
        if (size != 0)
            newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     * This method removes the object at the top of this stack
     * and returns that object as the value of this function.
     *
     * @return The object at the top of this stack
     * @throws EmptyStackException - if this stack is empty
     */
    @Override
    public T pop() {
        // todo: implement this method
        T element = null;

        if (head != null) {
            size--;
            element = head.element;
            head = head.next;
        } else {
            throw new EmptyStackException();
        }

        return element;
    }

    /**
     * Returns the number of elements in the stack
     *
     * @return number of elements
     */
    @Override
    public int size() {
        return size; // todo: implement this method
    }

    /**
     * Checks if a stack is empty
     *
     * @return {@code true} if a stack is empty, {@code false} otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0; // todo: implement this method;
    }

}