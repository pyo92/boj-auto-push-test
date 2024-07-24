import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static int[][] T;

    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        T = new int[n][n];
        T[0][0] = Integer.parseInt(br.readLine());

        for (int i = 1; i < n; i++) {
            String[] in = br.readLine().split(" ");
            for (int j = 0; j < in.length; j++) {
                int num = Integer.parseInt(in[j]);

                //왼쪽 위 or 바로 위 숫자와의 합 중 max 값으로 갱신
                int leftUp = j - 1 >= 0 ? T[i - 1][j - 1] : Integer.MIN_VALUE;
                int up = j == i ? Integer.MIN_VALUE : T[i - 1][j];

                T[i][j] = Math.max(leftUp, up) + num;
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, T[n - 1][i]);
        }

        out.append(max);

        bw.write(out.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
