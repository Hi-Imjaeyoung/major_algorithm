import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class GreedyCoinProblem {
    public static void main(String[] args) {
        int[] coins = {1,5,10,25};
        int amount = 99;
        //최소 동전의 개수 산출
        int coin = 0;
        if(amount>25){
            coin += amount/25;
            amount %= 25;
        }
        if(amount>10){
            coin += amount/10;
            amount %= 10;
        }
        if(amount>5){
            coin += amount/5;
            amount %= 5;
        }
        coin+=amount;
        System.out.println(coin);
        // for
        amount = 99;
        coin = 0;
        for(int i=coins.length;i>=0;i++){
            int tmp = amount /coins[i];
            coin += tmp;
            amount -= tmp*coins[i];
        }
    }
}
