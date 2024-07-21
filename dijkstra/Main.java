import dijkstraPack.*;

import java.io.*;
import java.util.*;

public class Main{

	 //If words are adjacent, returns the absolute difference between the non-matching letters
	 //If not adjacent, returns 0
	public static int isAdjacent(String word1, String word2){
		char[] word1ch = word1.toCharArray();
		char[] word2ch = word2.toCharArray();
		int diff_count = 0;
		int diff_index = 0;
		for(int i=0; i < word1ch.length; i++){
			if(word1ch[i]!=word2ch[i]){
				diff_count++;
				diff_index = i;
			}
		}
		if(diff_count ==1){
			return Math.abs(word1ch[diff_index]-word2ch[diff_index]);
		}else{
			return 0;
		}
	}

	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();

		String inputFileName = args[0]; // dictionary
		String word1 = args[1]; // first word
		String word2 = args[2]; // second word
		List<String> dictionary = new ArrayList<>();
		List<Vertex> buckets = new ArrayList<>();

		FileReader reader = new FileReader(inputFileName);
		Scanner in = new Scanner(reader);

		// read in the data here
		int count = 0;
		int word1_i = 0;
		int word2_i = 0;
		while(in.hasNextLine()){
			String newLine = in.nextLine();
			if(newLine.equals(word1)) word1_i=count;
			if(newLine.equals(word2)) word2_i=count;
			dictionary.add(newLine);
			buckets.add(new Vertex(count++));
		}
		// create graph here
		reader.close();

		int adjacent;
		for(int i = 0; i <count; i++) {
			for(int j=0; j <count; j++){
				adjacent = isAdjacent(dictionary.get(i), dictionary.get(j));
				if(adjacent != 0){
					buckets.get(i).addToAdjList(j, adjacent);
				}
			}
		}

		// do the work here
		Graph adjMatrix = new Graph(count);
		adjMatrix.dijkstra(buckets, word1_i);

		// printing results:
		System.out.print("Start Word: ");
		System.out.println(dictionary.get(word1_i));
		System.out.print("End Word: ");
		System.out.println(dictionary.get(word2_i));

		if(adjMatrix.getVertex(word2_i).getPredecessor() != 123456789){
			System.out.print("Min path length: ");
			System.out.println(adjMatrix.getVertices()[word2_i].getDist());
			LinkedList<String> printer = new LinkedList<>();
			while(word2_i != word1_i){
				printer.add(dictionary.get(word2_i));
				word2_i = adjMatrix.getVertices()[word2_i].getPredecessor();
			}
			printer.add(dictionary.get(word1_i));



			while(printer.size()!=0){
				System.out.println(printer.removeLast());
			}
		} else{
			System.out.println("No word ladder exists.");

		}
		// end timer and print total time
		long end = System.currentTimeMillis();
		System.out.println("\nElapsed time: " + (end - start) + " milliseconds");
	}

}
