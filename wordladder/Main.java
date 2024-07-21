import java.io.*;
import java.util.*;
import wordLadderPack.*;
/**
 program to find word ladder with shortest path (i.e. minimum number edges
 */
public class Main {

    public static int isAdjacent(String word1, String word2){ //returns 1 if words are adjacent, 0 if not
        char[] word1ch = word1.toCharArray();
        char[] word2ch = word2.toCharArray();
        int diff_count = 0;
        for(int i=0; i < word1ch.length; i++){
            if(word1ch[i]!=word2ch[i]){
                diff_count++;
            }
        }
        if(diff_count == 1){
            return 1;
        } else{
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {

        long start = System.currentTimeMillis();

        String inputFileName = args[0]; // dictionary
        String word1 = args[1]; // first word
        String word2 = args[2]; // second word
        List<String> dictionary = new ArrayList<>();

        FileReader reader = new FileReader(inputFileName);
        Scanner in = new Scanner(reader);

        // read in the data here
        while(in.hasNextLine()){
            dictionary.add(in.nextLine());
        }
        // create graph here
        reader.close();

        int adjacent;
        Graph adj_matrix = new Graph(dictionary.size());
        for(int i=0; i<dictionary.size();i++) {

            int j;
            for (j = 0; j < dictionary.size(); j++) {
                adjacent = isAdjacent(dictionary.get(i), dictionary.get(j));
                adj_matrix.getVertex(i).addToAdjList(j, adjacent);
            }
        }

        // do the work here
        int word1_i = dictionary.indexOf(word1);
        int word2_i = dictionary.indexOf(word2);

        adj_matrix.bfs(word1_i, word2_i);

        //printing results
        System.out.println("word1 = " + word1 + "\nword2 = " + word2);
        LinkedList<Vertex> path = new LinkedList<>();
        if(adj_matrix.getVertex(word2_i).getPredecessor() != 123456789){
            do { //while current vertex is NOT starting word, add path of predecessors
                path.add(adj_matrix.getVertex(word2_i));
                word2_i = adj_matrix.getVertex(word2_i).getPredecessor();
            } while (adj_matrix.getVertex(word2_i).getPredecessor() != 123456789);
            path.add(adj_matrix.getVertex(word1_i));



            System.out.print("Shortest word ladder length: ");
            System.out.println(path.size()-1);
            System.out.println("Example of shortest word ladder:");
            while (path.size() > 1) {
                System.out.println(dictionary.get(path.removeLast().getIndex()));
            }
            System.out.println(dictionary.get(path.pop().getIndex()));
        } else{
            System.out.println("No word ladder exists.");
        }
        // end timer and print total time
        long end = System.currentTimeMillis();
        System.out.println("\nElapsed time: " + (end - start) + " milliseconds");
    }

}
