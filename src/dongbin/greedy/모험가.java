package dongbin.greedy;
import java.util.*;

//그리디
//최대한 많은 그룹을 만들자. 공포도 n인 사람은 n명이상인 그룹
//공포도 가장 큰사람
public class 모험가 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int count = 0;
        int result = 0;

        for(int i = 0; i< N; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);//오름 차순 정렬
        //공포도가 낮은 사람부터 조건 성립시 그룹 만듦
        for(int i : arr){
            count += 1;
            if(count >= i){
                count = 0;
                result += 1;
            }
        }
        System.out.println(result);
    }
}
/*
//답안 예시
public Class Main() {
    public static int n;
    public static int ArrayList<Integer> arrayList = new ArrayList<>();
    //ArrayList 활용
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i < n; i++){
            arrayList.add(scan.nextInt());
        }
        Collection.sort(arrayList);

        int result = 0;
        int count = 0;
        for(int i = 0; i < n; i++){
            count += 1;
            if(count >= arrayList.get(i)){
                result += 1;
                count = 0;
            }
        }
        System.out.println(result);
    }
}*/
