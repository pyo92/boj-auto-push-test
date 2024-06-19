import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] inputs = new String[N];

        for (int i = 0; i < N; i++) {
            inputs[i] = br.readLine();
        }

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < inputs[0].length(); i++) {
            char c = inputs[0].charAt(i);

            int same = 1;
            for (int j = 1; j < N; j++) {
                if (inputs[j].charAt(i) == c) same++;
            }

            if (same == N) {
                output.append(c);
            } else {
                output.append("?");
            }
        }

        bw.write(output.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
