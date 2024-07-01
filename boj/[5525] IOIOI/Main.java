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
        int M = Integer.parseInt(br.readLine());

        String S = br.readLine();

        int answer = 0;

        int p_cnt = 0;

        int idx = 0;

        /**
         * 최초에 startsWith 로 `IOI` 비교 시, 시간초과 발생하여 아래와 같이 풀이
         * (1) 문자열 S 를 읽으면서, `IOI...OI` 의 최대한 긴 문자열을 찾는다.
         * (2) P(n) 개수 = P(n-1) 개수 + 1 라는 규칙을 이용해 주어진 N 에 해당하는 문자열 개수를 계산한다.
         */

        while (idx < M) {
            if (S.charAt(idx) == 'I') {
                while (idx + 2 < M && S.charAt(idx + 1) == 'O' && S.charAt(idx + 2) == 'I') {
                    p_cnt++;
                    idx += 2;
                }

                if (p_cnt > 0 && p_cnt >= N) {
                    //P4 = P3 2개 = P2 3개 = P1 4개
                    //P3 = P2 2개 = P1 3개
                    //P2 = P1 2개

                    answer += p_cnt - N + 1;
                }

                p_cnt = 0;
            }

            idx++;
        }

        out.append(answer);

        bw.write(out.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
