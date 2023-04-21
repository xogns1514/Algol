package Programmers.LV0;

public class 제곱수판별 {
    public int solution(int n) {
        int answer = 2;
        for(int i = 0; i< n; i++){
            int pow  = i*i;
            if(pow == n){
                answer = 1;
                return answer;
            }
        }
        return answer;
    }
}
//다른 사람 풀이
/*
class Solution {
    public int solution(int n){
        if(n % Math.sqrt(n)==0){
            return 1;
        } else {
            return 2;
        }
    }
}
//Math.sqrt() 함수 이용. 제곱근으로 판별
*/
