package Programmers.LV0;

public class 잘라서배열저장하기 {
    public String[] solution(String my_str, int n) {
        String[] answer = {};
        int length = my_str.length(); //8
        int sub = length / n; //길이 나눈 몫
        int other = length % n; //길이 나눈 나머지
// 나머지가 없을 시, 그냥 잘라서 옮기면 된다
        if(other == 0) {

            answer = new String[sub];
            for(int i = 0; i < sub; i++){
                answer[i] = my_str.substring(i*n, i*n + n);
            }
            return answer;
        }
        //나머지가 있을시, 나머지만큼 할당하고 길이에 맞춰 옮겨야함
        else {
            answer = new String[sub + 1];
            int idx = 0;
            for(int i = 0; i < sub; i++){
                idx = i*n;
                answer[i] = my_str.substring(idx, idx + n);
            }
            answer[sub] = my_str.substring(idx + n, idx + n + other);
            return answer;

        }
    }
}
/*
다른 사람 풀이, 삼항 연산자 활용
class Solution {
    public String[] solution(String my_str, int n) {
        int resultCnt = (my_str.length() + n - 1) / n;
        String[] answer = new String[resultCnt];

        for (int i = 0; i < resultCnt; i++) {
            int start = n * i;
            int end = start + n >= my_str.length()? my_str.length(): start + n;
            // start로부터 n만큼 넘어가면 my_str 길이까지 반환, n단위로 계속 반환
            answer[i] = my_str.substring(start, end);
        }

        return answer;
    }
}

 */