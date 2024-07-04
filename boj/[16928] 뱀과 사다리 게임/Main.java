import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static int[] map = new int[101];

    static int[] move = new int[101];

    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int M = Integer.parseInt(in[1]);

        for (int i = 0; i < N; i++) {
            in = br.readLine().split(" ");
            int from = Integer.parseInt(in[0]);
            int to = Integer.parseInt(in[1]);

            map[from] = to;
        }

        for (int i = 0; i < M; i++) {
            in = br.readLine().split(" ");
            int from = Integer.parseInt(in[0]);
            int to = Integer.parseInt(in[1]);

            map[from] = to;
        }

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> tmp = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            if (map[poll] > 0) { //사다리 or 뱀
                //queue 맨 뒤에 삽입되면 최단거리 계산 시, 오류 발생
                //따라서, 맨 앞에 넣어줄 수 있도록 해서 최단거리 계산에 오류 없도록 한다.
                tmp.add(map[poll]);
                while (!queue.isEmpty()) {
                    tmp.add(queue.poll());
                }

                while (!tmp.isEmpty()) {
                    queue.add(tmp.poll());
                }

                move[map[poll]] = move[poll];
            } else {
                //주사위 1~6 에 대응되는 위치에 움직인 횟수 계산해서 저장
                for (int i = 1; i <= 6; i++) {
                    if (poll + i > 100) continue;

                    if (move[poll + i] > 0) continue;

                    queue.add(poll + i);
                    move[poll + i] = move[poll] + 1;
                }
            }
        }

        out.append(move[100]);

        bw.write(out.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
