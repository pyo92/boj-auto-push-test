import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;

    static Map<String, String[]> nodes = new HashMap<>();

    static Node root;

    static StringBuilder traversal = new StringBuilder();

    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        //(1) input 저장 -> root(A) 의 자식이 입력 2번째 줄이 아닐 수도 있기 때문에
        for (int i = 0; i < N; i++) {
            String[] in = br.readLine().split(" ");
            nodes.put(in[0], new String[] {in[1], in[2]});
        }

        //(2) tree 구성

        //(2-1) root node
        root = new Node("A");

        //(2-2) 하위 node
        makeChild(root);

        //(3) tree traversal
        preOrder(root);
        out.append(traversal);
        traversal.setLength(0);

        inOrder(root);
        out.append('\n');
        out.append(traversal);
        traversal.setLength(0);

        postOrder(root);
        out.append('\n');
        out.append(traversal);

        bw.write(out.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static void preOrder(Node cur) {
        if (cur == null) return;

        traversal.append(cur.v);
        preOrder(cur.left);
        preOrder(cur.right);
    }

    static void inOrder(Node cur) {
        if (cur == null) return;

        inOrder(cur.left);
        traversal.append(cur.v);
        inOrder(cur.right);
    }

    static void postOrder(Node cur) {
        if (cur == null) return;

        postOrder(cur.left);
        postOrder(cur.right);
        traversal.append(cur.v);
    }

    static void makeChild(Node cur) {
        String[] children = nodes.get(cur.v);

        //left child
        if (!children[0].equals(".")) {
            cur.left = new Node(children[0]);
            makeChild(cur.left);
        }

        //right child
        if (!children[1].equals(".")) {
            cur.right = new Node(children[1]);
            makeChild(cur.right);
        }
    }

    static class Node {
        String v;
        Node left;
        Node right;

        public Node(String v) {
            this.v = v;
        }

        public Node(String v, Node left, Node right) {
            this.v = v;
            this.left = left;
            this.right = right;
        }
    }
}
