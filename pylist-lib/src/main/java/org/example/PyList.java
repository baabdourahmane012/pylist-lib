package org.example;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Une liste générique et dynamique inspirée de la classe {@code list} de Python.
 * <p>
 * Cette classe offre une collection d'éléments de type {@code T} avec des méthodes
 * pratiques pour la manipulation et l'interrogation de la liste. Elle peut être
 * utilisée pour stocker des types homogènes (par exemple, {@code PyList<Integer>})
 * ou des types hétérogènes en utilisant {@code PyList<Object>}.
 * <p>
 * Si des éléments de type {@code Object} sont stockés, un cast est nécessaire
 * pour accéder à leurs méthodes et attributs spécifiques lors de la récupération.
 *
 * @param <T> le type d'éléments que la liste contiendra.
 *
 * @see java.util.List
 * @see java.util.ArrayList
 * @author Abdourahmane BA
 * @version 1.0.0
 */
public class PyList<T> implements Iterable<T>
{
    private List<T> data;

    /**
     * Crée une nouvelle instance de {@code PyList} vide.
     * Les éléments de cette liste seront initialisés avec le type générique T.
     */
    public PyList(){
        this.data = new ArrayList<>();
    }

    /**
     * Retourne l'indice de la première occurrence de l'élément spécifié dans cette liste.
     *
     * @param object L'élément dont l'indice doit être retourné.
     * @return L'indice de la première occurrence de l'élément, ou -1 si l'élément n'est pas dans la liste.
     */
    public int index(T object){
        return data.indexOf(object);
    }

    /**
     * Ajoute l'élément spécifié à la fin de cette liste.
     *
     * @param object L'élément à ajouter à la liste.
     *
     */
    public void append(T object){
        data.add(object);
    }

    /**
     * Retourne l'élément à la position spécifiée dans cette liste.
     *
     * @param index L'indice de l'élément à retourner.
     * @return L'élément à l'indice spécifié.
     * @throws IndexOutOfBoundsException si l'indice est hors de la plage ({@code index < 0 || index >= len()}).
     */
    public T get(int index){
        // La méthode data.get(index) gère déjà la levée de l'exception pour vous.
        return data.get(index);
    }

    /**
     * Modifie un élément à la position spécifiée dans cette liste.
     *
     * @param index L'indice de l'élément à modifier.
     * @param val L'élément à ajouter.
     */
    public void set(int index, T val){
        PyList<T> newList = new PyList<>();
        for(int i=0; i<this.len(); i++){
            if (i != index){
                newList.append(this.get(i));
            } else {
                newList.append(val);
            }
        }
        this.data = newList.data;
    }

    /**
     * Insére un élément à la position spécifiée dans cette liste.
     *
     * @param index L'indice à laquel insérer l'élément.
     * @param val L'élément à insérer.
     */
    public void insert(int index, T val){
        PyList<T> newList = new PyList<>();
        for (int i = 0; i <= this.len(); i++) {
            if (i<index){
               newList.append(this.get(i));
            } else {
                newList.append(val);
            }
        }
        this.data = newList.data;
    }

    /**
     * Retourne le nombre d'éléments dans cette liste.
     *
     * @return Le nombre d'éléments dans la liste.
     */
    public int len(){
        return data.size();
    }

    /**
     * Retourne le nom simple de la classe de l'objet fourni par son indice.
     * Cette méthode est particulièrement utile pour les listes de type {@code PyList<Object>}.
     *
     * @param index L'indice de l'élément dont le nom de type doit être retourné.
     * @return Le nom simple de la classe de l'objet, sous forme de chaîne de caractères.
     * @throws IndexOutOfBoundsException si l'indice est hors de la plage ({@code index < 0 || index >= len()}).
     */
    public String typeOf(int index){
        // Il est important de faire le contrôle avant d'accéder à l'élément.
        if (index < 0 || index >= data.size()) {
            throw new IndexOutOfBoundsException("index out of bounds");
        }
        return data.get(index).getClass().getSimpleName();
    }

    /**
     * Retourne un itérateur sur les éléments de cette liste.
     * Cette méthode permet à la liste d'être utilisée dans une boucle for-each.
     *
     * @return Un itérateur sur les éléments de type T.
     */
    @Override
    public Iterator<T> iterator(){
        return data.iterator();
    }

    /**
     * Retourne une nouvelle {@code PyList} contenant une sous-liste des éléments
     * de la position {@code from}, inclusive, à {@code to}, exclusive.
     *
     * @param from L'indice de départ, inclusif.
     * @param to L'indice de fin, exclusif.
     * @return Une nouvelle {@code PyList} contenant la sous-liste.
     * @throws IndexOutOfBoundsException si {@code from} ou {@code to} sont hors de la plage.
     */
    public PyList<T> slice(int from, int to){
        // Ajout d'une vérification pour garantir que les indices sont valides
        if (from < 0 || to > data.size() || from > to) {
            throw new IndexOutOfBoundsException("Invalid 'from' or 'to' indices.");
        }
        PyList<T> seq = new PyList<>();
        for(int i=from; i<to; i++){
            seq.append(data.get(i));
        }
        return seq;
    }

    /**
     * Filtre les éléments de la liste en se basant sur une condition et retourne
     * une nouvelle liste contenant uniquement les éléments qui satisfont cette condition.
     *
     * @param condition Le prédicat (la condition) à appliquer sur chaque élément.
     * @return Une nouvelle {@code PyList} contenant les éléments filtrés.
     */
    public PyList<T> filter(Predicate<T> condition){
        PyList<T> seqIter = new PyList<>();
        for (T element : this){
            if (condition.test(element)){
                seqIter.append(element);
            }
        }
        return seqIter;
    }

    /**
     * Retourne un flux (Stream) séquentiel avec les éléments de cette liste.
     *
     * @return Un {@code Stream<T>} séquentiel.
     */
    public Stream<T> toStream(){
        // Simplification du code en utilisant directement le stream de la liste interne.
        return data.stream();
    }

    /**
     * Retire et retourne le dernier élément de la liste.
     *
     * @return Le dernier élément de la liste.
     * @throws NoSuchElementException si la liste est vide.
     */
    public T pop() {
        if (data.isEmpty()) {
            throw new NoSuchElementException("Cannot pop from an empty list.");
        }
        return data.remove(data.size() - 1);
    }

    /**
     * Trie les éléments de cette liste selon le comparateur spécifié.
     *
     * @param comparator L'objet comparateur qui définit l'ordre de tri.
     */
    public void sort(Comparator<? super T> comparator) {
        this.data.sort(comparator);
    }

    /**
     * Crée et retourne une nouvelle liste contenant les éléments de cette liste
     * dans l'ordre inverse.
     * <p>
     * La liste originale n'est pas modifiée.
     *
     * @return Une nouvelle PyList contenant les éléments inversés.
     */
    public PyList<T> reversed() {
        PyList<T> reversedList = new PyList<>();
        for (int i = this.data.size() - 1; i >= 0; i--) {
            reversedList.append(this.data.get(i));
        }
        return reversedList;
    }

}