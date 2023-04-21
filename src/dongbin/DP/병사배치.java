package dongbin.DP;
import java.util.*;

public class 병사배치 {
    static ArrayList<Integer> v= new ArrayList<>();
    static int[]dp = new int[2000];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //n입력받기
        int n = sc.nextInt();
        //병사 공격력 입력
        for(int i = 0; i < n; i++){
            v.add(sc.nextInt());
        }
        //뒤집기
        Collections.reverse(v);
        //dp 테이블 초기화
        for(int i = 0; i < n; i++){
            dp[i] = 1;
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(v.get(j) < v.get(i)){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max, dp[i]);
        }
        int result = n - max;
        System.out.println(result);

    }


}
