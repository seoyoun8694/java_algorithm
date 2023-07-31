import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;

// BAEKJOON num.1033
public class cocktail {
    static ArrayList<cNode>[] A;
    static long lcm;
    static boolean visited[];
    static long D[];
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = sc.nextInt();
        A = new ArrayList[N];
        visited = new boolean[N];
        D = new long[N];
        lcm = 1;

        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<cNode>();
        }

        // store degee information -> adjacency list array(A)
        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();

            A[a].add(new cNode(b, p, q));
            A[b].add(new cNode(a, p, q));
            // update -> least common _ lcm
            lcm *= (p*q / gcd(p, q));
        }

        // store lcm(least common) -> D[0]
        D[0]  = lcm;
        DFS(0);

        // D(DFS using) -> Computing 'greatest common' divisor of values
        long mgcd = D[0];
        for (int i = 1; i < N; i++) {
            mgcd = gcd(mgcd, D[i]);
        }

        // Divide each value in D array -> greatest common divisor & print
        for (int i = 0; i < N; i++) {
            System.out.print(D[i] / mgcd + " ");
        }

        bw.close();
        sc.close();
    }

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        // b -> least num / a -> great num
        // == recursive function
        else {
            return gcd(b, a%b);
        }
    }

    public static void DFS(int Node) {
        // store -> current node visit
        visited[Node] = true;

        // visited nodes(current node) -> unvisited nodes
        for (cNode i : A[Node]) {
            int next = i.getB();

            // next node = current node * ratio(i)
            if (!visited[next]) {
                D[next] = D[Node] * i.getQ() / i.getB();
                DFS(next);
            }
        }
    }
}

class cNode {
    int b;
    int p;
    int q;

    public cNode(int b, int p, int q) {
        super();
        this.b = b;
        this.p = p;
        this.q = q;
    }

    public int getB() {
        return b;
    }
    public int getP() {
        return p;
    }
    public int getQ() {
        return q;
    }
}
