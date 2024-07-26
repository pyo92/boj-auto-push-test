import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] in = new String[3];

        int next = 0;

        for (int i = 0; i < 3; i++) {
            in[i] = br.readLine();

            if (in[i].charAt(0) < 65) { //숫자인 입력이 들어온 경우
                next = Integer.parseInt(in[i]) + (3 - i);
            }
        }

        if (next % 15 == 0) {
            out.append("FizzBuzz");
        } else if (next % 3 == 0) {
            out.append("Fizz");
        } else if (next % 5 == 0) {
            out.append("Buzz");
        } else {
            out.append(next);
        }

        bw.write(out.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
