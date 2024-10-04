import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Arrays;

public class Dijkstra extends Graph {


   public int distance[], parent[];
   private boolean closed[];


   public Dijkstra(String filePath) throws FileNotFoundException { // complete this constructor
       Graph g = IOHelper.readWeightedGraph(filePath);
       this.numVertices = g.numVertices;
       this.adjList = g.adjList;
   }


   public void execute(int source) { // complete this method
       distance = new int[numVertices];
       parent = new int[numVertices];
       closed = new boolean[numVertices];
       Arrays.fill(distance, Integer.MAX_VALUE);
       Arrays.fill(parent, -1);
       Arrays.fill(closed, false);
       distance[source] = 0;
       PriorityQueue<PriorityQueuePair> open = new PriorityQueue<>(new PriorityQueuePairComparator(){
        public int compare(PriorityQueuePair o1, PriorityQueuePair o2) {
            return o1.priority - o2.priority;
        }
       });
       open.add(new PriorityQueuePair(source, 0));
       while(!open.isEmpty()) {
           PriorityQueuePair minElement = open.poll();
           int minVertex = minElement.item;
           if(closed[minVertex]) {
               continue;
           }
           closed[minVertex] = true;
           for(Edge e : adjList.get(minVertex)) {
               int adjVertex = e.dest;
               if(!closed[adjVertex]) {
                   int newDist = distance[minVertex] + e.weight;
                   if(newDist < distance[adjVertex]) {
                       distance[adjVertex] = newDist;
                       parent[adjVertex] = minVertex;
                       open.add(new PriorityQueuePair(adjVertex, newDist));
                   }
               }
           }
       }
   }
}



