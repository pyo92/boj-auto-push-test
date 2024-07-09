import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static int[] nums;
    static boolean[] visited;

    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] in  = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int M = Integer.parseInt(in[1]);

        in = br.readLine().split(" ");

        nums = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(in[i]);
        }

        Arrays.sort(nums);

        backTracking(0, M);

        bw.write(out.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static List<Integer> list = new ArrayList<>();

    public static void backTracking(int k, int l) {
        if (k == l) {
            for (int i = 0; i < list.size(); i++) {
                if (i > 0) out.append(' ');
                out.append(list.get(i));
            }

            out.append('\n');

            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;

            list.add(nums[i]);
            visited[i] = true;

            backTracking(k + 1, l);

            visited[i] = false;
            list.remove(list.size() - 1);

        }
    }
}
