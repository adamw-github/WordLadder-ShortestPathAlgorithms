package dijkstraPack;

import java.util.List;
import java.util.PriorityQueue;

public class Graph {

    private Vertex[] vertices; // the (array of) vertices
    private int numVertices; // number of vertices

    PriorityQueue<Vertex> queue;
    public Graph(int n) {
        numVertices = n;
        vertices = new Vertex[n];
        queue = new PriorityQueue<>(n, new VertexComparator());
        for (int i = 0; i < n; i++)
            vertices[i] = new Vertex(i);
    }

    public Vertex[] getVertices() {
        return vertices;
    }

    public int size() {
        return numVertices;
    }

    public Vertex getVertex(int i) {
        return vertices[i];
    }


    public void dijkstra(List<Vertex> buckets,int start){
        vertices[start].setDist(0);
        for(int i=0; i < numVertices; i++) {
            if (i != start) {
                vertices[i].setDist(Integer.MAX_VALUE);
            }
        }
        queue.add(vertices[start]);
        while(queue.size() != 0){
            Vertex u = queue.remove(); //created comparator to always remove vertex with min dist
            u.setVisited(true);

            for(AdjListNode node: buckets.get(u.getIndex()).getAdjList()){
                Vertex v = vertices[node.getVertexIndex()];
                if(v.visited) continue;
                v.setVisited(true);
                int alt = u.getDist() + node.getWeight();
                //System.out.println(alt);
                if(alt < v.getDist()){
                    v.setDist(alt);
                    v.setPredecessor(u.getIndex());
                }
                queue.add(v);
            }
        }

    }
}
