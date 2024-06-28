import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static StringBuilder infix = new StringBuilder();

    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String in = br.readLine();

        /**
         * 최소가 되게 하려면?
         * (1) - ( 숫자 + ... ) : + 끼리 다 묶는다
         * (2) 나머지 : 안 묶는다
         */

        //중위표기법 - 괄호 묶기

        boolean minus = false;

        for (char c : in.toCharArray()) {
            if (c == '-') {
                if (minus) {
                    infix.append(')');
                    infix.append(c);
                    infix.append('(');

                } else {
                    infix.append(c);
                    infix.append('(');
                    minus = true;
                }
            } else {
                infix.append(c);
            }
        }

        if (minus) {
            infix.append(')');
        }

        //후위표기법 변환
        StringBuilder tmp = new StringBuilder();

        Queue<Object> postfix = new LinkedList<>();
        Stack<Character> op = new Stack<>();

        for (char c : infix.toString().toCharArray()) {
            if (c >= 48 && c < 58) { //숫자
                tmp.append(c);
            } else {
                if (tmp.length() > 0) {
                    int num = Integer.parseInt(tmp.toString());
                    tmp.setLength(0);
                    postfix.add(num);
                }

                switch (c) {
                    case '+':
                    case '-':
                        //현재 연산자보다 우선순위가 같거나 낮은 (+, -) 연산자가 top 에 위치한다면 pop 해서 수식에 반영한다.
                        if (!op.isEmpty()) {
                            char peek = op.peek();
                            if (peek == '+' || peek == '-') {
                                postfix.add(op.pop());
                            }
                        }
                        //현재 연산자를 op 에 넣는다.
                        op.push(c);
                        break;
                    case '(':
                        op.push(c);
                        break;
                    case ')':
                        //( 만날 때 까지 pop
                        char pop = op.pop();
                        while (pop != '(') {
                            postfix.add(pop);
                            pop = op.pop();
                        }
                        break;
                }
            }
        }

        if (tmp.length() > 0) {
            int num = Integer.parseInt(tmp.toString());
            tmp.setLength(0);
            postfix.add(num);
        }

        while (!op.isEmpty()) { //마지막 남은 연산자 모두 pop
            postfix.add(op.pop());
        }

        //후위표기법 계산

        Stack<Integer> num = new Stack<>();

        while (!postfix.isEmpty()) {
            Object poll = postfix.poll();

            if (poll.getClass().equals(Integer.class)) {
                num.add((int) poll);
            } else {
                int num2 = num.pop();
                int num1 = num.pop();

                if ((char) poll == '+') {
                    num.push(num1 + num2);
                } else {
                    num.push(num1 - num2);
                }
            }
        }

        out.append(num.pop());

        bw.write(out.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
