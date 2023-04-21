package dongbin.implement;
import java.util.*;

//가능한 모든 시각의 경우를 하나씩 모두 세서 풀 수 있다
// 시각을 1 씩 증가하면서 3 포함하는지 확인
public class 시각 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // n입력받기
        int n = sc.nextInt();
        int hour = 0, min = 0, sec = 0;
        int count = 0;

        while (hour <= n) {
            //3 포함시 counter 증가
            if (Integer.toString(hour).contains("3") || Integer.toString(min).contains("3")
                    || Integer.toString(sec).contains("3")) {
                count += 1;
            }

            if (sec < 59) {
                sec += 1;
            } else {
                min += 1;
                sec = 0;
            }

            if (min < 59) {
                min += 1;
            } else {
                hour += 1;
                min = 0;
            }
        }
        System.out.println(count);
    }
}
//코드 복잡하고 망해버렸음
//59초에서 다음으로 수 넘기는 방법을 for문으로 할 생각을 못했음
//판별 같은 경우 복잡해지면 따로 메서드를 작성해보자!




/*
//예시 답안
public class Main {
    //특정한 시각 안에 '3'이 포함되어 있는지 여부
    public static boolean check(int h, int m, int s){
        if(h % 10 == 3 || m / 10 ==3 || m % 1== 3 || s / 10 == 3 || s % 10 == 3) return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //H 입력받기
        int h = sc.nextInt();
        int cnt = 0;
        for(int i = 0; i <= h; i++){
            for(int j = 0; j < 60; j++){
                for(int k = 0; k < 60; k++){
                    //매 시각 안에 '3' 포함되어 있다면 카운트 증가
                    if(check(i,j,k)) cnt++;
                }
            }
        }
        System.out.println(cnt);

    }
}

*/
