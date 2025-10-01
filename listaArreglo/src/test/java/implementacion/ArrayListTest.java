/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementacion;

import implementacion.ArrayList;
import excepciones.ListException;
import interfaces.IList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ArrayListTest {

    private IList<String> lista;

    @BeforeEach
    void setUp() {
        lista = new ArrayList<>();
    }

    @Test
    void testAddAndSize() {
        lista.add("A");
        lista.add("B");
        assertEquals(2, lista.size());
    }

    @Test
    void testGet() throws ListException {
        lista.add("X");
        lista.add("Y");
        assertEquals("X", lista.get(0));
        assertEquals("Y", lista.get(1));
    }

    @Test
    void testGetInvalidIndex() {
        assertThrows(ListException.class, () -> lista.get(5));
    }

    @Test
    void testSet() throws ListException {
        lista.add("Uno");
        lista.set("Dos", 0);
        assertEquals("Dos", lista.get(0));
    }

    @Test
    void testSetInvalidIndex() {
        assertThrows(ListException.class, () -> lista.set("Error", 3));
    }

    @Test
    void testRemove() throws ListException {
        lista.add("A");
        lista.add("B");
        assertTrue(lista.remove("A"));
        assertEquals(1, lista.size());
        assertFalse(lista.remove("Z")); // no existe
    }

    @Test
    void testRemoveEmpty() {
        assertThrows(ListException.class, () -> lista.remove("Nada"));
    }

    @Test
    void testIndexOf() {
        lista.add("X");
        lista.add("Y");
        assertEquals(0, lista.indexOf("X"));
        assertEquals(1, lista.indexOf("Y"));
        assertEquals(-1, lista.indexOf("Z"));
    }

    @Test
    void testClearAndIsEmpty() {
        lista.add("A");
        lista.clear();
        assertTrue(lista.isEmpty());
        assertEquals(0, lista.size());
    }
}