package implementacion;

import excepciones.ListException;
import interfaces.IList;
import implementacion.ArrayList;
import implementaciones.DoubleLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para ArrayList y DoubleLinkedList
 * usando JUnit 5.
 */
class ArrayListTest {

    private IList<String> listaArray;
    private IList<String> listaDouble;

    @BeforeEach
    void setUp() {
        listaArray = new ArrayList<>();
        listaDouble = new DoubleLinkedList<>();
    }

    // ----------- MÉTODOS AUXILIARES -----------
    private void probarAddAndSize(IList<String> lista) {
        lista.add("A");
        lista.add("B");
        assertEquals(2, lista.size());
    }

    private void probarGet(IList<String> lista) throws ListException {
        lista.add("X");
        lista.add("Y");
        assertEquals("X", lista.get(0));
        assertEquals("Y", lista.get(1));
    }

    private void probarSet(IList<String> lista) throws ListException {
        lista.add("Uno");
        lista.set("Dos", 0);
        assertEquals("Dos", lista.get(0));
    }

    private void probarRemove(IList<String> lista) throws ListException {
        lista.add("A");
        lista.add("B");
        assertTrue(lista.remove("A"));
        assertEquals(1, lista.size());
        assertFalse(lista.remove("Z"));
    }

    private void probarIndexOf(IList<String> lista) {
        lista.add("X");
        lista.add("Y");
        assertEquals(0, lista.indexOf("X"));
        assertEquals(1, lista.indexOf("Y"));
        assertEquals(-1, lista.indexOf("Z"));
    }

    private void probarClearAndIsEmpty(IList<String> lista) {
        lista.add("A");
        lista.clear();
        assertTrue(lista.isEmpty());
        assertEquals(0, lista.size());
    }

    // ----------- PRUEBAS PARA ARRAYLIST -----------
    @Test
    void testArrayListAddAndSize() {
        probarAddAndSize(listaArray);
    }

    @Test
    void testArrayListGet() throws ListException {
        probarGet(listaArray);
    }

    @Test
    void testArrayListSet() throws ListException {
        probarSet(listaArray);
    }

    @Test
    void testArrayListRemove() throws ListException {
        probarRemove(listaArray);
    }

    @Test
    void testArrayListIndexOf() {
        probarIndexOf(listaArray);
    }

    @Test
    void testArrayListClearAndIsEmpty() {
        probarClearAndIsEmpty(listaArray);
    }

    @Test
    void testArrayListInvalidCases() {
        assertThrows(ListException.class, () -> listaArray.get(5));
        assertThrows(ListException.class, () -> listaArray.set("Error", 3));
        assertThrows(ListException.class, () -> listaArray.remove("Nada"));
    }

    // ----------- PRUEBAS PARA DOUBLELINKEDLIST -----------
    @Test
    void testDoubleLinkedListAddAndSize() {
        probarAddAndSize(listaDouble);
    }

    @Test
    void testDoubleLinkedListGet() throws ListException {
        probarGet(listaDouble);
    }

    @Test
    void testDoubleLinkedListSet() throws ListException {
        probarSet(listaDouble);
    }

    @Test
    void testDoubleLinkedListRemove() throws ListException {
        probarRemove(listaDouble);
    }

    @Test
    void testDoubleLinkedListIndexOf() {
        probarIndexOf(listaDouble);
    }

    @Test
    void testDoubleLinkedListClearAndIsEmpty() {
        probarClearAndIsEmpty(listaDouble);
    }

    @Test
    void testDoubleLinkedListInvalidCases() {
        assertThrows(ListException.class, () -> listaDouble.get(5));
        assertThrows(ListException.class, () -> listaDouble.set("Error", 3));
        assertThrows(ListException.class, () -> listaDouble.remove("Nada"));
    }
}
