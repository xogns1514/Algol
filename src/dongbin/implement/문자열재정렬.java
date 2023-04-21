package dongbin.implement;
import java.util.*;
//public class 문자열재정렬 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        String[] str = sc.nextLine().split("");
//        int count = 0;
//        int buffer = 0; //정수값 더하기
//        for(String s : str){
//            if( '0' <= s.charAt(0) &&  s.charAt(0) <= '9' ){
//                buffer += Integer.parseInt(s);
//                count += 1;
//            }
//        }
//        Arrays.sort(str);
//        StringBuffer sb = new StringBuffer();
//        sb.append();
//    }
//}
///
/*
public class Main {
    public static String str;
    public static ArrayList<Character> result = new ArrayList<>();
    public static int value = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.next();

        //문자를 하나씩 확인하며
        for(int i = 0; i < str.length(); i++){
            if(Character.isLetter(str.charAt(i)))
            //알파벳인지 판단하는 메서드{
                result.add(str.charAt(0));
            }
            //숫자는 따로 더하기
            else{
                value += str.charAt(0) - '0';
            }
        }
        //알파벳 오름차순 정렬
        Collections.sort(result);

        //알파벳 차례대로 출력
        for(int i = 0; i < result.size(); i++){
            System.out.println(result.get(i));
        }

        //숫자가 하나라도 존재하는 경우 가장 뒤에 출력
        if(value != 0) System.out.print(value);
        System.out.println();
    }
}*/
