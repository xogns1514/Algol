package Programmers.LV0;

public class 세균증식 {
    public int pow2(int t){
        int result = 1;
        for(int i = 0; i < t; i++){
            result = result * 2;
        }
        return result;
    }

    public int solution(int n, int t) {
        int answer = 0;
        answer = pow2(t) * n;
        return answer;
    }
}
//다른 사람
/*
class Solution {
        public int solution(int n, int t){
            int answer = 0;

            answer = n << t;

            return answer; //비트 연산자 이용
        }
}*/
