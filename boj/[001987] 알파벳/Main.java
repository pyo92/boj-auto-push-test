import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static char[][] map;

    static boolean[][] visited;

    static Set<Character> set = new HashSet<>();

    static int moveCnt = 0;

    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] in = br.readLine().split(" ");
        int R = Integer.parseInt(in[0]);
        int C = Integer.parseInt(in[1]);

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            char[] arr = br.readLine().toCharArray();

            for (int j = 0; j < C; j++) {
                map[i][j] = arr[j];
            }
        }

        //좌측 최상단 칸부터 시작
        set.add(map[0][0]);
        visited[0][0] = true;
        moveCnt = 1;

        backTracking(0, 0, 1);

        out.append(moveCnt);

        bw.write(out.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static int[] moveR = new int[] {-1, 1, 0, 0};
    static int[] moveC = new int[] {0, 0, -1, 1};

    public static boolean isMovable(int curR, int curC) {
        boolean moveOk = false;

        for (int i = 0; i < 4; i++) { //up, down, left, right 4가지 방향 어느 곳도 갈 수 없는지 체크
            int newR = curR + moveR[i];
            int newC = curC + moveC[i];

            if ((newR >= 0 && newR < map.length) && (newC >= 0 && newC < map[newR].length)) { //map 범위 내
                if (!visited[newR][newC] && !set.contains(map[newR][newC])) { //미방문 cell && 방문 가능
                    moveOk = true;
                    break;
                }
            }
        }

        return moveOk;
    }

    public static void backTracking(int curR, int curC, int k) {
        if (!isMovable(curR, curC)) { //종료 조건 - 더 이상 움직일 수 없을 때
            moveCnt = Math.max(moveCnt, k);
        }

        for (int i = 0; i < 4; i++) { //up, down, left, right 4가지 방향만 중에서 선택
            int newR = curR + moveR[i];
            int newC = curC + moveC[i];

            if (!((newR >= 0 && newR < map.length) && (newC >= 0 && newC < map[newR].length))) continue; //map 범위 외 skip

            if (visited[newR][newC]) continue; //기방문 skip

            if (set.contains(map[newR][newC])) continue; //방문 불가 skip

            set.add(map[newR][newC]);
            visited[newR][newC] = true;

            backTracking(newR, newC, k + 1);

            visited[newR][newC] = false;
            set.remove(map[newR][newC]);
        }
    }
}
