package dijkstraPack;

import java.util.Comparator;

/**
 Comparator used in priority queue to prioritise vertex with the minimum distance to source
 */
public class VertexComparator implements Comparator<Vertex> {
    @Override
    public int compare(Vertex vertex, Vertex t1) {
        return Integer.compare(vertex.getDist(), t1.getDist());
    }
}
