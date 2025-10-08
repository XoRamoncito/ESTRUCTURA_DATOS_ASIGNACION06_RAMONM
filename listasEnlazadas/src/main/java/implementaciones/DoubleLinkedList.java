package implementaciones;

import interfaces.IList;
import excepciones.ListException;

public class DoubleLinkedList<T> implements IList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DoubleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void set(T o, int i) throws ListException {
        if (i < 0 || i >= size) {
            throw new ListException("Índice fuera de rango");
        }
        Node<T> current = head;
        for (int j = 0; j < i; j++) {
            current = current.next;
        }
        current.data = o;
    }

    @Override
    public boolean remove(T o) throws ListException {
        if (isEmpty()) {
            throw new ListException("La lista está vacía");
        }
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(o)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }

                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int indexOf(T o) {
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(o)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void add(T o) {
        Node<T> newNode = new Node<>(o);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int i) throws ListException {
        if (i < 0 || i >= size) {
            throw new ListException("Índice fuera de rango");
        }
        Node<T> current = head;
        for (int j = 0; j < i; j++) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // Clase interna para nodos
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
        }
    }
}
