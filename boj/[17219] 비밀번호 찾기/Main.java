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
        int M = Integer.parseInt(in[1]);

        Map<String, String> pw = new HashMap<>();

        for (int i = 0; i < N; i++) {
            in = br.readLine().split(" ");
            pw.put(in[0], in[1]);
        }

        for (int i = 0; i < M; i++) {
            out.append(pw.get(br.readLine()));
            out.append('\n');
        }

        bw.write(out.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
