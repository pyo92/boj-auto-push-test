import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static final int MOD = 1234567891;

    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int L = Integer.parseInt(br.readLine());
        String in = br.readLine();

        long sum = 0;

        for (int i = 0; i < L; i++) {
            int ascii = in.charAt(i) - 96; //a = 1 부터 시작하므로 -96 (-97 + 1)

            long pow = 1;
            for (int j = 1; j <= i; j++) {
                pow = (pow * 31) % MOD;
            }

            sum += (ascii * pow) % MOD;
            sum %= MOD;
        }

        out.append(sum);

        bw.write(out.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
