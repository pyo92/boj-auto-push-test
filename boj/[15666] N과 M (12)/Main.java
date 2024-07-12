import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static int[] nums;

    static List<Integer> selected = new ArrayList<>();

    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int M = Integer.parseInt(in[1]);

        in = br.readLine().split(" ");

        Set<Integer> set = new HashSet<>(); //입력 중복값 제거를 위한 set

        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(in[i]));
        }

        nums = new int[set.size()];

        int idx = 0;
        for (int num : set) {
            nums[idx++] = num;
        }

        Arrays.sort(nums); //오름차순 정렬

        backTracking(0, M);

        bw.write(out.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    public static void backTracking(int k, int l) {
        if (k == l) {
            out.append(selected.get(0));

            for (int i = 1; i < k; i++) {
                out.append(' ');
                out.append(selected.get(i));
            }

            out.append('\n');

            return;
        }

        for (int num : nums) {
            if (k > 0 && selected.get(k - 1) > num) continue; //비내림차순이어야 하므로, 선택된 숫자보다 작은 숫자는 skip

            selected.add(num);

            backTracking(k + 1, l);

            selected.remove(k);
        }
    }
}
