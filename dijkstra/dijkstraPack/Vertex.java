package dijkstraPack;

import java.util.LinkedList;

public class Vertex{

    private LinkedList<AdjListNode> adjList ; // the adjacency list
    private int index; // the index of this vertex in the graph

    private int dist; //distance to starting node in dijkstra
    boolean visited; // whether vertex has been visited in a traversal
    int predecessor; // index of predecessor vertex in a traversal


    /**
     creates a new instance of Vertex
     */
    public Vertex(int n){
        adjList = new LinkedList<AdjListNode>();
        index = n;
        visited = false;
        predecessor = 123456789;
    }


    public LinkedList<AdjListNode> getAdjList(){
        return adjList;
    }
    public int getDist() {
        return dist;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }
    public int getIndex(){
        return index;
    }


    public void setVisited(boolean b){
        visited = b;
    }

    public int getPredecessor(){
        return predecessor;
    }

    public void setPredecessor(int n){
        predecessor = n;
    }

    public void addToAdjList(int n, int weight){
        adjList.addLast((new AdjListNode(n, weight)));
    }

}
