package dongbin.greedy;
import java.util.Scanner;

//N이 K로 나눠질때 먼저 나누기를 수행하면 된다.
public class _1될때가지 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int K = scan.nextInt();

        int count = 0;
        int other = N % K; // n을 k로 나눈 나머지

        if(other == 0){ //n이 k로 나눠질때
            while(N != 1){
                N /= K;
                count ++;
            }
        }
        else{
            count += other;
            N = N - other;
            while(N!=1){
                N /= K;
                count ++;
            }
        }
        System.out.println(count);
    }
}
//
/*
import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();
        int result = 0;

        while(true) {
            //n이 k로 나누어 떨어지는 수가 될 때까지 빼기
            int target = (n/k) * k;
            result += (n - target); // 나머지
            n = target;
            //n이 k보다 작을 때 (더 이상 나눌 수 없을 때) 반복문 탈출
            if(n<k) break;
            //k로 나누기
            result += 1;
            n /= k;
        }
        //마지막으로 남은 수에 대하여 1씩 빼기
        result += (n-1);
        System.out.println(result);

    }
}*/
