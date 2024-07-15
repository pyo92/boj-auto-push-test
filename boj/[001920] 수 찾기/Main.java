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

        Set<Integer> set = new HashSet<>();

        String[] in = br.readLine().split(" ");
        for (String s : in) {
            set.add(Integer.parseInt(s));
        }

        int M = Integer.parseInt(br.readLine());

        in = br.readLine().split(" ");
        for (String s : in) {
            if (set.contains(Integer.parseInt(s))) {
                out.append('1');
            } else {
                out.append('0');
            }

            out.append('\n');
        }

        bw.write(out.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
