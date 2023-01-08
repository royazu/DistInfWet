import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Node extends Thread{
        private final int id;
        private final List<Integer> neighborIds;
//jsadasdkasdasdasdasdasdasdasdasd
        public Node(int id, List<Integer> neighborIds) {
            this.id = id;
            this.neighborIds = neighborIds;
        }

        public int getId() {
            return id;
        }

        public List<Integer> getNeighborIds() {
            return neighborIds;
        }

    }
