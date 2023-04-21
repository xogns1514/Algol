package dongbin.binarySearch;
import java.util.*;

public class 떡볶이떡 {


//절단기 높이는 0붜 10억까지의 정수 중 하나이다. 큰 탐색 범위를 보면 이진탐색을 떠올려야함
//중간점의 값은 시간이 지날수록 '최적화된 값'이다. 떡의 길이 >= 필요한 길이 마다 중간점 기록하면 됨
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //떡의 개수n, 요청 떡 길이m
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [] arr = new int[n];
        //떡 길이 입력 받기
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int start = 0;
        int end = (int) 1e9;
        int result = 0;

        while(start <= end){
            long total = 0;
            int mid = (start + end)/2;
            for(int i = 0; i < n; i++){
                if(arr[i] > mid) total += arr[i] - mid;
            }
            if(total < m){
                end = mid - 1;
            }
            else {//떡의 양이 충분한 경우 덜 자르기
                result = mid;
                start = start + 1;
            }
        }
    }

}
