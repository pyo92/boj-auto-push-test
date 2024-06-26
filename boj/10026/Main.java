import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static char[][] map;
    static boolean[][] v;
    static boolean[][] v_rg;

    static int cnt = 0;
    static int cnt_rg = 0;

    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        v = new boolean[N][N];
        v_rg = new boolean[N][N];

        //map 구성
        for (int i = 0; i < N; i++) {
            String in = br.readLine();

            char[] arr = in.toCharArray();

            for (int j = 0; j < arr.length; j++) {
                map[i][j] = arr[j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!v[i][j]) bfs(i, j, N);
                if (!v_rg[i][j]) bfs_rg(i, j, N);
            }
        }

        out.append(cnt);
        out.append(" ");
        out.append(cnt_rg);

        bw.write(out.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static int[] r = new int[] {-1, 1, 0, 0};
    static int[] c = new int[] {0, 0, -1, 1};

    public static void bfs(int i, int j, int N) { //일반 bfs
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] {i, j});
        v[i][j] = true;

        while (!queue.isEmpty()) {
            int[] rc = queue.poll();
            int color = map[rc[0]][rc[1]];

            for (int k = 0; k < 4; k++) {
                int row = rc[0] + r[k];
                int col = rc[1] + c[k];

                //map 범위 && 미방문 체크
                if ((row >= 0 && row < N) && (col >= 0 && col < N) && !v[row][col]) {
                    //색상 체크 (R, G, B 별도)
                    if (color == map[row][col]) {
                        queue.add(new int[] {row, col});
                        v[row][col] = true;
                    }
                }
            }
        }

        cnt++;
    }

    public static void bfs_rg(int i, int j, int N) { //적록색약 bfs
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] {i, j});
        v_rg[i][j] = true;

        while (!queue.isEmpty()) {
            int[] rc = queue.poll();
            int color = map[rc[0]][rc[1]];

            for (int k = 0; k < 4; k++) {
                int row = rc[0] + r[k];
                int col = rc[1] + c[k];

                //map 범위 && 미방문 체크
                if ((row >= 0 && row < N) && (col >= 0 && col < N) && !v_rg[row][col]) {
                    //색상 체크 (R == G, B)
                    switch (color) {
                        case 'R':
                        case 'G':
                            if (map[row][col] == 'R' || map[row][col] == 'G') {
                                queue.add(new int[] {row, col});
                                v_rg[row][col] = true;
                            }
                            break;
                        default:
                            if (map[row][col] == 'B') {
                                queue.add(new int[] {row, col});
                                v_rg[row][col] = true;
                            }
                            break;
                    }
                }
            }
        }

        cnt_rg++;
    }
}
