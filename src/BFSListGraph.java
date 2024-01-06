import java.util.*;

public class BFSListGraph {
    static List<List<Integer>> graph;
    static boolean[] vist;
    static int[] distance;
    public static void main(String[] args) {
        int[][] inputArr ={{0,1},{0,2},{1,3},{2,3},{2,4}};
        int nodeNumber = 5;

//        for(int[] a:inputArr){
//            addEdge(a[0],a[1]);
//            addEdge(a[1],a[0]);
//        }
        vist = new boolean[16];
        graph = new ArrayList<>();
        distance= new int[16];
        for(int i=0;i<16;i++){
            graph.add(new ArrayList<>());
        }
        for(int i =1;i<=3;i++){
          for(int j=1;j<=5;j++){
//              1) 시작노드 표현식 : (i-1)*5+j
//              2) 타겟의 번호와 타켓의 유효성 체크
//              2-1) 타켓의 번호 : i +- 1, j +-1
//              2-2) 타겟의 유효성 : i 와 j사 상하좌우 체킹
              int [] dx ={1,-1,0,0} , dy = {0,0,1,-1};
              for(int k =0;k<4;k++){
                  int nextI = i+dx[k];
                  int nextJ = j+dy[k];
                  if(nextI >=1 && nextI<=3 && nextJ>=1 && nextJ<=5){
                      addEdge((i-1)*5+j,(nextI-1)*5+nextJ);
                  }
              }
              }
         }
        System.out.println(graph);
        //bfs(0);
        shortestBfs(1,3);
        System.out.println(Arrays.toString(distance));
    }
    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        vist[start] = true;
        queue.add(start);
        while (!queue.isEmpty()){
            int target = queue.poll();
            for(int next:graph.get(target)){
                if(!vist[next]){
                    queue.add(next);
                    distance[next] = distance[target]+1;
                    vist[next] = true;
                }
            }
        }
    }
    static int shortestBfs(int start,int end){
        Queue<Integer> queue = new LinkedList<>();
        vist[start] = true;
        queue.add(start);
        while (!queue.isEmpty()){
            int target = queue.poll();
            for(int next:graph.get(target)) {
                if (!vist[next]) {
                    queue.add(next);
                    distance[next] = distance[target] + 1;
                    vist[next] = true;
                    if(next==end){
                        return distance[end];
                    }
                }
            }
        }
        return -1;
    }
    static void addEdge(int start, int end){
        graph.get(start).add(end);
    }
}
