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
        int A = Integer.parseInt(in[0]);
        int B = Integer.parseInt(in[1]);

        int step = 1; //연산의 최솟값에 1을 더한 값이므로, 1부터 시작

        //B -> A 가 가능한지 체크
        while (B > A) {
            step++;

            //1의 자리 체크
            if (B % 10 == 1) { //1 -> 1의 자리 삭제
                B /= 10;
            } else if ((B % 10) % 2 == 0) { //짝수 -> 나누기 2
                B /= 2;
            } else { //그 외 -> A로 만들 수 없으므로 break
                break;
            }
        }

        out.append(A == B ? step : -1);

        bw.write(out.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
