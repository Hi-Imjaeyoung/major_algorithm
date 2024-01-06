import com.sun.security.jgss.GSSUtil;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 5, 34, 6, 455, 5, 23, 43, 5, 21, 3, 5, 7, 421, 32, 12, 51, 2, 2};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(search(arr, 6));
        System.out.println(solution(6,new int[] {7,10}));
    }

    private static int search(int[] arr, int value) {
        int start = 0;
        int end = arr.length - 1;
        // TODO
        while (start < end) {
            // TODO check start+end = odd, even
            int middle = (start + end) / 2;
            if (arr[middle] > value) {
                end = middle;
            } else if (arr[middle] == value) {
                return middle;
            } else {
                start = middle;
            }
        }
        return -1;
    }

    public static long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long start = n;
        long end = times[times.length - 1] * n;
        while (start < end) {
            int sum = 0;
            long middle = (start + end) / 2;
            for (int i = 0; i < times.length; i++) {
                sum += middle / times[i];
            }
            if (sum < n) {
                start = middle;
            } else {
                answer = middle;
                end = middle;
            }
        }
        return answer;
    }
}
