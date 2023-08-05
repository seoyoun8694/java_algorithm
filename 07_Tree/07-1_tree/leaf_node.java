import java.util.*;

// BAEKJOON num.1068
public class leaf_node {
    static ArrayList<Integer>[] tree;
    static boolean[] visit;
    static int answer = 0;
    static int deleteNode = 0;

    @SuppressWarnings("unchecked")

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        tree = new ArrayList[N];
        visit = new boolean[N];
        int root = 0;

        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < N; i++) {
            int p = sc.nextInt();

            if (p != -1) {
                tree[i].add(p);
                tree[p].add(i);
            }
            else {
                root = i;
            }
        }

        deleteNode = sc.nextInt();

        if (deleteNode == root) {
            System.out.println(0);
        }
        else {
            DFS(root);
            System.out.println(answer);
        }

        sc.close();
    }

    static void DFS(int number) {
        visit[number] = true;
        int cNode = 0;

        for (int i : tree[number]) {
            if (visit[i] == false && i != deleteNode) {
                cNode++;
                DFS(i);
            }
        }
        
        if (cNode == 0) {
            answer++;
        }
    }
}