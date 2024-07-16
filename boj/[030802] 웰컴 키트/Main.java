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

        int[] size = new int[6];
        for (int i = 0; i < 6; i++) {
            size[i] = Integer.parseInt(in[i]);
        }

        in = br.readLine().split(" ");
        int T = Integer.parseInt(in[0]);
        int P = Integer.parseInt(in[1]);

        int tCnt = 0;
        for (int i = 0; i < 6; i++) {
            tCnt += (int) Math.ceil((double) size[i] / T);
        }

        int pCnt1 = N / P; //묶음
        int pCnt2 = N % P; //낱개

        out.append(tCnt);
        out.append('\n');
        out.append(pCnt1);
        out.append(' ');
        out.append(pCnt2);

        bw.write(out.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
