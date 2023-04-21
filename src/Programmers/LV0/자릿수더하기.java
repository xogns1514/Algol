package Programmers.LV0;

public class 자릿수더하기 {
    public int solution(int n) {
        int answer = 0;
        String str1 = Integer.toString(n);
        //int형을 string으로: Integer.toString
        String[] str2 = str1.split("");
        for(String s : str2){
            answer = answer + Integer.parseInt(s);
            //String을 int형으로 Integer.parseInt()
        }
        return answer;
    }
}
