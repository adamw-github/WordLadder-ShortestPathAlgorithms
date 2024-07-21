package dijkstraPack;

public class AdjListNode {

    private int vertexIndex;
    private int weight;
    // could be other fields, for example representing
    // properties of the edge - weight, capacity, . . .

    /* creates a new instance */
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


    public int getWeight() {
        return weight;
    }

}
