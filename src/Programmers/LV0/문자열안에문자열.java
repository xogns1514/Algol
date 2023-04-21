package Programmers.LV0;

public class 문자열안에문자열 {
    public int solution(String str1, String str2){
        if(str1.contains(str2)) return 1;
        else return 2;
    }
}
//문자열 내 존재 확인 메서드 contains