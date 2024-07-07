import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static Set<Integer>[] inputs;

    static Queue<Integer> truthPeople = new LinkedList<>(); //진실을 아는 사람 목록

    static int[][] parties = new int[51][51]; //파티 그래프

    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]); //사람 수
        int M = Integer.parseInt(in[1]); //파티 수

        inputs = new Set[M];

        in = br.readLine().split(" ");
        int T = Integer.parseInt(in[0]); //진실을 아는 사람 수

        if (T > 0) { //진실을 아는 사람이 있는 경우
            for (int i = 1; i <= T; i++) {
                truthPeople.add(Integer.parseInt(in[i]));
            }

            //그래프 구성
            for (int i = 0; i < M; i++) {
                in = br.readLine().split(" ");

                inputs[i] = new HashSet<>();

                int cnt = Integer.parseInt(in[0]);

                for (int j = 1; j <= cnt; j++) {
                    int p1 = Integer.parseInt(in[j]);

                    inputs[i].add(p1);

                    for (int k = 1; k <= cnt; k++) {
                        if (j == k) continue;

                        int p2 = Integer.parseInt(in[k]);

                        parties[p1][p2] = 1;
                        parties[p2][p1] = 1;
                    }
                }
            }

            //그래프 탐색
            while (!truthPeople.isEmpty()) {
                Integer poll = truthPeople.poll();
                bfs(poll);
            }

            int truthCnt = 0;

            //미리 저장해두었던 input 을 탐색 - visited 에 하나라도 true 인 사람이 있으면 truthCnt 증가 처리
            for (int i = 0; i < M; i++) {
                for (Integer person : inputs[i]) {
                    if (visited[person]) {
                        truthCnt++;
                        break;
                    }
                }
            }

            out.append(M - truthCnt);

        } else { //진실을 아는 사람이 없는 경우
            out.append(M);
        }

        bw.write(out.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static boolean[] visited = new boolean[51]; //bfs 방문 처리 & 진실만 말할 수 있는 사람들

    static void bfs(int person) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(person);
        visited[person] = true;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            for (int i = 1; i <= 50; i++) { //같이 파티 참가한 사람 목록 찾기
                if (parties[poll][i] > 0 && !visited[i]) { //같이 파티 참가 & 미방문
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
