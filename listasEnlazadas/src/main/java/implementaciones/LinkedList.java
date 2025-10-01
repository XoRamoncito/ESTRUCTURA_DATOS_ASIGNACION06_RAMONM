package implementaciones;

import interfaces.IList;
import excepciones.ListException;

/**
 * Implementación de IList usando una lista enlazada.
 * @param <T> Tipo de datos.
 */
public class LinkedList<T> implements IList<T> {

    private class Node {
        T data;
        Node next;
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public void add(T o) {
        Node newNode = new Node(o);
        if (head == null) {
            head = newNode;
        } else {
            Node aux = head;
            while (aux.next != null) {
                aux = aux.next;
            }
            aux.next = newNode;
        }
        size++;
    }

    @Override
    public T get(int i) throws ListException {
        if (isEmpty()) throw new ListException("La lista está vacía.");
        if (i < 0 || i >= size) throw new ListException("Índice fuera de rango.");

        Node aux = head;
        for (int j = 0; j < i; j++) {
            aux = aux.next;
        }
        return aux.data;
    }

    @Override
    public void set(T o, int i) throws ListException {
        if (isEmpty()) throw new ListException("La lista está vacía.");
        if (i < 0 || i >= size) throw new ListException("Índice fuera de rango.");

        Node aux = head;
        for (int j = 0; j < i; j++) {
            aux = aux.next;
        }
        aux.data = o;
    }

    @Override
    public boolean remove(T o) throws ListException {
        if (isEmpty()) throw new ListException("La lista está vacía.");

        if (head.data.equals(o)) {
            head = head.next;
            size--;
            return true;
        }

        Node aux = head;
        while (aux.next != null) {
            if (aux.next.data.equals(o)) {
                aux.next = aux.next.next;
                size--;
                return true;
            }
            aux = aux.next;
        }
        return false;
    }

    @Override
    public int indexOf(T o) {
        Node aux = head;
        int index = 0;
        while (aux != null) {
            if (aux.data.equals(o)) return index;
            aux = aux.next;
            index++;
        }
        return -1;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
                