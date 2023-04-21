package dongbin.DP;
import java.util.*;
public class 효율적화폐구성 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //화폐 종류 개수 입력
        int n = sc.nextInt();
        //만들고자 하는 수
        int m = sc.nextInt();
        //화폐 종류 입력
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        //dp 테이블
        int[] dp = new int[m+1];
        Arrays.fill(dp,10001);
        //bottom-up
        dp[0] = 0;
        for(int i = 0; i < n; i++){
            for(int j = arr[i]; j <= m; j++){
                // (i-k)원을 만드는 방법이 존재하는 경우
                if(dp[j-arr[i]] != 10001){
                    dp[j] = Math.min(dp[j], dp[j] - arr[i] + 1);
                }
            }
        }
        if(dp[m] == 1001) System.out.println("-1");
        else System.out.println(dp[m]);

    }
}
