package dongbin.implement;
import java.util.*;

public class 상하좌우 {
    //동북서남 RULD
    public int[] x = {0,-1,0,1};
    public int[] y = {1,0,-1,0};
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [][] map = new int[n+1][n+1];
        int [] loc = {1,1};
        ArrayList<String> arrayList = new ArrayList<>();

        for(int i = 0; i < n; i++){
            arrayList.add(scan.next());
        }
        for(int i = 0; i < n; i++){
            String dir = arrayList.get(i);
            if(dir.equals("R") && loc[1] + 1 <= n){
                loc[1] += 1;
            }
            else if(dir.equals("L") && loc[1] - 1 >= 1){
                loc[1] -= 1;
            }
            else if(dir.equals("U") && (loc[0] - 1)>= 1){
                loc[0] -= 1;
            }
            else if(dir.equals("D") && loc[0] + 1 <= n){
                loc[0] += 1;
            }
        }

        System.out.println(loc[0]);
        System.out.println(loc[1]);
    }
}
/*
// 예시 답안
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //n입력받기
        int n = sc.next();
        sc.nextLine();//버퍼 비우기?
        String[] plans = sc.nextLine().split(" ");
        //한줄 입력 받고 공백 기준 자르기
        int x = 1, y = 1;

        //L,R,U,D에 따른 이동방향
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        char[] moveTypes = {'L', 'R', 'U', 'D'};

        //이동 계획을 하나씩 확인
        for(int i = 0; i < plans.length; i++){
            char plan = plans[i].charAt(0);
            //이동 후 좌표 구하기
            int nx = -1, ny = -1;
            for(int j = 0; j < 4; j++){
                if(plan == moveTypes[j]){
                    ny = x + dx[j];
                    ny = y + dy[j]
                }
            }
            //공간 벗어나는 경우
            if(nx < 1 || ny <1 || nx > n || ny > n) continue;;
            //이동수행
            x = nx;
            y = ny;
        }
        System.out.println(x + "" + y);
    }
}
*/
