import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static int[] nums;

    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        nums = new int[N];

        String[] in = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(in[i]);
        }

        int[] dp = new int[N];

        dp[0] = 1;

        int maxSeqCnt = 1; //수열의 최대 길이

        //수열의 크기 최대 1,000 이므로, 이중 loop 로 찾아도 시간복잡도로 시간 초과의 발생 가능성은 없다.

        for (int i = 1; i < N; i++) {
            int maxPrevSeqCnt = 0; //이전 수열까지의 최대 길이
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) { //현재 숫자보다 작은 숫자에 한해서 최대 길이를 찾는다. (증가하는 수열)
                    maxPrevSeqCnt = Math.max(maxPrevSeqCnt, dp[j]);
                }
            }

            dp[i] = maxPrevSeqCnt + 1; //이전 수열까지의 최대 길이 + 1

            maxSeqCnt = Math.max(maxSeqCnt, dp[i]); //최대 길이 update
        }

        out.append(maxSeqCnt);

        bw.write(out.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
