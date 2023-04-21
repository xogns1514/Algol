package Programmers.LV0;

import java.util.Arrays;
class 문자열정렬2{
    public String solution(String my_string) {
        String answer = "";
        answer = my_string.toLowerCase();
        char[] chars = answer.toCharArray();//정렬이용하기 위해 변환
        Arrays.sort(chars);
        answer = new String(chars);
        return answer;
    }
}