import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class ExManager {
    private String path;
    private int num_of_nodes;
    private List<Pair<Integer,Node>> nodes;
    // your code here

    public ExManager(String path){
        this.path = path;
        this.nodes = new ArrayList<>();
        // your code here
    }
    public Node get_node(int id){
        // your code here
        for (Pair<Integer, Node> pair : nodes) {
            if (pair.getKey() == id) {
                return pair.getValue();
            }
        }
        return null;
    }

    public int getNum_of_nodes() {
        return this.num_of_nodes;
    }

    public void update_edge(int id1, int id2, double weight){
        //your code here
    }

    public void read_txt() throws FileNotFoundException{
        // your code here
        System.out.println(this.path);
        Scanner scanner = new Scanner(new File(this.path));
        String line = scanner.nextLine();
        num_of_nodes = Integer.parseInt(line);
        System.out.println(num_of_nodes+"this is the number of nodes");
        while(scanner.hasNextLine()) {
            line = scanner.nextLine();
            if(line.contains("stop")){
                break;
            }
            System.out.println(line);
            String[] words = line.split("\\s+");

            System.out.println(words[0] + "this is the node");
            int nodeId = Integer.parseInt(words[0]);
            List<Integer> neighborIds = new ArrayList<>();
            ArrayList<Pair<Integer, List<Integer>>> PortUsage = new ArrayList<>();
            List<Pair<Integer,Float>> EdgeWeight = new ArrayList<>();

            for(int i = 1; i < words.length; i++){

                if((i) % 4 ==1) {
                    System.out.println(words[i] + "this is the i neighbor");
                    neighborIds.add(Integer.parseInt(words[i]));
                }
                if((i) % 4 ==2) {
                    System.out.println(words[i] + "this is the wight");
                    EdgeWeight.add(new Pair<>(Integer.parseInt(words[i-1]),Float.parseFloat(words[i])));
                }
                if((i) % 4 ==3) {
                    System.out.println(words[i] + "this is the port1");
                }
                if((i) % 4 ==0) {
                    System.out.println(words[i] + "this is the port2");
                    List<Integer> ports = new ArrayList<>();
                    ports.add(Integer.parseInt(words[i-1]));
                    ports.add(Integer.parseInt(words[i]));
                    PortUsage.add(new Pair<>(Integer.parseInt(words[i-3]), ports));
                }
            }
            System.out.println(neighborIds+"111111111111111111");
            System.out.println(EdgeWeight+"2222222222222222");
            System.out.println(PortUsage+"33333333333");
            System.out.println(nodeId+ " 0000000");
            System.out.println(num_of_nodes+ " 0000000");
            Node node1 = new Node(nodeId,num_of_nodes, neighborIds, EdgeWeight,PortUsage);
            System.out.println(node1);
            nodes.add(new Pair<>(nodeId,node1));
        }
    }

    public void start(){
        // your code here
    }

    public void terminate(){
        // your code here
    }
}
