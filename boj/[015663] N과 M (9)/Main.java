import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static int[] nums;
    static int[] selected;
    static boolean[] visited;

    static Set<String> distinct = new HashSet<>();

    static StringBuilder out = new StringBuilder();
    static StringBuilder tmp = new StringBuilder();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int M = Integer.parseInt(in[1]);

        nums = new int[N];
        visited = new boolean[N];
        selected = new int[M];

        in = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(in[i]);
        }

        //사전 순으로 증가하는 순서로 출력해야 하므로, 정렬
        Arrays.sort(nums);

        printSequence(0, M);

        bw.write(out.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    public static void printSequence(int k, int l) {
        if (k == l) { //종료 조건
            //(1) 수열 생성
            tmp.append(selected[0]);

            for (int i = 1; i < l; i++) {
                tmp.append(' ');
                tmp.append(selected[i]);
            }

            //(2) 수열 중복 체크 하고, 중복이 아닐 때만 out string builder 에 저장
            if (!distinct.contains(tmp.toString())) {
                if (out.length() > 0) out.append('\n');

                out.append(tmp);
            }

            //(3) 수열 중복 방지 set 에 저장
            distinct.add(tmp.toString());

            tmp.setLength(0);

            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue; //이미 고른 숫자는 skip

            selected[k] = nums[i];
            visited[i] = true;

            printSequence(k + 1, l);

            visited[i] = false;
        }
    }
}
