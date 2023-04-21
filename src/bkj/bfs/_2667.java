import java.util.*;
/*
내가 생각하지 못한 test case -> 10101
                            01010
                            10101
                            01010
                            10101
                           -> 1 자체가 마을인 경우를 counting 하지 못했음
                           예외의 경우로 두어 이웃이 없을 경우 count = 1로 세팅하였다.
 */





class Node{
    private int x;
    private int y;

    public Node(int x,int y){
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

public class _2667{
    //상하좌우
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    //맵 입력받기
    public static int[][] map = new int[26][26];
    //한변 길이
    public static int n;
    //단지 리스트
    public static List<Integer> village = new ArrayList<>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //n입력 받기
        n = sc.nextInt();
        //맵 정보 입력받기
        for(int i = 0; i < n; i++){
            String str = sc.next();
            for(int j = 0; j < n; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        //맵 탐색
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == 1){
                    bfs(i,j);
                }
            }
        }

        //정렬
        Collections.sort(village);
        System.out.println(village.size());
        for(int i : village){
            System.out.println(i);
        }


    }

    public static void bfs(int a, int b){
        Queue<Node> q =  new LinkedList<>();
        int count = 0;
        q.offer(new Node(a,b));

        while(!q.isEmpty()){
            Node node = q.poll();
            int x = node.getX();
            int y = node.getY();

            if(map[x][y] == 0) continue;
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                //범위 체크
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                //0체크
                if(map[nx][ny] == 0) continue;
                //최초 방문일 경우
                if(map[nx][ny] == 1){
                    map[nx][ny] = map[x][y] + 1;
                    q.offer(new Node(nx,ny));
                    count+=1;
                };
            }
        }
        if(count == 0) village.add(1);
        else village.add(count);
    }
}


