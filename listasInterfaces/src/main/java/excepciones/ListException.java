/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 * Excepción personalizada para operaciones inválidas en listas.
 */
public class ListException extends RuntimeException {

    /**
     * Constructor con mensaje.
     * @param message Mensaje descriptivo del error.
     */
    public ListException(String message) {
        super(message);
    }
}
