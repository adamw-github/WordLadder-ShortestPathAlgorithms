package wordLadderPack;
/**
 class to represent an entry in the adjacency list of a vertex
 in a graph
 */
public class AdjListNode {

    private int vertexIndex;
    private int weight;

    public AdjListNode(int n){
        vertexIndex = n;
    }
    public AdjListNode(int n, int weight){
        vertexIndex = n;
        this.weight = weight;
    }

    public int getVertexIndex(){
        return vertexIndex;
    }

    public void setVertexIndex(int n){
        vertexIndex = n;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
