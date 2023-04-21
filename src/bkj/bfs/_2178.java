package bkj.bfs;

import java.util.*;

class Node{
    private int x;
    private int y;

    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){return this.x;}
    public int getY(){return this.y;}
}

public class _2178{
    //상하좌우 좌표
    public static int dx[] = {-1,1,0,0};
    public static int dy[] = {0,0,-1,1};

    public static int n,m;
    public static int[][] map = new int[101][101];


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //미로 크기 입력
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        //미로 입력
        for(int i = 0; i < n; i++){
            //붙어서 입력받는 경우 유의!! String으로 받은 다음 charAt으로 자른다
            String str = sc.nextLine();
            for(int j = 0; j < m; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        int result = bfs(0,0);
        System.out.println(result);

    }

    public static int bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        //시작 점 큐에 넣음
        q.offer(new Node(x,y));

        //큐가 빌때까지
        while(!q.isEmpty()){
            //큐에서 노드 꺼내옴
            Node node = q.poll();
            //현재 노드의 위치가져옴
            x = node.getX();
            y = node.getY();

            //현재 위치에서 상하좌우 확인
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                //공간내 확인
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                //이동 가능확인
                if(map[nx][ny] == 0) continue;
                //처음 방문 하는 경우에만 기록
                if(map[nx][ny] == 1) {
                    //현재 위치 + 1 거리 기록
                    map[nx][ny] = map[x][y] + 1;
                    q.offer(new Node(nx,ny));
                }
            }
        }
        return map[n-1][m-1];
    }

}