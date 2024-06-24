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
        int r = Integer.parseInt(in[1]);
        int c = Integer.parseInt(in[2]);

        int len = (int) Math.pow(2, N);

        int idx = 0;

        int r_l = 0;
        int r_r = len - 1;

        int c_l = 0;
        int c_r = len - 1;

        while (len >= 2) {
            int r_m = (r_r + r_l) / 2;
            int c_m = (c_r + c_l) / 2;

            int offset = (int) Math.pow((int) (len / 2), 2);

            if (r_m >= r) { //1, 2 사분면
                r_r = r_m;

                if (c_m >= c) { //1 사분면
                    c_r = c_m;
                } else { //2 사분면
                    c_l = c_m + 1;
                    idx += offset;
                }
            } else { //3, 4 사분면
                r_l = r_m + 1;

                if (c_m >= c) { //3 사분면
                    c_r = c_m;
                    idx += offset * 2;
                } else { //4 사분면
                    c_l = c_m + 1;
                    idx += offset * 3;
                }
            }

            len /= 2;
        }

        out.append(idx);

        bw.write(out.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
