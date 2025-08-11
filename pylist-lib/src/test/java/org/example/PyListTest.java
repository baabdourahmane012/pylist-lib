package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class PyListTest {

    private PyList<String> myList;
    private PyList<Object> list;
    private Profil p;

    // Cette méthode s'exécute avant chaque test. Elle garantit
    // que chaque test part d'une liste propre et vide.
    @BeforeEach
    void setUp() {
        myList = new PyList<>();
        list = new PyList<>();
        p = new Profil("Abdourahmane", "email@gmail.com");
    }

    @Test
    void testAppendAndLen() {
        // Teste si l'ajout d'éléments fonctionne et si la taille est correcte
        myList.append("element1");
        myList.append("element2");
        assertEquals(2, myList.len());
    }

    @Test
    void testGet() {
        // Teste la récupération d'un élément par son index
        myList.append("premier");
        myList.append("deuxieme");
        assertEquals("premier", myList.get(0));
        assertEquals("deuxieme", myList.get(1));
    }

    @Test
    void testGetIndexOutOfBounds() {
        // Teste si une exception est levée pour un index invalide
        myList.append("un_element");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            myList.get(1);
        });
    }

    @Test
    void testFilter() {
        // Teste la méthode de filtre avec un prédicat
        myList.append("apple");
        myList.append("banana");
        myList.append("apricot");

        PyList<String> filteredList = myList.filter(s -> s.startsWith("a"));

        assertEquals(2, filteredList.len());
        assertTrue(filteredList.get(0).equals("apple"));
        assertTrue(filteredList.get(1).equals("apricot"));
    }

    @Test
    void testPop() {
        // Teste si la méthode pop retourne le dernier élément et le retire
        myList.append("a");
        myList.append("b");
        assertEquals("b", myList.pop());
        assertEquals(1, myList.len());
    }

    @Test
    void testPopFromEmptyList() {
        // Teste si une exception est levée lorsque l'on pop une liste vide
        assertThrows(NoSuchElementException.class, () -> {
            myList.pop();
        });
    }

    @Test
    void testTypeOf(){
        list.append(10);
        list.append(true);
        list.append("Hello");

        assertEquals("Integer", list.typeOf(0));
        assertEquals("Boolean", list.typeOf(1));
        assertEquals("String", list.typeOf(2));

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.typeOf(3);
        });
    }

    @Test
    void testGetAndCallReelObject(){
        list.append(p);
        list.append(new Profil("Cherif", "email@gmail.com"));

        assertTrue(list.get(0).toString().contains("Profil"));
        assertTrue(list.get(1).toString().contains("Profil"));

        Profil pro = (Profil) list.get(1);
        assertEquals("Cherif", pro.getName());

    }

    @Test
    void testSetElement(){
        list.append("A");
        list.append("B");
        list.set(1, "A");

        assertEquals("A", list.get(1));
    }

    @Test
    void testInsertElementAndLenAfterInserted(){
        list.append("Hello");
        list.append("!");
        list.insert(1, "World");
        list.insert(3, new Profil("10Mo", "mail@gmail.com"));

        assertEquals("World", list.get(1));
        assertEquals(4, list.len());
    }

    @Test
    void testSlice(){
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);

        PyList<Object> slice = list.slice(1, 3);
        assertEquals(2, slice.get(0));
        assertEquals(3, slice.get(1));
    }
}