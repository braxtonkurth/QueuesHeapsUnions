import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;




public class Kruskal extends Graph {


   public Kruskal(String filePath) throws FileNotFoundException { // complete this constructor
       Graph g = IOHelper.readWeightedGraph(filePath);
       this.numVertices = g.numVertices;
       this.adjList = g.adjList;
   }


   public ArrayList<Edge> execute() { // complete this method
       ArrayList<Edge> edgeList = new ArrayList<>();
       for(int i = 0; i < this.numVertices; i++){
           edgeList.addAll(this.adjList.get(i));
       }
       Collections.sort(edgeList, new Comparator<Edge>(){
        @Override
        public int compare(Edge e1, Edge e2){
            return e1.weight - e2.weight;
        }
       });
       UnionFind objUF = new UnionFind(this.numVertices);
       ArrayList<Edge> mst = new ArrayList<Edge>();
       int numEdgesAdded = 0;
       for(Edge e : edgeList){
           int src = e.src;
           int dest = e.dest;
           if(objUF.find(src) != objUF.find(dest)){
               objUF.doUnion(src, dest);
               mst.add(e);
               numEdgesAdded++;
               if(numEdgesAdded == this.numVertices - 1){
                   break;
               }
           }
       }
       return mst;
   }
}



