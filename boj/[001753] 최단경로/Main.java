import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static int[] dist;

    static List<int[]>[] edges; //index = from / value = int[] {to, weight}

    //min heap = int[] {to, weight} / weight 기준 오름차순
    static PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v[1]));

    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] in = br.readLine().split(" ");
        int V = Integer.parseInt(in[0]); //정점 개수
        int E = Integer.parseInt(in[1]); //간선 개수

        dist = new int[V + 1];
        edges = new List[V + 1];

        for (int i = 1; i <= V; i++) {
            dist[i] = Integer.MAX_VALUE; //weight <= 10 자연수이므로, int 가능
            edges[i] = new ArrayList<>();
        }

        int start = Integer.parseInt(br.readLine()); //시작 정점

        for (int i = 0; i < E; i++) {
            in = br.readLine().split(" ");
            int from = Integer.parseInt(in[0]);
            int to = Integer.parseInt(in[1]);
            int weight = Integer.parseInt(in[2]);

            edges[from].add(new int[] {to, weight});
        }

        //(1) 시작 정점 세팅
        dist[start] = 0;
        pq.add(new int[] {start, dist[start]});

        //(2) priority queue 소진 시까지, 반복
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int to = poll[0];
            int weight = poll[1];

            if (dist[to] < weight) continue; //dist 배열과 비교해서 가중치가 쓸모 있는지 판단하여 skip

            for (int[] e : edges[to]) { //to 정점과 이어지는 간선 모두 최소 가중치 갱신
                int e_to = e[0];
                int e_weight = e[1];

                if (dist[to] + e_weight < dist[e_to]) { //기존 이어진 정점의 가중치와 새롭게 거쳐갈 때의 계산된 가중치를 비교
                    dist[e_to] = dist[to] + e_weight;
                    pq.add(new int[] {e_to, dist[e_to]});
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            out.append(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]);
            out.append('\n');
        }

        bw.write(out.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
