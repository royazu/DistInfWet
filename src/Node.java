import java.util.*;

public class Node extends Thread{
        private final int id;
        private List<Node> ConnectedNodes;
        private List<Integer> EdgeWeight;
        private List<Pair> PortUsage;
        private List<Integer> neighborIds;
        private final int NumberOfNodes;

        public Node(int id , int NumberOfNodes) {
            super();
            this.id = id;
            this.NumberOfNodes = NumberOfNodes;
            ConnectedNodes = new ArrayList<>();

        }
        @Override
        public void run(){
            // TODO: implament link state routing algorithm
        }

        public long getId() {
            return id;
        }

        public Node getNode() {return }

        public List<Integer> getNeighborIds() {
            return neighborIds;
        }
        // test
    }
