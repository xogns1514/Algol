import java.util.Scanner; //데이터 입력
//testtest
public class Main{
    public static void main(String[] args) {

        //변수
        int num1;
        char c1 = 'A';
        long num2 = 123L;
        float num3 = 13.2F;
        boolean result = true;


        //
        Scanner scan = new Scanner(System.in);//사용자로부터 입력
        String name = scan.next(); //입력값을 문자열로 반환

        byte a = scan.nextByte();
        short b = scan.nextShort();
        int c = scan.nextInt();
        long d = scan.nextLong();

        float e = scan.nextFloat();
        double f = scan.nextDouble();

        boolean g = scan.nextBoolean();

        String h = scan.next();//String 형 입력 및 리턴, 공백을 기준으로 한단어 읽기
        String i = scan.nextLine();//String 형 입력 및 리턴, 개행을 기준으로 한 줄 읽기
    }
}