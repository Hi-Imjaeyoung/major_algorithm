public class BaseProblem {
    public static void main(String[] args) {
        int n = 125;
        int answer = 0;
        String tmp = "";
        while (n>0){
            tmp += Integer.toString(n % 3);
            n /=3;
        }
        System.out.println(tmp);
        for(int i=0;i<tmp.length();i++){
            answer += (int)Math.pow(3,tmp.length()-i-1)*Character.getNumericValue(tmp.charAt(i));
        }
        System.out.println(answer);
    }
}
