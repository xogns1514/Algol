package dongbin.greedy;
import java.util.*;

public class 곱셉혹은더하기
{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        //첫 번째 문자를 숫자로 변경한 값 대입
        long result = str.charAt(0) - '0';
        //charAt = String으로 저장된 문자열 중에 한 글자만 선택해서 char타입으로
        for(int i = 1; i < str.length(); i++){
            int num = str.charAt(i) - '0';
            if(num <= 1 || result <= 1){
                result += num;
            }
            else{
                result *= num;
            }
            System.out.println(result);
        }
    }

}
