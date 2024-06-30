import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static List<Integer> list = new ArrayList<>();

    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int K = Integer.parseInt(in[1]) - 1; //index 는 0부터 시작하므로

        for (int i = 0; i < N; i++) {
            list.add(i + 1);
        }

        //최악의 경우
        //1,000 * 1,000 = 1,000,000 이므로 완전히 순회를 해도 가능한 범주
        int idx = K;

        out.append('<');
        out.append(list.remove(idx));

        while (!list.isEmpty()) {
            idx += K;
            idx %= list.size();

            out.append(',');
            out.append(' ');
            out.append(list.remove(idx));
        }

        out.append('>');

        bw.write(out.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
