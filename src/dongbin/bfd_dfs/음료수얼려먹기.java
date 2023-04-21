/*package dongbin.bfd_dfs;
import java.util.*;
public class 음료수얼려먹기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //n,m 입력
        int n = sc.nextInt();
        int m = sc.nextInt();
        //2차원 어레이 입력
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        //visit 배열 생성
        boolean[][] visited = new boolean[n+1][m+1];
        Queue<Integer> q = new LinkedList<>();
        //맵 입력받기
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                int input = sc.nextInt();
                arr.get(i).add(input);
            }
        }
        //bfs?

    }
}*/

//예시답안
//구역별로 dfs,
import java.util.*;

public class 음료수얼려먹기{
    public static int n, m;
    public static int[][] graph = new int[1000][1000];

    //DFS로 특정 노드 방문하고 연결된 모든 노드들도 방문
    public static boolean dfs(int x, int y){
        //주어진 범위를 벗어나는 경우에는 즉시 종료
        if(x <= -1 || x >= n || y <= -1 || y >=m){
            return false;
        }
        //현재 노드를 아직 방문하지 않았다면
        if(graph[x][y] == 0){
            //해당 노드 방문
            graph[x][y] = 1;
            //상하좌우 위치들도 재귀적으로 호출
            dfs(x-1, y);
            dfs(x, y-1);
            dfs(x+1, y);
            dfs(x, y+1);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //n,m 을 공백을 기준으로 구분하여 입력
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine(); //버퍼 지우기

        //2차원 리스트의 맵 정보 입력받기
        for(int i = 0; i < n; i++){
            String str = sc.nextLine();
            for(int j = 0; j < m; j++){
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        //모든 노드에 대해 음료수 채우기
        int result = 0;
        for(int i = 0; i< n; i++){
            for(int j = 0; j< m; j++){
                //현재 위치에서 DFS수행
                if(dfs(i,j)){
                    result += 1;
                }
            }
        }
        System.out.println(result);
    }
}

