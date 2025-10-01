package implementacion;

import excepciones.ListException;
import interfaces.IList;
import java.util.Arrays;

/**
 * Implementación de IList usando un arreglo dinámico.
 * @param <T> Tipo de datos.
 */
public class ArrayList<T> implements IList<T> {

    private T[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Constructor por defecto.
     */
    @SuppressWarnings("unchecked")
    public ArrayList() {
        data = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void add(T o) {
        ensureCapacity();
        data[size++] = o;
    }

    private void ensureCapacity() {
        if (size == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
    }

    @Override
    public void set(T o, int i) throws ListException {
        if (size == 0) throw new ListException("La lista está vacía.");
        if (i < 0 || i >= size) throw new ListException("Índice fuera de rango.");
        data[i] = o;
    }

    @Override
    public boolean remove(T o) throws ListException {
        if (size == 0) throw new ListException("La lista está vacía.");
        int index = indexOf(o);
        if (index == -1) return false;
        for (int j = index; j < size - 1; j++) {
            data[j] = data[j + 1];
        }
        data[--size] = null;
        return true;
    }

    @Override
    public int indexOf(T o) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(o)) return i;
        }
        return -1;
    }

    @Override
    public void clear() {
        Arrays.fill(data, 0, size, null);
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int i) throws ListException {
        if (i < 0 || i >= size) throw new ListException("Índice fuera de rango.");
        return data[i];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}

