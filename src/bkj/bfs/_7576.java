import java.util.*;

/*
문제 상황 -> 처음 입력 받았을 때 익어있는 토마토가 여러개라면 어떻게 해야할까? -> 동시에 진행되어야 한다
동시에 진행처리 어떤식으로? -> map 탐색후 익어있는 토마토를 발견한다면 모두 q에 미리 넣는다
        why? bfs는 1depth => 2depth => 3depth 순차적으로 처리 되기 때문에 depth 넘어갈때마다 count 값을 증가한다
 */





//node
class Node {
    private int x;
    private int y;

    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
}

public class _7576{
    //상자 가로, 세로
    public static int m,n;
    //상자 생성
    public static int [][]map = new int[1001][1001];
    //방문여부
    public static boolean [][]visited = new boolean[1001][1001];
    //상하좌우
    public static int[]dx = {-1,1,0,0};
    public static int[]dy = {0,0,-1,1};
    //bfs를 위한 q
    public static Queue<Node> q = new LinkedList<>();


    //bfs
    public static void bfs(){

        while(!q.isEmpty()){
            Node node = q.poll();
            int x = node.getX();
            int y = node.getY();

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                //범위 학인
                if(nx < 0 || nx >= n || ny < 0|| ny >= m) continue;
                //빈 상자 확인
                if(map[nx][ny] == -1) continue;
                //안익은 토마토 발견
                if(map[nx][ny] == 0){
                    q.offer(new Node(nx,ny));
                    visited[nx][ny] = true;
                    map[nx][ny] = map[x][y] + 1;
                }
            }
        }
    }

    //모두 익지 못하는 상황 체크
    public static boolean checkZero(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 0) return false;
            }
        }
        return true;
    }

    //최댓값 출력(걸리는 일수)
    public static int maxDay(){
        int max = -11;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++)
                if(max < map[i][j]) max = map[i][j];
        }
        return max;
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //가로 세로 입력
        m = sc.nextInt();
        n = sc.nextInt();
        //map 입력
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                map[i][j] = sc.nextInt();
            }
        }

        //map 탐색
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                //토마토 발견시 q에 넣음
                if(map[i][j] == 1){
                    q.offer(new Node(i,j));
                }
            }
        }

        //bfs 실행
        bfs();
        //모두 익은 여부
        boolean check = checkZero();
        //max값
        int result = maxDay();
        //출력
        if(check == true && result >1)
            System.out.println(result - 1);
        else if(check == true && result == 1)
            System.out.println("0");
        else System.out.println("-1");

    }
}