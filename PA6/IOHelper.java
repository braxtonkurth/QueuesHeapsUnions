import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;


public class IOHelper {


   public static Graph readWeightedGraph(String filePath) throws FileNotFoundException { // complete this method
       Scanner fileReader = new Scanner(new File(filePath));
       Graph graph = new Graph();
       int numVertices = fileReader.nextInt();
       graph.numVertices = numVertices;
       graph.adjList = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            graph.adjList.add(new ArrayList<>());
        }
       while(fileReader.hasNextLine()){
           int src = fileReader.nextInt();
           int dest = fileReader.nextInt();
           int weight = fileReader.nextInt();
           Edge edge = new Edge(src, dest, weight);
           graph.adjList.get(src).add(edge);
       }
       fileReader.close();
       return graph;
   }
}



