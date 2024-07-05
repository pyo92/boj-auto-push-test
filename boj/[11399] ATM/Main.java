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

        int[] wait = new int[N];

        for (int i = 0; i < N; i++) {
            wait[i] = Integer.parseInt(in[i]);
        }

        Arrays.sort(wait);

        int answer = 0;

        for (int i = 1; i < N; i++) {
            wait[i] += wait[i - 1];

            answer += wait[i - 1];
        }

        answer += wait[N - 1];

        out.append(answer);

        bw.write(out.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
