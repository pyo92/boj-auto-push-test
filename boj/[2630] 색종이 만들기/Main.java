import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static int[][] map;

    static int white = 0;
    static int blue = 0;

    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();

            for (int j = 0; j < N * 2; j += 2) {
                map[i][j / 2] = row.charAt(j) - 48; //ASCII
            }
        }

        tracking(0, 0, N);

        out.append(white);
        out.append('\n');
        out.append(blue);

        bw.write(out.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static void tracking(int r, int c, int len) {
        if (len == 1) {
            if (map[r][c] == 0) white++;
            else blue++;

            return;
        }

        int colors = isSameColors(r, c, len); //같은 색인지 체크

        if (colors == -1) { //다른 색
            //4등분하여 모두 판별
            tracking(r, c, len / 2);
            tracking(r, c + len / 2, len / 2);
            tracking(r + len / 2, c, len / 2);
            tracking(r + len / 2, c + len / 2, len / 2);

        } else if (colors == 0) { //흰색
            white++;
            return;
        } else { //파란색
            blue++;
            return;
        }
    }
    
    static int isSameColors(int r, int c, int len) {
        int color = map[r][c];

        for (int i = r; i < r + len; i++) {
            for (int j = c; j < c + len; j++) {
                if (color != map[i][j]) return -1;
            }
        }

        return color; //다른 색(-1), 모두 흰색(0), 모두 파란색(1)
    }
}
