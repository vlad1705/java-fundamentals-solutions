package com.bobocode.cs;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * {@link LinkedQueue} implements FIFO {@link Queue}, using singly linked nodes. Nodes are stores in instances of nested
 * class Node. In order to perform operations {@link LinkedQueue#add(Object)} and {@link LinkedQueue#poll()}
 * in a constant time, it keeps to references to the head and tail of the queue.
 * <p><p>
 * <strong>TODO: to get the most out of your learning, <a href="https://www.bobocode.com/learn">visit our website</a></strong>
 * <p>
 *
 * @param <T> a generic parameter
 * @author Taras Boychuk
 * @author Ivan Virchenko
 */
public class LinkedQueue<T> implements Queue<T> {

    private static class Node<T>{
        T element;
        Node<T> next;

        public static <T> Node<T> valueOf(T element){
            return new Node<>(element);
        }

        public Node(T element) {
            this.element = element;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * Adds an element to the end of the queue.
     *
//     * @param element the element to add
     */
    public static <T> LinkedQueue<T> of(T... elements){
        LinkedQueue<T> linkedQueue = new LinkedQueue<>();
        Stream.of(elements).forEach(linkedQueue::add);
        return linkedQueue;
    }

    public void add(T element) {
        Objects.requireNonNull(element);
        Node<T> newNode = Node.valueOf(element);
        if(size == 0){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }

        size ++;
    }

    /**
     * Retrieves and removes queue head.
     *
     * @return an element that was retrieved from the head or null if queue is empty
     */
    public T poll() {
        if(head != null){
            T element = head.element;
            head = head.next;
            if(head==null){
                tail=null;
            }
            size--;
            return element;
        }else {
            return null;
        }
    }

    /**
     * Returns a size of the queue.
     *
     * @return an integer value that is a size of queue
     */
    public int size() {
        return size; // todo: implement this method
    }

    /**
     * Checks if the queue is empty.
     *
     * @return {@code true} if the queue is empty, returns {@code false} if it's not
     */
    public boolean isEmpty() {
        return size == 0;
    }
}

