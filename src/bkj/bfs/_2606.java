import java.util.*;

public class _2606{
    //컴퓨터 수, 연결 정보 수
    public static int n,m;
    //연결 정보를 담을 2차원 배열
    public static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    //방문 정보 배열
    public static boolean[] visited = new boolean[101];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //컴퓨터 수 입력
        n = sc.nextInt();
        //연결 정보 수 입력
        m = sc.nextInt();
        //리스트 초기화
        for(int i = 0; i <= n; i++){
            arr.add(new ArrayList<Integer>());
        }

        //연결 정보 입력
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        int result = bfs(1);
        System.out.println(result);
    }

    public static int bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        //시작점 삽입
        q.offer(start);
        visited[start] = true;
        //큐 빌때까지
        while(!q.isEmpty()){
            int x = q.poll();
            count ++;
            visited[x] = true;
            // x 와 연결된 컴퓨터들 탐색
            for(int i = 0; i < arr.get(x).size(); i++){
                int y = arr.get(x).get(i);
                if(!visited[y]){
                    visited[y] = true;
                    q.offer(y);
                }
            }
        }
        return count-1;
    }
}