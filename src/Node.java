import java.net.*;
import java.util.*;
import java.io.*;

public class Node implements Runnable{
        private final int id;
        private List<Pair<Integer,Double>> EdgeWeight; //(key,value)=(neighbour_id,weight)
        private ArrayList<Pair<Integer,List<Integer>>> PortUsage ;//(key,value)=(neighbour_id,(send_port,listen_port))
        private List<Integer> neighborIds;
        private final int NumberOfNodes;
        private static double [][] adjacencyList;

        public Node(int id , int NumberOfNodes, List<Integer> neighborIds, List<Pair<Integer,Double>> EdgeWeight,
                    ArrayList<Pair<Integer,List<Integer>>> PortUsage) {
            super();
            this.id = id;
            this.NumberOfNodes = NumberOfNodes;
            this.neighborIds = neighborIds;
            this.EdgeWeight = EdgeWeight;
            this.PortUsage = PortUsage;
            this.adjacencyList = new double[NumberOfNodes][NumberOfNodes];
        }

        @Override
        public void run(){
            // TODO: implement link state routing algorithm
            for (int i = 0; i<10;i++){
                System.out.println(i+"  this is   "+this.id);            }
            SendingMassage test = new SendingMassage("fuck yous "+Integer.toString(id),6666+id);
            test.start();
            System.out.println("test         "+"  this is   "+this.id);
            Server server = new Server(6666+id);
            server.start();
            try{
                test.join();
                server.join();
            }
            catch (Exception e){
            }

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
                            for (Pair<Integer,Double> pair : EdgeWeight){
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

        // its working but i dont know how it will work while the threads are running maybe locks
        public void setEdgeWeight( int id, double newWeight){
            for(Pair<Integer,Double> pair : EdgeWeight){
                if(pair.getKey() == id){
                    pair.setValue(newWeight);
                }
            }
            System.out.println("node num "+this.id+" change w of "+id+" node, new w is"+newWeight);
            System.out.println(EdgeWeight);
        }

        // done maybe working
        public void print_graph(){
            updateAdjacencyList();
            // dont forget to delete this line in the end
            System.out.println("printing G " + id);
            for (int i = 0; i < NumberOfNodes; i++) {
                System.out.print(i+1 + " ");
                for(int j = 0; j < NumberOfNodes; j++) {
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

class SendingMassage extends Thread{
    Object massage;
    int port;
    public SendingMassage(Object massage, int port){
        this.massage = massage;
        this.port = port;
    }
    @Override
    public void run(){
        Boolean flag = Boolean.TRUE;
        int counter = 3;
        while(flag && counter != 0) {
            try {
                InetAddress localhost = InetAddress.getLocalHost();
                Socket socket = new Socket(localhost, this.port);
                OutputStream output = socket.getOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(output);
                objectOutputStream.writeObject(massage);
                socket.close();
                flag = Boolean.FALSE;
            } catch (IOException e) {
//                System.out.println("exeption"+counter);
                counter--;
            }
        }
        System.out.println("12");
    }

}

class Server extends Thread{
    int port;
    public Server(int port){
        this.port = port;
    }

    @Override
    public void run() {
        try{
            ServerSocket ss = new ServerSocket(this.port);
            System.out.println("ServerSocket awaiting connections...");
            Socket socket = ss.accept(); // blocking call, this will wait until a connection is attempted on this port.
            System.out.println("Connection from " + socket + "!");

            // get the input stream from the connected socket
            InputStream inputStream = socket.getInputStream();
            // create a DataInputStream so we can read data from it.
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            // read the list of messages from the socket
            Object obj = objectInputStream.readObject();
            System.out.println(obj);
            ss.close();
            socket.close();
        }catch (Exception e){

        }
    }
}