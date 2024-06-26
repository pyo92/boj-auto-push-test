import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static Map<String, Integer> mon_s = new HashMap<>();
    static Map<Integer, String> mon_i = new HashMap<>();

    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] in = br.readLine().split(" ");

        int N = Integer.parseInt(in[0]);
        int M = Integer.parseInt(in[1]);

        for (int i = 0; i < N; i++) {
            String mon = br.readLine();
            mon_s.put(mon, i + 1);
            mon_i.put(i + 1, mon);
        }

        for (int i = 0; i < M; i++) {
            String quiz = br.readLine();

            if (quiz.charAt(0) < 59) { //숫자
                int key = Integer.parseInt(quiz);
                out.append(mon_i.get(key));
                out.append('\n');

            } else { //알파벳
                out.append(mon_s.get(quiz));
                out.append('\n');
            }
        }


        bw.write(out.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
