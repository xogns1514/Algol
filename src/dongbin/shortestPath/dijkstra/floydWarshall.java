package dongbin.shortestPath.dijkstra;
import java.util.*;

public class floydWarshall {
    public static final int INF = (int) 1e9;
    // 노드의 개수 n, 간선의 개수 m
    // 노드의 개수는 최대 500개라고 가정
    public static int n, m;
    //2차원 배열
    public static int[][]graph = new int[501][501];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        //최단 거리 테이블을 모두 무한으로 초기화
        for(int i = 0; i < 501; i++){
            Arrays.fill(graph, INF);
        }
        //자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
        for(int a = 1; a <= n; a++){
            for(int b = 1; b <= n; b++){
                if(a==b) graph[a][b] = 0;
            }
        }

        //간선에 대한 입력 받기
        for(int i = 0; i < m; i++){
            //A에서 B로 가는 비용 C
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph[a][b] = c;
        }

        //플로이드 워셜 알고리즘 수행
        for(int k = 1; k <= n; k++){
            for(int a = 1; a <= n; a++){
                for(int b = 1; b <= n; b++){
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }
    }
}
