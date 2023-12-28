import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {7,6,5,8,3,5,9,1,7};
        // 최초 힙구성 : n/2번 만큼 수행
        for(int i= (arr.length/2)-1;i>=0;i--){
            heapify(arr,arr.length,i);
        }
        System.out.println(Arrays.toString(arr));
        // i=0까지 할 이유가 없다. 최소힙이니까 1은 의미가 있다.
        for(int i=arr.length-1;i>0;i--){
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            heapify(arr,i,0);
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void heapify(int[] arr,int maxIndex,int root){
        // change logic
        int right = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        if(maxIndex>(root*2)+1){
            left =  arr[(root*2)+1];
        }
        if(maxIndex>(root*2)+2){
            right =  arr[(root*2)+2];
        }
        if(arr[root]>left){
            if(right<left){
                int tmp = right;
                arr[(root*2)+2] = arr[root];
                arr[root] =tmp;
                heapify(arr,maxIndex,(root*2)+2);
            }else{
                int tmp = left;
                arr[(root*2)+1] = arr[root];
                arr[root] =tmp;
                heapify(arr,maxIndex,(root*2)+1);
            }
        }
    }
    public static void heapify2(int[] arr, int root){
        // change logic
        int maxIndex = root;
        int leftIndex = root*2+1;
        int rightIndex = root*2+2;
        if(leftIndex<arr.length && arr[maxIndex]<arr[leftIndex]){
            maxIndex =leftIndex;
        }
        if(rightIndex<arr.length &&  arr[maxIndex]<arr[rightIndex]){
            maxIndex =rightIndex;
        }
        // TODO 매개변수를 이용하여 비교
        if(maxIndex!=root){
            int tmp = arr[root];
            arr[root] = arr[maxIndex];
            arr[maxIndex] = tmp;
            heapify2(arr,maxIndex);
        }
    }
}
