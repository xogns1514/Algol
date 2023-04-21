package dongbin.implement;
import java.util.*;
public class 왕실_나이트 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //이동 가능한 총 경우
        int[] dx = {-2,-2,2,2,-1,1,-1,1};
        int[] dy = {-1,1,-1,1,-2,-2,2,2};

        String inputData = sc.nextLine();
        int row = inputData.charAt(0) - 'a' + 1;
        int column = inputData.charAt(1) - '0';
        //아스키 코드를 이용한 좌표값
        //'a' - 'a' = 0 이므로 1더해주면 됨

        //8가지 방법에 이동 가능한지 판단
        int result = 0;
        for(int i = 0; i < 8; i++) {
            //다음 방향
            int nextRow = row + dx[i];
            int nextCol = column + dy[i];
            if(nextRow >= 1 && nextRow <= 8 && nextCol >= 1 && nextCol <= 8) result += 1;
        }
        System.out.println(result);
    }

}
