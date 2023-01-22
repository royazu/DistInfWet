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
        //temporary function to chek that print graph is working
        private void updateAdjacencyList(){
            for (int i = 0; i < NumberOfNodes; i++) {
                for(int j = 0; j <NumberOfNodes; j++) {
                    if (i+1==id){
                        if (neighborIds.contains(j+1)){
                            for (Pair<Integer,Float> pair : EdgeWeight){
                                if(pair.getKey() == j+1){
                                    adjacencyList[i][j] = pair.getValue();
                                }
                            }
                        }else{
                            adjacencyList[i][j] = -1;
                        }
                    }else{
                        adjacencyList[i][j] = -1;
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
            // dont forget to delete this line in the end
            System.out.println("printing G " + id);
            for (int i = 0; i < NumberOfNodes; i++) {
                System.out.print(i+1 + " ");
                for(int j = 0; j < NumberOfNodes; j++) {
//                    System.out.print(adjacencyList[i][j]+" ");
                    if(adjacencyList[i][j] != -1){
                        System.out.print(j+1+" ");
                        System.out.print(adjacencyList[i][j]+" ");
                        // print ports dont delete
//                        for (Pair<Integer,List<Integer>> pair : PortUsage){
//                            if(pair.getKey() == j+1){
//                                System.out.print(pair.getValue().get(0)+" ");
//                                System.out.print(pair.getValue().get(1)+" ");
//                            }
//                        }

                    }
                }
                System.out.println("");
            }
        }
    }
