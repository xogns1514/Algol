import java.util.*;
/*
for문 iteration에서 실수 해서 삽질함;;ㅋㅋ test++ 대신 t++를 쓰질 않나. -> 런타임 오류시 한번 체크하기
문제에서 가로 세로 바꿔치기 해버림
 */




//노드
class Node {
    private int x;
    private int y;

    public Node(int x, int y) {
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

public class _1012 {
    // 테스트 케이스 개수
    public static int t;
    // 가로길이, 세로길이, 배추 심어져 있는 위치 개수
    public static int m, n, k;
    // map
    public static int[][] map = new int[51][51];
    public static boolean[][] visited = new boolean[51][51];
    // 상하좌우
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };

    // map initial
    public static void init() {
        for (int i = 0; i < 51; i++) {
            for (int j = 0; j < 51; j++) {
                map[i][j] = 0;
                visited[i][j] = false;
            }
        }
    }

    public static void bfs(int startX, int startY) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(startX, startY));

        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.getX();
            int y = node.getY();
            visited[x][y] = true;

            // 4방향 조사
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위조사
                if (nx < 0 || nx >= m || ny < 0 || ny >= n)
                    continue;
                // 0조사
                if (map[nx][ny] == 0)
                    continue;
                // 처음 방문
                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 테스트 케이스 입력
        t = sc.nextInt();
        // 테스트 실행
        for (int test = 0; test < t; test++) {
            // inint
            init();
            // 배추흰지렁이 마리 수
            int count = 0;
            // 입력
            m = sc.nextInt(); // 가로 y좌표
            n = sc.nextInt(); // 세로 x좌표
            k = sc.nextInt();
            // k개의 배추 좌표 입력
            for (int i = 0; i < k; i++) {
                int bx = sc.nextInt(); // 가로 y
                int by = sc.nextInt(); // 세로 x
                map[bx][by] = 1;
            }

            // map 탐색
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}