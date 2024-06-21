import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static int[][] cnt = new int[41][2];

    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        cnt[0][0] = 1;
        cnt[0][1] = 0;

        cnt[1][0] = 0;
        cnt[1][1] = 1;

        for (int i = 2; i <= 40; i++) {
            cnt[i][0] = cnt[i - 2][0] + cnt[i - 1][0];
            cnt[i][1] = cnt[i - 2][1] + cnt[i - 1][1];
        }

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            out.append(cnt[n][0]);
            out.append(' ');
            out.append(cnt[n][1]);
            out.append('\n');
        }

        bw.write(out.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
