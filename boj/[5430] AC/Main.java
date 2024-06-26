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
            String cmd = br.readLine();
            int len = Integer.parseInt(br.readLine());
            int[] tc = new int[len];

            String[] tmp = br.readLine()
                    .replace("[", "")
                    .replace("]", "")
                    .split(",");
            for (int j = 0; j < len; j++) {
                tc[j] = Integer.parseInt(tmp[j]);
            }

            boolean front = true; //true? 0번째 index 부터 / false? 마지막 index 부터
            int f_idx = 0;
            int b_idx = len - 1;
            int cnt = len;

            boolean error = false;

            for (int j = 0; j < cmd.length(); j++) {
                if (cmd.charAt(j) == 'R') {
                    front = !front;

                } else {
                    if (cnt-- == 0) {
                        error = true;
                        break;
                    }

                    if (front) {
                        tc[f_idx++] = 0;
                    } else {
                        tc[b_idx--] = 0;
                    }
                }
            }

            if (error) {
                out.append("error");
                out.append('\n');
            } else {
                out.append('[');

                if (cnt > 0) {
                    if (front) {
                        out.append(tc[f_idx]);
                        for (int j = f_idx + 1; j <= b_idx; j++) {
                            if (tc[j] == 0) continue;

                            out.append(',');
                            out.append(tc[j]);
                        }
                    } else {
                        out.append(tc[b_idx]);
                        for (int j = b_idx - 1; j >= f_idx; j--) {
                            if (tc[j] == 0) continue;

                            out.append(',');
                            out.append(tc[j]);
                        }
                    }
                }

                out.append(']');
                out.append('\n');
            }
        }

        bw.write(out.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
