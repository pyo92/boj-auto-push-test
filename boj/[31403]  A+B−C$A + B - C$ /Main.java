import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int AB = Integer.parseInt(String.valueOf(A) + B);

        out.append(A + B - C);
        out.append('\n');
        out.append(AB - C);

        bw.write(out.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
