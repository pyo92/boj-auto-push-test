import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static int[][] dist;

    static List<int[]>[] edges;

    static PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v[0]));

    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]); //정점의 개수
        int E = Integer.parseInt(in[1]); //간선의 개수

        dist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }

            dist[i][i] = 0;
        }

        edges = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            in = br.readLine().split(" ");
            int from = Integer.parseInt(in[0]);
            int to = Integer.parseInt(in[1]);
            int dist = Integer.parseInt(in[2]);

            edges[from].add(new int[] {to, dist});
            edges[to].add(new int[] {from, dist}); //양방향 간선 처리
        }

        in = br.readLine().split(" ");
        int v1 = Integer.parseInt(in[0]); //반드시 거쳐야하는 정점1
        int v2 = Integer.parseInt(in[1]); //반드시 거쳐야하는 정점2

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(v1);
        q.add(v2);
        q.add(N);

        //(1) dijkstra 를 4개 정점(1, v1, v2, N)에 대해 수행
        while (!q.isEmpty()) {
            int i = q.poll();
            pq.add(new int[] {i, 0}); //시작 정점 최소 거리 0 으로 시작

            while (!pq.isEmpty()) {
                int[] poll = pq.poll();
                int to = poll[0];
                int dst = poll[1];

                if (dist[i][to] < dst) continue; //기존 거리보다 poll 한 거리가 크면, 가치가 없으므로 skip

                for (int[] e : edges[to]) {
                    int to_to = e[0];
                    int to_dst = e[1];

                    if (dist[i][to_to] > dist[i][to] + to_dst) { //to 와 연결된 모든 정점에 대해 최소비용 갱신
                        dist[i][to_to] = dist[i][to] + to_dst;
                        pq.add(new int[] {to_to, dist[i][to_to]});
                    }
                }
            }
        }

        //(2) [s(1) - v1 - v2 - e(N)], [s(1) - v2 - v1 - e(N)] 중에서 최소 거리 판단
        int dist1 = 0;
        if (dist[1][v1] == Integer.MAX_VALUE || dist[v1][v2] == Integer.MAX_VALUE || dist[v2][N] == Integer.MAX_VALUE) {
            dist1 = Integer.MAX_VALUE;
        } else {
            dist1 = dist[1][v1] + dist[v1][v2] + dist[v2][N];
        }

        int dist2 = 0;
        if (dist[1][v2] == Integer.MAX_VALUE || dist[v2][v1] == Integer.MAX_VALUE || dist[v1][N] == Integer.MAX_VALUE) {
            dist2 = Integer.MAX_VALUE;
        } else {
            dist2 = dist[1][v2] + dist[v2][v1] + dist[v1][N];
        }

        if (dist1 == Integer.MAX_VALUE && dist2 == Integer.MAX_VALUE) {
            out.append(-1);
        } else {
            out.append(Math.min(dist1, dist2));
        }

        bw.write(out.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
