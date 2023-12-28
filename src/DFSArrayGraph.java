import java.util.*;

public class DFSArrayGraph {
    static boolean[] vist;
    public static void main(String[] args) {
        int[][] graph = {{0, 1, 1, 0, 0},{1, 0, 0, 1, 0},{1, 0, 0, 1, 1},{0, 1, 1, 0, 0},{0, 0, 1, 0, 0}};
        vist = new boolean[graph.length];
        List<Integer> tmp = new LinkedList<>();
        DFS(graph,tmp,0);
    }

    public static void DFS(int[][] graph,List<Integer> tmp,int start){
        vist[start] = true;
        System.out.println(start);
        for(int j=0;j<graph[start].length;j++){
            if(!vist[j] && graph[start][j]==1){
                DFS(graph,tmp,j);
            }
        }
    }
}
