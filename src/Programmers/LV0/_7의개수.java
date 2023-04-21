package Programmers.LV0;

/* 생각해낸 아이디어. 7의 개수를 세려면 문자열로 바꾸고
일치한 거 만큼 count값 늘려주면
되지 않을까?
-> int를 string으로 변환하는 메서드. Integer.toString, String.valueOf()
*/
public class _7의개수 {
    public int solution(int[] array){
        int answer = 0;
        for(int i = 0; i < array.length; i++){
            String num = Integer.toString(array[i]);
            String[] arr = num.split(""); // -> 입력받은 String 빈칸으로 자르기
            for(int j = 0; j < arr.length; j++){
                if(arr[j].equals("7")) answer++;
            }
        }
        return answer;
    }
}

/*
다른 사람의 풀이. 그냥 int 자체로 풀어보기? -> 10으로 나누면 한자리씩 따질수 있다
class Solution {
    public int solution(int[] array) {
        int answer = 0;
        for(int a : array){
            while(a != 0){
                if(a % 10 == 7){
                    answer++;
                }
                a /= 10;
            }
        }
        return answer;
    }
}

 */