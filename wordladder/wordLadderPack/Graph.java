package wordLadderPack;

import java.util.LinkedList;

/**
 class to represent an undirected graph using adjacency lists
 */
public class Graph {

    private Vertex[] vertices; // the (array of) vertices
    private int numVertices = 0; // number of vertices

    /**
     creates a new instance of Graph with n vertices
     */
    public Graph(int n) {
        numVertices = n;
        vertices = new Vertex[n];
        for (int i = 0; i < n; i++)
            vertices[i] = new Vertex(i);
    }

    public int size() {
        return numVertices;
    }

    public Vertex getVertex(int i) {
        return vertices[i];
    }

    public void setVertex(int i) {
        vertices[i] = new Vertex(i);
    }

    /**
     carry out a breadth first search/traversal of the graph
     */
    public void bfs(int start, int end) {
        for (Vertex v : vertices) v.setVisited(false); // initialise (all vertices unvisted)
        LinkedList<Vertex> queue = new LinkedList<Vertex>(); // queue to process
        queue.add(vertices[start]);
        vertices[start].setVisited(true);
        while(!queue.isEmpty()){
            Vertex u = queue.remove();
            LinkedList<AdjListNode> list = u.getAdjList();

            for(AdjListNode node: list){

                if(node.getWeight() == 1){//is adjacent
                    Vertex w = vertices[node.getVertexIndex()];
                    if(!w.getVisited()){
                        w.setVisited(true);
                        w.setPredecessor((u.getIndex()));
                        if(node.getVertexIndex() != end){
                            queue.add(w);
                        }else{
                            return;
                        }

                    }
                }
            }

        }

    }

}
