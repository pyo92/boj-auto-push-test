import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static int[] costs;
    static List<int[]>[] edges;

    static PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(c -> c[1])); //int[] {to, cost}

    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); //도시 개수
        int M = Integer.parseInt(br.readLine()); //버스 개수

        costs = new int[N + 1];
        edges = new List[N + 1]; //List index = from / int[] {to, cost}

        //(1) 결과 배열 초기화 (MAX_VALUE)
        for (int i = 0; i <= N; i++) {
            costs[i] = Integer.MAX_VALUE;
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] in = br.readLine().split(" ");
            int from = Integer.parseInt(in[0]);
            int to = Integer.parseInt(in[1]);
            int cost = Integer.parseInt(in[2]); //cost >= 0 이므로 dijkstra 가능

            edges[from].add(new int[] {to, cost});
        }

        String[] in = br.readLine().split(" ");
        int start = Integer.parseInt(in[0]);
        int end = Integer.parseInt(in[1]);

        //(2) 시작점에 대한 정보 기록 & 결과 배열 갱신
        costs[start] = 0;
        pq.add(new int[]{start, costs[start]});

        //(3) priority queue 소진 시까지 반복
        while (!pq.isEmpty()) {
            int[] poll = pq.poll(); //최소 cost poll
            int to = poll[0];
            int cost = poll[1];

            if (costs[to] < cost) continue; //기존 cost 와 비교해서 가치 있는지 체크

            for (int[] e : edges[to]) { //to 로부터 가능한 모든 간선에 대해 최소 cost 갱신
                int e_to = e[0];
                int e_cost = e[1];

                if (costs[to] + e_cost < costs[e_to]) {
                    costs[e_to] = costs[to] + e_cost;
                    pq.add(new int[]{e_to, costs[e_to]});
                }
            }
        }

        out.append(costs[end]);

        bw.write(out.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
