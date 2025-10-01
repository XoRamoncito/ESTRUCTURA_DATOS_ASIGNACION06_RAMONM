/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas_main;



import implementacion.ArrayList;
import implementaciones.LinkedList;
import interfaces.IList;
import excepciones.ListException;

public class main {
    public static void main(String[] args) {
        try {
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
            System.out.println("Esta vacia? " + arrayList.isEmpty());

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
            System.out.println("Esta vacia? " + linkedList.isEmpty());

        } catch (ListException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}