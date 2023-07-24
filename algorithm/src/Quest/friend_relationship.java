package Quest;

import java.util.ArrayList;
import java.util.Scanner;

// BAEKJOON num.13023
public class friend_relationship {
    static boolean visited[];
    static ArrayList<Integer>[] A;
    static boolean arrive;
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int N;
        int M;
        arrive = false;

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        A = new ArrayList[N];
        visited = new boolean[N];

        // -- Initialize -> ArrayList(A) Contiguous List --
        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<Integer>();
        }

        // -- Store -> 'Graph Data(S, E)'' in Adjacency List --
        for (int i = 0; i < M; i++) {
            int S = sc.nextInt();
            int E = sc.nextInt();
            A[S].add(E);
            A[E].add(S);
        }

        for (int i = 0; i < N; i++) {
            // Start -> depth "1"
            DFS(i, 1);

            if (arrive) {
                break;
            }
        }

        if (arrive) {
            System.out.println("1");
        }
        else {
            System.out.println("0");
        }

        sc.close();
    }

    public static void DFS(int now, int depth) {
        // depth "5" -> END
        if (depth == 5 || arrive) {
            arrive = true;
            return;
        }

        // Store -> 'Current Node visits' to Current Array
        visited[now] = true;

        // -- DFS -> 'Unquestioned Node' of the Current Node's Connection Node --
        for (int i : A[now]) {
            if (!visited[i]) {
                // -- Recursive Call -> "dethp + 1" --
                DFS(i, depth+1);
            }
        }

        visited[now] = false;
    }
}
