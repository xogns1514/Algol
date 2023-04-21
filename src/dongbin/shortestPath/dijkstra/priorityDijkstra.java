import java.util.*;

class Node implements Comparable<Node> {
    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex(){
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }

    //거리(비용)가 짧은 것이 높은 우선순위를 가지도록 설정
    @Override
    public int compareTo(Node other){
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}

public class priorityDijkstra {
    public static final int INF = (int) 1e9; //무한
    //노드의 개수(N), 간선의 개수(M), 시작 노드 번호(start)
    //노드의 개수는 최대 100,000개라고 가정
    //
    public static int n, m, start;
    //각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    //최단 거리 테이블 만들기
    public static int[] d = new int[100001];

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        //시작 노드로 가기 위한 최단 경로는 0으로 설정, 큐에 삽입
        pq.offer(new Node(start, 0));
        d[start] = 0;
        while (!pq.isEmpty()) {
            // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
            Node node = pq.poll();
            int dist = node.getDistance(); //현재 노드까지의 비용
            int now = node.getIndex(); //현재 노드
            // 현재 노드가 이미 처리된 적이 있는 노드라면 무시
            if(d[now] < dist) continue;
            for(int i = 0; i < graph.get(now).size(); i++){
                int cost = d[now] + graph.get(now).get(i).getDistance();
                //현재 노드 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
                if(cost < d[graph.get(now).get(i).getIndex()]){
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }
}
