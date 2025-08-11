# PyList - Une librairie pour des listes à la Python en Java

![Java Logo](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Maven Central](https://img.shields.io/maven-central/v/org.example/pylist-lib?style=for-the-badge)

Une librairie légère et facile à utiliser qui apporte les fonctionnalités des listes de Python à Java. `PyList` offre une API expressive pour la manipulation de collections, rendant le code plus concis et lisible.

---

## Fonctionnalités

-   ### **Fonctionnalités 🚀**

- **`append(element)`** : Ajoute un élément à la fin de la liste.
- **`get(index)`** : Récupère un élément par son index. Lève une `IndexOutOfBoundsException` si l'index est hors de la plage.
- **`len()`** : Retourne la taille de la liste.
- **`slice(from, to)`** : Extrait une sous-liste de manière intuitive. Lève une `IndexOutOfBoundsException` si l'index est hors de la plage.
- **`filter(predicate)`** : Filtre les éléments de la liste avec un prédicat.
- **`pop()`** : Retire et retourne le dernier élément. Lève une `NoSuchElementException` si la liste est vide.
- **`sort()`** : Trie la liste selon l'ordre naturel des éléments.
- **`sort(comparator)`** : Trie la liste selon un comparateur spécifié.
- **`reversed()`** : Retourne une nouvelle liste dont les éléments sont dans l'ordre inverse.
- **`insert(index, element)`** : Insère un nouvel élément à la position spécifiée, décalant les éléments suivants. Lève une `IndexOutOfBoundsException` si l'index est hors de la plage.
- **`set(index, element)`** : Remplace l'élément à la position spécifiée. Lève une `IndexOutOfBoundsException` si l'index est hors de la plage.
---

## Installation

### Avec Maven

Ajoutez la dépendance suivante à votre fichier `pom.xml` :

```xml
<dependency>
    <groupId>org.example</groupId>
    <artifactId>pylist-lib</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

---

## Exemples d'utilisation :
### Manipulation de base

```java
import org.example.PyList;

public class Main {
    public static void main(String[] args) {
        PyList<String> noms = new PyList<>();
        noms.append("Alice");
        noms.append("Bob");
        noms.append("Charlie");

        System.out.println("Taille de la liste: " + noms.len()); // Affiche: Taille de la liste: 3
        System.out.println("Premier nom: " + noms.get(0)); // Affiche: Premier nom: Alice

        String dernierNom = noms.pop();
        System.out.println("Nom retiré: " + dernierNom); // Affiche: Nom retiré: Charlie
        System.out.println("Nouvelle taille: " + noms.len()); // Affiche: Nouvelle taille: 2
    }
}
```

### Filtrage et sous-liste

```java
import org.example.PyList;

public class Main {
public static void main(String[] args) {
    PyList<Integer> nombres = new PyList<>();
    nombres.append(1);
    nombres.append(2);
    nombres.append(3);
    nombres.append(4);
    nombres.append(5);

        // Filtrer les nombres pairs
        PyList<Integer> pairs = nombres.filter(n -> n % 2 == 0);
        System.out.println("Nombres pairs: " + pairs); // Affiche: [2, 4]

        // Créer une sous-liste
        PyList<Integer> sousListe = nombres.slice(1, 4);
        System.out.println("Sous-liste: " + sousListe); // Affiche: [2, 3, 4]
    }
}
```