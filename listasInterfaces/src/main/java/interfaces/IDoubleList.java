/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

public interface IDoubleList<T> extends IList<T> {

    int lastIndexOf(T element);


    void removeLast() throws Exception;
}
