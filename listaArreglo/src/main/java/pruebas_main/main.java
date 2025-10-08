/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas_main;

import implementacion.ArrayList;
import implementaciones.LinkedList;
import implementaciones.DoubleLinkedList;
import interfaces.IList;
import excepciones.ListException;

/**
 * Clase principal para probar las implementaciones de listas:
 * ArrayList, LinkedList y DoubleLinkedList.
 * Se realizan pruebas basicas de insercion, eliminacion,
 * busqueda e indices con datos de tipo String e Integer.
 */
public class main {

    /**
     * Metodo principal del programa que ejecuta las pruebas
     * de las tres implementaciones de listas.
     * @param args argumentos de linea de comando (no utilizados)
     */
    public static void main(String[] args) {
        try {
            // ================= ARRAYLIST =================
            System.out.println("=== Prueba ArrayList ===");
            IList<String> arrayList = new ArrayList<>();
            arrayList.add("Uno");
            arrayList.add("Dos");
            arrayList.add("Tres");
            System.out.println("Tamano: " + arrayList.size());
            System.out.println("Elemento en posicion 1: " + arrayList.get(1));
            arrayList.set("Dos Modificado", 1);
            System.out.println("Elemento modificado: " + arrayList.get(1));
            System.out.println("Indice de 'Tres': " + arrayList.indexOf("Tres"));
            arrayList.remove("Uno");
            System.out.println("Despues de eliminar 'Uno': tamano = " + arrayList.size());
            arrayList.clear();
            System.out.println("Esta vacia: " + arrayList.isEmpty());

            // Prueba con enteros
            IList<Integer> arrayInt = new ArrayList<>();
            for (int i = 1; i <= 5; i++) arrayInt.add(i);
            System.out.println("ArrayList de enteros, tamano: " + arrayInt.size());
            System.out.println("Primer ocurrencia de 3: " + arrayInt.indexOf(3));

            // ================= LINKEDLIST =================
            System.out.println("\n=== Prueba LinkedList ===");
            IList<String> linkedList = new LinkedList<>();
            linkedList.add("A");
            linkedList.add("B");
            linkedList.add("C");
            System.out.println("Tamano: " + linkedList.size());
            System.out.println("Elemento en posicion 2: " + linkedList.get(2));
            linkedList.set("Cambiado", 2);
            System.out.println("Elemento modificado: " + linkedList.get(2));
            System.out.println("Indice de 'B': " + linkedList.indexOf("B"));
            linkedList.remove("A");
            System.out.println("Despues de eliminar 'A': tamano = " + linkedList.size());
            linkedList.clear();
            System.out.println("Esta vacia: " + linkedList.isEmpty());

            // Prueba con enteros
            IList<Integer> linkedInt = new LinkedList<>();
            for (int i = 10; i <= 50; i += 10) linkedInt.add(i);
            System.out.println("LinkedList de enteros, tamano: " + linkedInt.size());
            System.out.println("Primer ocurrencia de 30: " + linkedInt.indexOf(30));
            linkedInt.remove(20);
            System.out.println("Despues de eliminar 20, tamano: " + linkedInt.size());

            // ================= DOUBLE LINKED LIST =================
            System.out.println("\n=== Prueba DoubleLinkedList ===");
            IList<String> doubleLinkedList = new DoubleLinkedList<>();
            doubleLinkedList.add("X");
            doubleLinkedList.add("Y");
            doubleLinkedList.add("Z");
            System.out.println("Tamano: " + doubleLinkedList.size());
            System.out.println("Elemento en posicion 0: " + doubleLinkedList.get(0));
            doubleLinkedList.set("Modificado", 1);
            System.out.println("Elemento modificado en posicion 1: " + doubleLinkedList.get(1));
            System.out.println("Indice de 'Z': " + doubleLinkedList.indexOf("Z"));
            doubleLinkedList.remove("X");
            System.out.println("Despues de eliminar 'X': tamano = " + doubleLinkedList.size());
            doubleLinkedList.clear();
            System.out.println("Esta vacia: " + doubleLinkedList.isEmpty());

            // Prueba con enteros
            IList<Integer> doubleInt = new DoubleLinkedList<>();
            for (int i = 5; i <= 25; i += 5) doubleInt.add(i);
            System.out.println("DoubleLinkedList de enteros, tamano: " + doubleInt.size());
            System.out.println("Primer ocurrencia de 15: " + doubleInt.indexOf(15));
            doubleInt.remove(5);
            System.out.println("Despues de eliminar 5, tamano: " + doubleInt.size());

        } catch (ListException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
