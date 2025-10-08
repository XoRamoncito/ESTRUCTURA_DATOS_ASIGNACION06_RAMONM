package implementacion;

import implementacion.ArrayList;
import excepciones.ListException;
import interfaces.IList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas unitarias para verificar el funcionamiento
 * de la clase ArrayList que implementa la interfaz IList.
 * Se realizan pruebas con datos de tipo String e Integer
 * para validar los metodos principales de la lista.
 */
class ArrayListTest {

    private IList<String> listaString;
    private IList<Integer> listaEnteros;

    /**
     * Inicializa las listas antes de cada prueba.
     */
    @BeforeEach
    void setUp() {
        listaString = new ArrayList<>();
        listaEnteros = new ArrayList<>();
    }

    /**
     * Verifica que los elementos se agregan correctamente y
     * que el tamaño se actualiza de forma esperada.
     */
    @Test
    void testAddAndSize() {
        listaString.add("A");
        listaString.add("B");
        assertEquals(2, listaString.size());
    }

    /**
     * Comprueba que el metodo get obtiene los valores correctos
     * segun el indice indicado.
     * @throws ListException si el indice es invalido
     */
    @Test
    void testGet() throws ListException {
        listaString.add("X");
        listaString.add("Y");
        assertEquals("X", listaString.get(0));
        assertEquals("Y", listaString.get(1));
    }

    /**
     * Prueba que get lanza una excepcion si el indice no existe.
     */
    @Test
    void testGetInvalidIndex() {
        assertThrows(ListException.class, () -> listaString.get(5));
    }

    /**
     * Verifica que el metodo set reemplaza un valor correctamente.
     * @throws ListException si el indice es invalido
     */
    @Test
    void testSet() throws ListException {
        listaString.add("Uno");
        listaString.set("Dos", 0);
        assertEquals("Dos", listaString.get(0));
    }

    /**
     * Prueba que set lanza excepcion si el indice es invalido.
     */
    @Test
    void testSetInvalidIndex() {
        assertThrows(ListException.class, () -> listaString.set("Error", 3));
    }

    /**
     * Comprueba que remove elimina correctamente un elemento existente
     * y retorna true, o false si el elemento no existe.
     * @throws ListException si la lista esta vacia
     */
    @Test
    void testRemove() throws ListException {
        listaString.add("A");
        listaString.add("B");
        assertTrue(listaString.remove("A"));
        assertEquals(1, listaString.size());
        assertFalse(listaString.remove("Z"));
    }

    /**
     * Verifica que remove lanza excepcion si se intenta eliminar
     * de una lista vacia.
     */
    @Test
    void testRemoveEmpty() {
        assertThrows(ListException.class, () -> listaString.remove("Nada"));
    }

    /**
     * Prueba el metodo indexOf con elementos que existen y que no existen.
     */
    @Test
    void testIndexOf() {
        listaString.add("X");
        listaString.add("Y");
        listaString.add("Z");
        assertEquals(0, listaString.indexOf("X"));
        assertEquals(1, listaString.indexOf("Y"));
        assertEquals(2, listaString.indexOf("Z"));
        assertEquals(-1, listaString.indexOf("NoExiste"));
    }

    /**
     * Prueba el metodo clear y verifica que la lista quede vacia.
     */
    @Test
    void testClearAndIsEmpty() {
        listaString.add("A");
        listaString.add("B");
        listaString.clear();
        assertTrue(listaString.isEmpty());
        assertEquals(0, listaString.size());
    }

    /**
     * Crea una lista de enteros de tamano 5 y valida su contenido.
     * @throws ListException si algun acceso es invalido
     */
    @Test
    void testAddFiveIntegers() throws ListException {
        for (int i = 1; i <= 5; i++) {
            listaEnteros.add(i);
        }
        assertEquals(5, listaEnteros.size());
        assertEquals(3, listaEnteros.get(2)); // tercer elemento
    }

    /**
     * Busca la primera ocurrencia de un elemento en una lista de enteros.
     */
    @Test
    void testFirstOccurrenceInteger() {
        listaEnteros.add(10);
        listaEnteros.add(20);
        listaEnteros.add(10);
        assertEquals(0, listaEnteros.indexOf(10)); // primera ocurrencia
    }

    /**
     * Busca la primera ocurrencia de una cadena en la lista.
     */
    @Test
    void testFirstOccurrenceString() {
        listaString.add("Hola");
        listaString.add("Mundo");
        listaString.add("Hola");
        assertEquals(0, listaString.indexOf("Hola"));
    }

    /**
     * Elimina la primera ocurrencia de una cadena repetida
     * y verifica que las demas permanezcan.
     * @throws ListException si ocurre un error en la eliminacion
     */
    @Test
    void testRemoveFirstOccurrenceString() throws ListException {
        listaString.add("Perro");
        listaString.add("Gato");
        listaString.add("Perro");
        boolean eliminado = listaString.remove("Perro");
        assertTrue(eliminado);
        assertEquals(2, listaString.size());
        assertEquals(1, listaString.indexOf("Perro")); // ahora esta en la posicion 1
    }

    /**
     * Verifica que remove no falle al intentar eliminar
     * un elemento inexistente en una lista con datos.
     * @throws ListException si ocurre error inesperado
     */
    @Test
    void testRemoveNonExistentElement() throws ListException {
        listaString.add("A");
        listaString.add("B");
        assertFalse(listaString.remove("C"));
    }
}
