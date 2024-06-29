import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static Set<String> set = new HashSet<>(); //듣

    static List<String> list = new ArrayList<>(); //듣 & 보

    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] in = br.readLine().split(" ");

        int N = Integer.parseInt(in[0]); //듣
        int M = Integer.parseInt(in[1]); //보

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String s = br.readLine();

            if (set.contains(s)) {
                list.add(s);
            }
        }

        out.append(list.size());
        out.append('\n');

        Collections.sort(list);

        for (String s : list) {
            out.append(s);
            out.append('\n');
        }

        bw.write(out.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
