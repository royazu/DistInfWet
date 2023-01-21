import java.util.*;

public class Node extends Thread{
        private final int id;
//        private List<Node> ConnectedNodes;
        private List<Pair<Integer,Float>> EdgeWeight; //(key,value)=(neighbour_id,weight)
        private ArrayList<Pair<Integer,List<Integer>>> PortUsage ;//(key,value)=(neighbour_id,(send_port,listen_port))
        private List<Integer> neighborIds;
        private final int NumberOfNodes;
        private static float [][] adjacencyList;

        public Node(int id , int NumberOfNodes, List<Integer> neighborIds, List<Pair<Integer,Float>> EdgeWeight,
                    ArrayList<Pair<Integer,List<Integer>>> PortUsage) {
            super();
            this.id = id;
            this.NumberOfNodes = NumberOfNodes;
            this.neighborIds = neighborIds;
            this.EdgeWeight = EdgeWeight;
            this.PortUsage = PortUsage;
            this.adjacencyList = new float[NumberOfNodes][NumberOfNodes];
        }
        @Override
        public void run(){
            // TODO: implament link state routing algorithm
        }

        public long getId() {

            return id;
        }

        private void updateAdjacencyList(){
            for (int i = 0; i < NumberOfNodes; i++) {
                for(int j = 0; j <NumberOfNodes; j++) {
//                    adjacencyList[i][j] = 1;
                    if (i == j){
                        adjacencyList[i][j] = -1;
                    }
                    else{
                        if (neighborIds.contains(j) && id == i+1){
                        for (Pair<Integer, Float> pair : EdgeWeight) {
                            if (pair.getKey() == i) {
                                adjacencyList[i][j] = 55;
                            }else{
                                adjacencyList[i][j] = 6666;
                            }
                        }
                    } else {
                        adjacencyList[i][j] = -1;
                    }
                    }
                }
            }
        }

        public List<Integer> getNeighborIds() {

            return neighborIds;
        }
        // done maybe working
        public void print_graph(){
            updateAdjacencyList();
            System.out.println("printin G " + id);
//            System.out.println(adjacencyList[0][0]+" 88888");
            // outer loop
            for (int i = 0; i < NumberOfNodes; i++) {
                // codes
                System.out.print(i+1 + " ");
                // inner loop
                for(int j = 0; j < NumberOfNodes; j++) {
                    System.out.print(adjacencyList[i][j]+" ");
//                    if (adjacencyList[i][j] != -1 ){
//                        System.out.print(j+1+" ");
//                        System.out.print(adjacencyList[i][j]+" ");
//                        System.out.print(PortUsage.get(j).getValue().get(0)+" ");
//                        System.out.print(PortUsage.get(j).getValue().get(1)+" ");
//                    }
//
                }
                System.out.println("");
            }
        }
    }
