import java.util.*;

public class Node extends Thread{
        private final int id;
        private List<Node> ConnectedNodes;
        private List<Integer> EdgeWeight;
        private List<Pair> PortUsage;
        private final List<Integer> neighborIds;
        private final int NumberOfNodes;
        public Node(int id, List<Integer> neighborIds) {
            this.id = id;
            this.neighborIds = neighborIds;
        }
        public Node(int id , int numberOfNodes) {
            super();
            this.id = id;
            this.NumberOfNodes = numberOfNodes;
            ConnectedNodes = new ArrayList<>();

        }

        public long getId() {
            return id;
        }

        public List<Integer> getNeighborIds() {
            return neighborIds;
        }

    }
