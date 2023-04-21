package dongbin.DP;
import java.util.*;

public class _1로만들기 {

    //dp 테이블
    public static int [] dp = new int [30001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //x값 입력
        int x = sc.nextInt();
        dp[1] = 0;
        /*
        f(1) = 1
        f(6) = f(5) / f(3) / f(2) 이것중에 최소
        Ai = i를 1로 만들기 위한 최소 연산 횟수
        Ai = min(A(i-1), A(i/2), A(i/3), A(i/5)) + 1
        1빼는 연산 제외, 나누어떨어질 떄에 한해 점화식 적용 가능
         */
        for(int i = 2; i < x+1; i++){
            //현재의 수에서 1빼는 경우
            dp[i] = dp[i-1] + 1;
            //현재의 수가 2로 나누어 떨어지는 경우
            if(i%2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
            //현재의 수가 3으로 나누어 떨어지는 경우
            if(i%3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
            //현재의 수가 5로 나누어 떨어지는 경우
            if(i%5 == 0) dp[i] = Math.min(dp[i], dp[i/5] + 1);
        }
        System.out.println(dp[x]);

    }

}
