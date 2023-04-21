package Programmers.LV0;

public class ox퀴즈 {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        for(int i = 0; i < quiz.length; i++){
            String[] buffer = quiz[i].split(" ");
            //String 분리
            int a = Integer.parseInt(buffer[0]);
            int b = Integer.parseInt(buffer[2]);
            int c = Integer.parseInt(buffer[4]);
            //Sting 을 integer로
            String xx = buffer[1];

            if(xx.equals("+")){
                if((a + b) == c) answer[i] = "O";
                else answer[i] = "X";
            }
            else if(xx.equals("-")){
                if((a - b) == c) answer[i] = "O";
                else answer[i] = "X";
            }
        }
        return answer;
    }
}
//다른 사람 풀이
/*class Solution {
    public String[] solution(String[] quiz) {
        for(int i=0; i<quiz.length; i++){
            String[] text = quiz[i].split(" ");
            int result = Integer.parseInt(text[0]) + ( Integer.parseInt(text[2]) * ( text[1].equals("+") ? 1:-1) );
            quiz[i] = result == Integer.parseInt(text[4])? "O": "X";
        }
        return quiz;
    }
}*/
//3항 연산자의 활용