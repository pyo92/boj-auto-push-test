import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int K = Integer.parseInt(in[1]);

        int answer = 1;

        for (int i = 2; i <= N; i++) {
            answer *= i;
        }

        for (int i = 2; i <= N - K; i++) {
            answer /= i;
        }

        for (int i = 2; i <= K; i++) {
            answer /= i;
        }

        out.append(answer);

        bw.write(out.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
