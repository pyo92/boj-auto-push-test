import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static List<int[][]> map = new ArrayList<>();
    static List<boolean[][]> visited = new ArrayList<>();

    static Queue<R> queue = new LinkedList<>();

    static int remain_cnt = 0;
    static int days = 0;

    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] in = br.readLine().split(" ");

        int M = Integer.parseInt(in[0]); //col
        int N = Integer.parseInt(in[1]); //row
        int H = Integer.parseInt(in[2]);

        //map 구성
        for (int i = 0; i < H; i++) {
            map.add(new int[N][M]);
            visited.add(new boolean[N][M]);

            for (int j = 0; j < N; j++) {
                String[] row = br.readLine().split(" ");

                for (int k = 0; k < M; k++) {
                    int val = Integer.parseInt(row[k]);

                    if (val == 0) { //안 익은 토마토
                        remain_cnt++;
                    } else if (val == 1) { //익은 토마토
                        queue.add(new R(j, k, i, val));
                        visited.get(i)[j][k] = true;
                    }

                    map.get(i)[j][k] = val;
                }
            }
        }

        if (remain_cnt == 0) {
            days = 0;
        } else {
            bfs(N, M, H);

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

    public static void bfs(int limit_row, int limit_column, int limit_height) {
        while (!queue.isEmpty()) {
            R poll = queue.poll();

            //뒤, 앞, 왼, 오
            for (int i = 0; i < 4; i++) {
                int row = poll.r + mr[i];
                int col = poll.c + mc[i];
                int height = poll.h;
                int val = poll.v;

                if ((row >= 0 && row < limit_row) && (col >= 0 && col < limit_column)) { //범위 체크
                    if (map.get(height)[row][col] == 0) { //안 익은 토마토
                        if (!visited.get(height)[row][col]) { //미 방문
                            queue.add(new R(row, col, height, val + 1));

                            map.get(height)[row][col] = val + 1;
                            visited.get(height)[row][col] = true;

                            remain_cnt--;
                        }
                    }
                }
            }

            //위
            if (poll.h + 1 < limit_height) { //범위 체크
                if (map.get(poll.h + 1)[poll.r][poll.c] == 0) { //안 익은 토마토
                    if (!visited.get(poll.h + 1)[poll.r][poll.c]) { //미 방문
                        queue.add(new R(poll.r, poll.c, poll.h + 1, poll.v + 1));

                        map.get(poll.h + 1)[poll.r][poll.c] = poll.v + 1;
                        visited.get(poll.h + 1)[poll.r][poll.c] = true;

                        remain_cnt--;
                    }
                }
            }

            //아래
            if (poll.h - 1 >= 0) { //범위 체크
                if (map.get(poll.h - 1)[poll.r][poll.c] == 0) { //안 익은 토마토
                    if (!visited.get(poll.h - 1)[poll.r][poll.c]) { //미 방문
                        queue.add(new R(poll.r, poll.c, poll.h - 1, poll.v + 1));

                        map.get(poll.h - 1)[poll.r][poll.c] = poll.v + 1;
                        visited.get(poll.h - 1)[poll.r][poll.c] = true;

                        remain_cnt--;
                    }
                }
            }

            days = Math.max(days, poll.v - 1); //익은 토마토 시작 값이 1이므로, -1 해준 값과 비교해 최대값 갱신 처리
        }
    }

    static class R {
        int r;
        int c;
        int h;

        int v;

        public R(int r, int c, int h, int v) {
            this.r = r;
            this.c = c;
            this.h = h;
            this.v = v;
        }
    }
}
