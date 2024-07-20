import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static int[][] costs;

    static List<int[]>[] edges;

    static PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v[1])); //cost 오름차순 정렬

    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]); //정점 수
        int M = Integer.parseInt(in[1]); //간선 수
        int X = Integer.parseInt(in[2]); //목적지

        //각 정점에서 다른 정점으로 가는데 소요되는 시간 배열 초기화
        costs = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                costs[i][j] = Integer.MAX_VALUE;
            }
        }

        //모든 간선 리스트 초기화
        edges = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            in = br.readLine().split(" ");
            int from = Integer.parseInt(in[0]);
            int to = Integer.parseInt(in[1]);
            int cost = Integer.parseInt(in[2]);

            edges[from].add(new int[] {to, cost});
        }

        //모든 정점에서 다른 모든 정점까지 dijkstra 수행
        for (int i = 1; i <= N; i++) {
            //출발지 self 최소 비용 0 확정 처리
            costs[i][i] = 0;
            pq.add(new int[] {i, costs[i][i]});

            //priority queue 소진 시까지 반복
            while (!pq.isEmpty()) {
                int[] poll = pq.poll();
                int to = poll[0];
                int cost = poll[1];

                if (cost > costs[i][to]) continue; //꺼낸 cost 가 기존보다 더 크면 가치가 없으므로, skip

                //꺼낸 정점에서 출발할 수 있는 모든 간선에 대해 최소 비용 갱신
                for (int[] e : edges[to]) {
                    int e_to = e[0];
                    int e_cost = e[1];

                    if (costs[i][e_to] > costs[i][to] + e_cost) {
                        costs[i][e_to] = costs[i][to] + e_cost;
                        pq.add(new int[] {e_to, costs[i][e_to]});
                    }
                }
            }
        }

        int max = Integer.MIN_VALUE;

        //dijkstra 완료 후, 목적지(X) 를 제외한 나머지 정점에서 목적지를 경유해 다시 출발지로 돌아오는 비용 중 max 찾기
        for (int i = 1; i <= N; i++) {
            if (i == X) continue;

            max = Math.max(max, costs[i][X] + costs[X][i]);
        }

        out.append(max);

        bw.write(out.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
