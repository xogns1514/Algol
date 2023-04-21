package dongbin.DP;
import java.util.*;

public class 개미전사 {
    //앞서 계산된 결과를 저장하기 위한 DP 테이블 초기화
    public static int [] dp = new int[100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //식량창고 개수 입력
        int n = sc.nextInt();
        //저장된 식량의 개수 입력
        int [] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        //bottop-up
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for(int i = 2; i < n; i++){
            dp[i] = Math.max(dp[i-1],dp[i-2] + arr[i]);
        }
        System.out.println(dp[n-1]);

    }
    //점화식 생각
    //Ai = i번째 식량창고까지의 최적의 해
    //Ki = i번째 식량창고에 있는 식량의 양
    //Ai = max(A(i-1),A(i-2) + K(i)
}
