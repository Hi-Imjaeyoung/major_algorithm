import java.util.ArrayList;
import java.util.List;

public class DFSListGraph {
    static List<List<Integer>> graph;
    static boolean[] vist;
    public static void main(String[] args) {
        int[][] inputArr ={{0,1},{0,2},{1,3},{2,3},{2,4}};
        int nodeNumber = 5;
        vist = new boolean[nodeNumber];
        graph = new ArrayList<>();
        for(int i=0;i<nodeNumber;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] a:inputArr){
            addEdge(a[0],a[1]);
        }
        dfs(0);
    }
    static void addEdge(int start, int end){
        graph.get(start).add(end);
        graph.get(end).add(start);
    }
    public static void dfs(int start){
        System.out.println(start);
        vist[start] = true;
        for(int next : graph.get(start)){
            if(!vist[next]) dfs(next);
        }
    }
}
