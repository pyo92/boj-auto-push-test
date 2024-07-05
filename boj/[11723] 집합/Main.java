import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());

        int[] set = new int[21];

        for (int i = 0; i < M; i++) {
            String[] in = br.readLine().split(" ");

            String cmd = in[0];
            int x = 0;

            if (in.length > 1) {
                x = Integer.parseInt(in[1]);
            }

            switch (cmd) {
                case "add":
                    set[x] = Math.max(set[x], 1);
                    break;
                case "remove":
                    set[x] = Math.min(set[x], 0);
                    break;
                case "check":
                    out.append(set[x]);
                    out.append('\n');
                    break;
                case "toggle":
                    set[x] = set[x] > 0 ? 0 : 1;
                    break;
                case "all":
                    for (int j = 1; j <= 20; j++) {
                        set[j] = 1;
                    }
                    break;
                case "empty":
                    for (int j = 1; j <= 20; j++) {
                        set[j] = 0;
                    }
                    break;
            }
        }

        bw.write(out.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
