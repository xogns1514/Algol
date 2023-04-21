/*package dongbin.binarySearch;
import java.util.*;

public class 정렬배열특정수개수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //N과 x입력받기
        int n = sc.nextInt();
        int x = sc.nextInt();
        int []arr = new int[n];
        //결과값
        int result = 0;
        //처음으로 x값 발견한 index 값
        int idx = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int start = 0;
        int end = n-1;

        while(start <= end){
            int mid = (start + end) / 2;
            //중간값이랑 x가 같으면 중단
            if(arr[mid] == x) {
                idx = mid;
                break;
            }
            //중간값이 x보다 크면 끝값 mid - 1
            else if(x < arr[mid]){
                end = mid - 1;
            }
            //중간값이 x보다 작으면 start = mid + 1
            else {
                start = mid + 1;
            }
        }
        //좌측에 몇개있는지 count
        for(int i = idx; i >= 0; i--){
            if(arr[idx]==arr[i]) result += 1;
            else break;
        }
        //우측에 몇개있는지 count
        for(int j = idx + 1; j < n; j++){
            if(arr[idx] == arr[j]) result += 1;
            else break;
        }
        System.out.println(result);
    }
}*/
//내가 작성한 코드. 첫 위치를 탐색한후 앞 뒤를 for문을 통해서 갯수를 구함. 이러면 타임 아웃이 생길수 있다
//log(n) 의 시간 복잡도를 요구함. 첫 위치, 마지막 위치를 통해 갯수를 구해야 countbyrange

import java.util.*;

public class 정렬배열특정수개수{
    //target 보다 크거나 같은 첫번째 위치 반환
    public static int lowerBound(int [] arr, int target, int start, int end){
        while(start < end){
            int mid = (start + end) / 2;
            if(arr[mid] >= target) end = mid;
            else start = mid + 1;
        }
        return end;
    }
    //target보다 큰 첫번째 위치 반환
    public static int upperBound(int[] arr, int target, int start, int end) {
        while(start < end){
            int mid = (start + end) / 2;
            if(arr[mid] > target) end = mid;
            else start = mid + 1;
        }
        return end;
    }
    // 값이 [left_value, right_value]인 데이터의 개수를 반환하는 함수
    public static int countByRange(int[] arr, int leftValue, int rightValue){
        int rightIndex = upperBound(arr,rightValue,0,arr.length);
        int leftvalue = lowerBound(arr, leftValue, 0, arr.length);
        return rightValue - leftValue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //데이터 입력
        int n = sc.nextInt();
        int x = sc.nextInt();

        //전체 데이터 입력받기
        int[] arr = new int [n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        //값이 [x,x]범위에 있는 데이터의 개수 계산
        int cnt = countByRange(arr, x, x);

        //값이 x인 원소가 존재하지 않는다면
        if(cnt == 0) System.out.println(-1);
        //값이 존재한다면
        else System.out.println(cnt);

    }
}