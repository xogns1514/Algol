package bkj.bfs;
import java.util.*;
public class _1260 {
    public static boolean[] visited = new boolean[1001];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void dfs(int x){
        // 현재 노드 방문 처리
        visited[x] = true;
        System.out.print(x+ " ");
        //현재 노드와 인접한 노드들 방문
        for(int i = 0; i < graph.get(x).size(); i++){
            int y = graph.get(x).get(i);
            if(!visited[y]) dfs(y);
        }
    }

    public static void bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        visited[x] = true;

        while(!q.isEmpty()){
            int a = q.poll();
            System.out.print(a + " ");
            //해당 원소와 연결된 방문되지 않은 노드 삽입
            for(int i = 0; i < graph.get(a).size(); i++){
                int y = graph.get(a).get(i);
                if(!visited[y]) {
                    q.offer(y);
                    visited[y] = true;
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //
        Arrays.fill(visited, false);
        //정점의 개수n, 간선의 개수 m, 탐색 시작 정점 번호 v
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();
        // 그래프 초기화
        for(int i = 0; i < n+1; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        //그래프 정렬!!
        for(int i = 0; i < n+1; i++){
            Collections.sort(graph.get(i));
        }
        dfs(v);
        System.out.println();

        //visited 초기화
        Arrays.fill(visited, false);

        bfs(v);

    }
}
