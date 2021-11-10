package ru.job4j.collection.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {

    private int modCount;
    private  int size;
    private Node<E> first;
    private Node<E> last;

    @Override
    public void add(E value) {
        Node<E> newNode = new Node<>();
        newNode.item = value;
        if (size == 0) {
            last = newNode;
            first = newNode;
        } else {
            Node<E> temp = last;
            last = newNode;
            last.prev = temp;
            temp.next = last;
        }
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        int count = 0;
        Node<E> temp = first;
        while (count < index) {
            temp = temp.next;
            count++;
        }
        return temp.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int expectedModCount = modCount;
            Node<E> current = first;
            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<E> temp = current;
                current = current.next;
                return temp.item;
            }
        };
    }

    private class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;
    }
}
