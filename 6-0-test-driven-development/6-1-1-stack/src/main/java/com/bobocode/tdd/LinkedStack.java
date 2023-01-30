package com.bobocode.tdd;

import com.bobocode.util.ExerciseNotCompletedException;

import java.util.Objects;

public class LinkedStack<T> implements Stack<T> {
    public class Node<T>{
        T element;
        Node<T> nextNode;

        public Node(T element) {
            this.element = element;
        }
    }

    Node<T> head;
    int size;

    @Override
    public void push(T element) {
        Objects.requireNonNull(element);
        Node<T> newNode = new Node<>(element);
        if(head!=null){
            newNode.nextNode = head;
        }
        head = newNode;
        size ++;
    }
    
    @Override
    public T pop() {
        T result = null;
        if(head!=null){
            result = head.element;
            head = head.nextNode;
        }
        size--;
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
