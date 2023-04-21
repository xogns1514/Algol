package Programmers.LV0;

public class 문자열밀기 {
    public int solution(String A, String B) {
        int answer = 0;
        /*처음 내가 생각한 방식 A길이만큼 계속 밀어서 결국 일치되면 되는거 아닌가?
            => 다른 배열에 계속 옮기면서 밀어야하나? ..너무 1차원 적으로 생각했다.
            문자가 밀려있다 -> 밀려있는 문자를 반복해서 쓰면 원상태 문자가 포함되어있다.
            ==> 이어붙이면 굳이 다른 배열에 옮기지 않아도 된다. substring 메소드를 이용해보자
        */
        String C = B + B; //두개 이어 붙이기

        if(A == B) return answer;

        for(int i = 0; i < A.length(); i++){
            String indx = C.substring(i,i + A.length());
            if(indx.equals(A)) return answer;
            answer += 1;
        }

        return -1;
    }
}
//다른 사람의 코드
/*

class Solution {
    public int solution(String A, String B) {
        String tempB = B.repeat(2);
        return tempB.indexOf(A);
    }
}
repeat 메소드 활용. 반복 횟수 만큼 문자를 이어 붙임
indexOf 메소드 활용. 해당 문자가 B의 몇번째에 있는지 반환해줌
*/