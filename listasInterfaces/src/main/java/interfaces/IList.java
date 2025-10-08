/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import excepciones.ListException;


public interface IList<T> {

    
    void set(T o, int i) throws ListException;


    boolean remove(T o) throws ListException;


    int indexOf(T o);


    void clear();

 
    void add(T o);

 
    int size();


    T get(int i) throws ListException;

    
    boolean isEmpty();
}