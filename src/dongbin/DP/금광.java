package dongbin.DP;
import java.util.*;
/*
arr[i][j] = i행 j열에 존재하는 금의 양
dp[i][j] = i행 j열까지의 최적의 해(얻을 수 있는 금의 최댓값)
dp[i][j] = arr[i][j] + max(dp[i-1][j-1], dp[i][j-1], dp[i+1][j-1])

 */
public class 금광 {
    public static int[][]dp = new int[20][20];
    public static int[][]arr = new int[20][20];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //테스트 케이스 t입력
        int t = sc.nextInt();
        //dp 배열
        for(int i = 0; i < t; i++){
            //n,m 입력
            int n = sc.nextInt();
            int m = sc.nextInt();
            //금광 정보 입력
            for(int j = 0; j < n; j++){
                for(int k = 0; k < m; k++){
                    arr[j][k] = sc.nextInt();
                }
            }
            //dp테이블에 복사
            for(int j = 0; j < n; j++){
                for(int k = 0; k < m; k++){
                    dp[j][k] = arr[j][k];
                }
            }

            //dp
            for(int j = 1; j < m; j++){
                for(int k = 0; k < n; k++){
                    int leftUp, leftDown, left;
                    //왼쪽 위에서 오는 경우
                    if(k == 0) leftUp = 0;
                    else leftUp = dp[k-1][j-1];
                    //왼쪽 아래에서 오는 경우
                    if(k == n-1) leftDown = 0;
                    else leftDown = dp[k+1][j-1];
                    //왼쪽에서 오는 경우
                    left = dp[k][j-1];

                    dp[k][j] = dp[k][j] + Math.max(left, Math.max(leftDown, leftUp));
                }
            }

            //결과 = 마지막 열의 각 행값 총합
            int result = 0;
            for(int j = 0; j < n; j++){
                result = Math.max(result,dp[j][m-1]);
            }
            System.out.println(result);

        }
    }

}
