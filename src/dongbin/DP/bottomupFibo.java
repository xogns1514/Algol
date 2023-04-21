package dongbin.DP;
import java.util.*;
public class bottomupFibo {
    public static long[] d = new long [1000];

    public static void main(String[] args) {
        d[1] = 1;
        d[2] = 1;
        int n = 50; //50번째 피보나치 수를 계산

        //피보나피 함수 반복문으로 구현
        for(int i = 3; i <= n; i++){
            d[i] = d[i-1] + d[i-2];
        }
        System.out.println(d[n]);
    }
}
