# PyList - Une librairie pour des listes à la Python en Java

![Java Logo](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Maven Central](https://img.shields.io/maven-central/v/org.example/pylist-lib?style=for-the-badge)

Une librairie légère et facile à utiliser qui apporte les fonctionnalités des listes de Python à Java. `PyList` offre une API expressive pour la manipulation de collections, rendant le code plus concis et lisible.

---

## Fonctionnalités

-   **`append()`**: Ajoute un élément à la fin de la liste.
-   **`get()`**: Récupère un élément par son index.
-   **`len()`**: Retourne la taille de la liste.
-   **`slice()`**: Extrait une sous-liste de manière intuitive.
-   **`filter()`**: Filtre les éléments de la liste avec un prédicat.
-   **`pop()`**: Retire et retourne le dernier élément.
-   **`sort()`**: Trie la liste selon l'ordre naturel ou un comparateur.
-   **`reversed()`**: Retourne une nouvelle liste dans l'ordre inverse.

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