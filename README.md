# WordLadder

This project finds the shortest path from one word to another, by modifying one letter at a time (changing into valid word at each step).

A corpus of five-letter words is converted into an adjacency matrix, upon which various traversal algorithms can be used.

## BFS WordLadder

This implementation uses Breadth-First-Search to find the shortest "ladder" from one word to another. The ladder's length is simply the number of words it takes to reach the final word.

### To run this code:

* Navitage to the **/wordladder** directory
* In a terminal, run **$ javac Main.java** to compile the Java code
* Then, run **$ java Main "../words5.txt"`<start> <end>`** to find the shortest word ladder between two desired words
    * **../words5.txt** is the location of the corpus to search
    * Both words must be 5 letters in length for this corpus

## Dijkstra's Algorithm Shortest Path

This implementation uses an optimised version of Dijkstra's algorithm to compute the shortest weighted path, in regards to distance between letters (e.g. a -> c = 2).


The data structures used for this implementation are:
* Buckets - For a more efficiently connected and traversable adjacency matrix
* Priority queue - Efficient vertex processing (requiring a custom Comparator class for Vertex edge weights)

### To run this code:

* Navitage to the **/dijkstra** directory
* In a terminal, run **$ javac Main.java** to compile the Java code
* Then, run **$ java Main "../words5.txt"`<start> <end>`** to find the shortest weighted path between two desired words.
    * **../words5.txt** is the location of the corpus to search
    * Both words must be 5 letters in length for this corpus


## Empirical Resutls

### BFS WordLadder

word1 = forty\
word2 = fifty\
Shortest word ladder length: 4\
Example of shortest word ladder:\
forty\
forth\
firth\
fifth\
fifty\
Elapsed time: 291 milliseconds

**And where no path is found:**\
word1 = greed\
word2 = money\
No word ladder exists.\
Elapsed time: 298 milliseconds

### Dijkstra's Shortest Path

Start Word: black\
End Word: white\
Min path length: 56\
black\
slack\
shack\
shank\
thank\
thane\
thine\
whine\
white\
Elapsed time: 220 milliseconds

