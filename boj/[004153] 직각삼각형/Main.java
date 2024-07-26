import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String in;

        while (!(in = br.readLine()).equals("0 0 0")) {
            String[] split = in.split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            int c = Integer.parseInt(split[2]);

            int max = Math.max(a, Math.max(b, c));

            if (a == max) {
                out.append(a * a - b * b - c * c == 0 ? "right": "wrong");
            } else if (b == max) {
                out.append(b * b - a * a - c * c == 0 ? "right": "wrong");
            } else {
                out.append(c * c - a * a - b * b == 0 ? "right": "wrong");
            }
            out.append('\n');
        }

        bw.write(out.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
