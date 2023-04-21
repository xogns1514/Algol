package dongbin.bfd_dfs;
import java.util.*;
//간선의 비용이 모두 같을 때 사용가능
//BFS 이용-> 가까운 노드부터 차례대로 모든 노드를 탐색
//IDEA! 매번 새로운 노드를 방문할때, 그 이전 지점까지의 최단거리 + 1
//마지막 노드위치에 저장된 숫자가 최단거리다!
//Node 클래스를 작성하여 좌표로 활용
class Node {
    private int x;
    private int y;

    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
}

public class 미로탈출 {
    public static int[][] graph = new int[201][201];
    public static int n, m;

    //이동할 네가지 방향 정의(상,하,좌,우)
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};


    public static int bfs(int x,int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        //큐가 빌때 까지
        while (!q.isEmpty()) {
            Node node = q.poll();
            //현재 위치에서 4가지 방향 확인
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                //공간 내 확인
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                //벽인 경우 무시
                if (graph[nx][ny] == 0) continue;
                //해당 노드를 처음 방문하는 경우에만 최단 거리 기록
                if (graph[nx][ny] == 1) {
                    graph[nx][ny] = graph[x][y] + 1;
                    q.offer(new Node(nx, ny));
                }
                return graph[n - 1][m - 1];
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //n 과 m 공백 구분 입력
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        //그래프 입력
        for(int i = 0; i < n; i++){
            String str = sc.nextLine();
            for(int j = 0; j < m; j++){
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        //결과 출력
        System.out.println(bfs(0,0));
    }
}
