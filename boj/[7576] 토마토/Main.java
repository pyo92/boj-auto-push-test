import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static int[][] map;
    static boolean[][] visited;

    static Queue<int[]> queue = new LinkedList<>();

    static int remain_cnt = 0;
    static int days = 0;

    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] in = br.readLine().split(" ");

        int M = Integer.parseInt(in[0]); //col
        int N = Integer.parseInt(in[1]); //row

        map = new int[N][M];
        visited = new boolean[N][M];

        //map 구성
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");

            for (int j = 0; j < M; j++) {
                int val = Integer.parseInt(row[j]);

                if (val == 0) { //안 익은 토마토
                    remain_cnt++;
                } else if (val == 1) { //익은 토마토
                    queue.add(new int[] {i, j});
                    visited[i][j] = true;
                }

                map[i][j] = val;
            }
        }

        if (remain_cnt == 0) {
            days = 0;
        } else {
            bfs(N, M);

            if (remain_cnt > 0) days = -1;
        }

        out.append(days);

        bw.write(out.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static int[] mr = new int[] {-1, 1, 0, 0};
    static int[] mc = new int[] {0, 0, -1, 1};

    public static void bfs(int limit_row, int limit_column) {
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            //뒤, 앞, 왼, 오
            for (int i = 0; i < 4; i++) {
                int row = poll[0] + mr[i];
                int col = poll[1] + mc[i];

                if ((row >= 0 && row < limit_row) && (col >= 0 && col < limit_column)) { //범위 체크
                    if (map[row][col] == 0) { //안 익은 토마토
                        if (!visited[row][col]) { //미 방문
                            queue.add(new int[] {row, col});

                            map[row][col] = map[poll[0]][poll[1]] + 1;
                            visited[row][col] = true;

                            remain_cnt--;
                        }
                    }
                }
            }

            days = Math.max(days, map[poll[0]][poll[1]] - 1); //익은 토마토 시작 값이 1이므로, -1 해준 값과 비교해 최대값 갱신 처리
        }
    }
}
