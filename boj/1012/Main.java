import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static int[][] map;

    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] in = br.readLine().split(" ");

            int w = Integer.parseInt(in[0]);
            int h = Integer.parseInt(in[1]);
            int c = Integer.parseInt(in[2]);

            map = new int[w][h];

            Queue<int[]> queue = new LinkedList<>();

            for (int j = 0; j < c; j++) {
                String[] xy = br.readLine().split(" ");
                int x = Integer.parseInt(xy[0]);
                int y = Integer.parseInt(xy[1]);

                map[x][y] = 1;

                queue.add(new int[] {x, y});
            }

            int answer = 0;

            while (!queue.isEmpty()) {
                int[] xy = queue.poll();
                int x = xy[0];
                int y = xy[1];

                if (map[x][y] == 1) {
                    answer++;
                    tracking(x, y, w, h);
                }
            }

            out.append(answer);
            out.append('\n');
        }

        bw.write(out.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static int[] mx = new int[] {-1, 1, 0, 0};
    static int[] my = new int[] {0, 0, -1, 1};

    public static void tracking(int x, int y, int w, int h) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] {x, y});
        map[x][y] = 0;

        while (!queue.isEmpty()) {
            int[] xy = queue.poll();
            x = xy[0];
            y = xy[1];

            for (int i = 0; i < 4; i++) {
                int xx = x + mx[i];
                int yy = y + my[i];

                if ((xx >= 0 && xx < w) && (yy >= 0 && yy < h) && map[xx][yy] == 1) {
                    queue.add(new int[]{xx, yy});
                    map[xx][yy] = 0;
                }
            }
        }
    }
}
