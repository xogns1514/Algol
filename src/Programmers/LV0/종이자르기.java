package Programmers.LV0;

public class 종이자르기 {
    public int solution(int M, int N) {
        int answer = 0;

        // 가로 먼저 다 자름
        answer = answer + (M-1);
        //각각 M만큰 다 자름
        answer = answer + M*(N-1);

        return answer;
    }
}
