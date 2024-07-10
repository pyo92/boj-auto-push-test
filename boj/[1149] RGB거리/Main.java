import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] in = br.readLine().split(" ");

        int[][] dp = new int[N][3];

        dp[0][0] = Integer.parseInt(in[0]);
        dp[0][1] = Integer.parseInt(in[1]);
        dp[0][2] = Integer.parseInt(in[2]);

        for (int i = 1; i < N; i++) {
            in = br.readLine().split(" ");

            int r_cost = Integer.parseInt(in[0]);
            int g_cost = Integer.parseInt(in[1]);
            int b_cost = Integer.parseInt(in[2]);

            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + r_cost;
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + g_cost;
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + b_cost;
        }

        out.append(Math.min(Math.min(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]));

        bw.write(out.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
