import com.sun.security.jgss.GSSUtil;

import java.util.Arrays;

public class DpCoinProblem {
    //static int[] memo;
    public static void main(String[] args) {
        solution(new int[][] {{7},{3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}});
        memo[0][0] = 7;
        System.out.println(Arrays.deepToString(memo));
//        int [] coins = {1,4,5};
//        int amount = 13;
//        memo = new int [amount+1];
//        Arrays.fill(memo,Integer.MAX_VALUE);
//        for(int i=0;i<coins.length;i++){
//            memo[coins[i]] = 1;
//        }
//        for(int i=1;i<=amount;i++){
//            for(int j=1; i+j<=amount;j++){
//                if(i+j<=amount){
//                    memo[i+j] = Math.min(memo[i]+j, memo[i+j]);
//                }
//                if(i+4*j<=amount){
//                    memo[i+4*j] = Math.min(memo[i]+j, memo[i+j*4]);
//                }
//                if(i+5*j<=amount){
//                    memo[i+5*j] = Math.min(memo[i]+j, memo[i+j*5]);
//                }
//            }
//            //System.out.println(Arrays.toString(memo));
//        }
//
//        // 강사님
//        memo = new int[amount+1];
//        memo[1] = 1;
//        for(int i =2; i<=amount;i++){
//            int min= amount;
//            for(int c :coins){
//                if(i-c>=0){
//                    if(min>memo[i-c]){
//                        min = memo[i-c];
//                    }
//                    memo[i] = min+1;
//                }
//            }
//        }
////        System.out.println(Arrays.toString(memo));
//
//        // DP
//        memo = new int[amount+1];
//        for(int i=0;i<coins.length;i++){
//            memo[coins[i]] = 1;
//        }
//        dp(amount);
//        System.out.println(Arrays.toString(memo));


    }
//    public static int dp(int now){
//        if(now<0){
//            return 13;
//        }
//        if(memo[now] != 0){
//                return memo[now];
//        }
//        memo[now] = Math.min(dp(now-5)+1,dp(now-4)+1);
//        memo[now] = Math.min(memo[now], dp(now-1)+1);
//        return memo[now];
//    }

        static int[][] memo; // depth의 max
        public static int solution(int[][] triangle) {
            int answer = 0;
            int depth = triangle.length-1;
            memo = new int [depth][triangle[depth].length];
            dp(triangle,depth-1,triangle[depth].length-1);
            System.out.println(Arrays.toString(memo[depth-1]));
            return answer;
        }
        public static int dp(int[][] map,int depth, int w){
            System.out.println(depth + " " + w);
            if(depth<0 || w>map[depth].length || w<0){
                return -1;
            }
            if(memo[depth][w]!=0){
                return memo[depth][w];
            }
            memo[depth][w] = Math.max(dp(map,depth-1,w-1)+map[depth][w], dp(map,depth-1,w)+map[depth][w]);
            return memo[depth][w];
        }
}
