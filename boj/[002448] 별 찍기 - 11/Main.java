import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    //N = 3 일 때, 기본 별찍기 모양을 미리 만들어 둔다.
    static char[][] basic = {
        {' ',' ','*',' ',' '},
        {' ','*',' ','*',' '},
        {'*','*','*','*','*'}
    };

    static char[][] answer;

    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        answer = new char[N][5 * (N / 3) + (N / 3 - 1)];

        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                answer[i][j] = ' ';
            }
        }

        //(1) 꼭대기 기본 모양을 가장 먼저 찍어 놓는다.
        int targetRow = 0;
        int targetCol = answer[0].length / 2 - basic[0].length / 2;

        for (int i = targetRow; i < targetRow + basic.length; i++) {
            for (int j = targetCol; j < targetCol + basic[i].length; j++) {
                answer[i][j] = basic[i - targetRow][j - targetCol];
            }
        }

        //(2) N = 6, 12 ... 순으로 이전 모양을 복사해가면서 늘려나간다.
        int curN = 3; //curRowLen 과 동일
        int curColLen = 5;

        while (curN < N) {
            //복사 대상 (이전 단계) row 범위 = 0 ~ curN
            //column 은 복사를 이전 단계 바로 아래쪽 좌, 우로 2번에 나눠서 한다.
            int sourceStartRow = 0;
            int sourceEndRow = curN;
            int sourceStartCol = targetCol;
            int sourceEndCol = targetCol + curColLen;

            //(2) - 1 하단 좌측 복사
            targetRow = sourceEndRow;
            targetCol = sourceStartCol - 1 - curColLen / 2;

            copy(answer, sourceStartRow, sourceEndRow, sourceStartCol, sourceEndCol, answer, targetRow, targetCol);

            //(2) - 2 하단 우측 복사
            targetCol = sourceEndCol - curColLen / 2;

            copy(answer, sourceStartRow, sourceEndRow, sourceStartCol, sourceEndCol, answer, targetRow, targetCol);

            //(3) 단계 증가 처리
            curN *= 2;
            curColLen = curColLen * 2 + 1;
            targetCol = answer[0].length / 2 - curColLen / 2;
        }

        print();

        bw.write(out.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    public static void copy(char[][] source, int sourceStartRow, int sourceEndRow, int sourceStartCol, int sourceEndCol, char[][] target, int targetStartRow, int targetStartCol) {
        int sourceRowLen = sourceEndRow - sourceStartRow;
        int sourceColLen = sourceEndCol - sourceStartCol;

        int sourceRow = sourceStartRow;
        int sourceCol = sourceStartCol;

        for (int i = targetStartRow; i < targetStartRow + sourceRowLen; i++) {
            for (int j = targetStartCol; j < targetStartCol + sourceColLen; j++) {
                target[i][j] = source[sourceRow][sourceCol++];
            }

            sourceRow++;
            sourceCol = sourceStartCol;
        }
    }

    public static void print() {
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                out.append(answer[i][j]);
            }
            out.append('\n');
        }
    }
}
