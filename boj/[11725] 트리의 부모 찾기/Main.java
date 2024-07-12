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

        //(중요) List array index 를 자식, List 내부 숫자를 부모로 보고 풀이
        List<Integer>[] lists = new List[N + 1];

        Queue<int[]> confirmedChildren = new LinkedList<>(); //부모(1)가 확정된 자식 노드

        for (int i = 1; i < N; i ++) {
            String[] in = br.readLine().split(" ");
            int n1 = Integer.parseInt(in[0]);
            int n2 = Integer.parseInt(in[1]);

            if (lists[n1] == null) lists[n1] = new ArrayList<>();
            if (lists[n2] == null) lists[n2] = new ArrayList<>();

            //root 노드 인 경우, confirmedChildren 에 등록
            if (n1 == 1) {
                confirmedChildren.add(new int[] {n1, n2});
                lists[n2].add(n1);
            } else if (n2 == 1) {
                confirmedChildren.add(new int[] {n2, n1});
                lists[n1].add(n2);
            } else {
                //모든 노드를 서로 간의 부모 후보로 등록
                lists[n1].add(n2);
                lists[n2].add(n1);
            }
        }

        //부모가 확정된 노드를 대상으로 하위로 순회하여 부모 확정 처리
        while (!confirmedChildren.isEmpty()) {
            int[] poll = confirmedChildren.poll();
            int parent = poll[0];
            int child = poll[1];

            while (lists[child].size() > 1) {
                int candidate = lists[child].remove(0);

                if (candidate == parent) {
                    lists[child].add(candidate);
                } else {
                    confirmedChildren.add(new int[] {child, candidate});
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            out.append(lists[i].remove(0));
            out.append('\n');
        }

        bw.write(out.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
