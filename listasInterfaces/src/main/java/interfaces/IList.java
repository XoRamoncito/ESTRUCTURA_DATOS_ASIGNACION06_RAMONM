/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import excepciones.ListException;

/**
 * Interfaz genérica para listas.
 * @param <T> Tipo de datos almacenados.
 */
public interface IList<T> {

    /**
     * Reemplaza el elemento en la posición i por o.
     * @param o Nuevo objeto.
     * @param i Índice.
     * @throws ListException si la lista está vacía o índice inválido.
     */
    void set(T o, int i) throws ListException;

    /**
     * Elimina la primera ocurrencia de o.
     * @param o Elemento a eliminar.
     * @return true si fue eliminado, false si no existe.
     * @throws ListException si la lista está vacía.
     */
    boolean remove(T o) throws ListException;

    /**
     * Regresa el índice de la primera ocurrencia de o.
     * @param o Elemento a buscar.
     * @return índice o -1 si no existe.
     */
    int indexOf(T o);

    /**
     * Elimina todos los elementos de la lista.
     */
    void clear();

    /**
     * Agrega un elemento al final de la lista.
     */
    void add(T o);

    /**
     * @return número de elementos en la lista.
     */
    int size();

    /**
     * Obtiene el elemento en la posición i.
     * @throws ListException si el índice es inválido.
     */
    T get(int i) throws ListException;

    /**
     * Verifica si la lista está vacía.
     */
    boolean isEmpty();
}
