import java.util.*;

public class Node extends Thread{
        private int id;
        private List<Node> ConnectedNodes;
        private List<Integer> VertexWeight;
        private List<Pair> PortUsage;
        private final List<Integer> neighborIds;

        public Node(int id, List<Integer> neighborIds) {
            this.id = id;
            this.neighborIds = neighborIds;
        }

        public long getId() {
            return id;
        }

        public List<Integer> getNeighborIds() {
            return neighborIds;
        }

    }
