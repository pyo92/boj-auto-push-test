import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] in = br.readLine().split(" ");
            int H = Integer.parseInt(in[0]); //층 수
            int W = Integer.parseInt(in[1]); //층별 방 개수
            int N = Integer.parseInt(in[2]); //사람 index

            int floor = N % H;
            if (floor == 0) floor = H;
            out.append(floor);

            int ho = (int) Math.ceil((double) N / H);
            if (ho < 10) out.append('0');
            out.append(ho);
            out.append('\n');
        }

        bw.write(out.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
