package dongbin.binarySearch;
import java.util.*;

public class bSearch {
    public static int binarySearch(int [] arr, int target, int start, int end){
        while(start <= end){
            int mid = (start + end) / 2;
            //찾은 경우 중간점 인덱스 반환
            if(arr[mid] == target) return mid;
            //중간값이 찾고자 하는 값보다 작은 경우 오른쪽 확인
            else if(arr[mid] < target){
                start = mid + 1;
            }
            else if(arr[mid] > target){
                end = mid -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int target = sc.nextInt();

        //전체 원소 입력받기
        int[] arr = new int[n];
        for(int i = 0; i< n; i++){
            arr[i] = sc.nextInt();
        }

        //이진 탐색 수행 결과
        int result = binarySearch(arr, target, 0, n-1);
        if(result == -1){
            System.out.println("원소 존재 x");
        }
        else{
            System.out.println(result + 1);
        }
    }
}
