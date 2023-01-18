import java.util.*;

public class Node extends Thread{
        private final int id;
        private List<Node> ConnectedNodes;
        private List<Pair<Integer,Float>> EdgeWeight;
        private ArrayList<Pair<Integer,List<Integer>>> PortUsage ;//(key,value)=(neighbour_id,(send_port,listen_port))
        private List<Integer> neighborIds;
        private final int NumberOfNodes;
        private static float [][]  adjencyList;

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
        // done maybe working
        public void print_graph(){
            // outer loop
            for (int i = 1; i <= NumberOfNodes; ++i) {
                // codes
                System.out.print(i);
                // inner loop
                for(int j = 1; j <=NumberOfNodes; ++j) {
                    if (adjencyList[i][j] != -1 ){
                        System.out.print(j);
                        System.out.print(adjencyList[i][j]);
                        System.out.print(PortUsage.get(j).getValue().get(0));
                        System.out.print(PortUsage.get(j).getValue().get(1));
                    }
                    System.out.println("");
                }
            }
        }
    }
