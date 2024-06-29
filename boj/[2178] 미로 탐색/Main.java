import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static int[][] map;

    static Queue<int[]> queue = new LinkedList<>();

    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] in = br.readLine().split(" ");

        int N = Integer.parseInt(in[0]); //row
        int M = Integer.parseInt(in[1]); //column

        map = new int[N][M];

        //map 구성
        for (int i = 0; i < N; i++) {
            String row = br.readLine();

            for (int j = 0; j < M; j++) {
                int n = row.charAt(j) - 48;

                map[i][j] = n - 1; //벽을 -1, 길을 0으로 세팅
            }
        }

        bfs(N, M);

        out.append(map[N - 1][M - 1]);

        bw.write(out.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static int[] mr = new int[] {-1, 1, 0, 0};
    static int[] mc = new int[] {0, 0, -1, 1};

    public static void bfs(int N, int M) {
        queue.add(new int[] {0, 0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int r = poll[0];
            int c = poll[1];
            map[r][c]++;

            for (int i = 0; i < 4; i++) { //4방향 체크
                int nr = r + mr[i];
                int nc = c + mc[i];

                if ((nr >= 0 && nr < N) && (nc >= 0 && nc < M)) { //map 범위 내부
                    if (map[nr][nc] == 0) { //아직 미방문한 길
                        queue.add(new int[] {nr, nc});
                        //방문처리 시, 이전 cell 의 이동 칸수로 세팅
                        //queue poll -> +1 증가시키면, 누적된 이동 cell 수가 나온다.
                        map[nr][nc] = map[r][c];
                    }
                }
            }
        }
    }
}
