package Quest;

import java.util.*;

// BAEKJOON num.1167
public class tree_diameter {
    static boolean visited[];
    static int[] distance;
    // A = Save Graph Data Adjacent Data
    static ArrayList< Edge>[] A;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        A = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList< Edge>();
        }

        // -- Store Graph Data -. Adjacency List -- 
        for (int i = 0; i < N; i++) {
            int S = sc.nextInt();

            while (true) {
                int E = sc.nextInt();
                if ( E == -1 ) {
                    break;
                }
                int V = sc.nextInt();
        
                A[S].add(new Edge(E, V));
            }
        }

        distance = new int[N+1];
        visited = new boolean[N+1];
        // 1: Random Point -> Start Point
        BFS(1);

        int MAX = 1;
        // -- Set 'Starting point' -> 'Largest Value'(distance Array) --
        for (int i = 2; i <= N; i++) {
            if (distance[MAX] < distance[i]) {
                MAX = i;
            }
        }

        distance = new int[N+1];
        visited = new boolean[N+1];
        // MAX = 'New Start Point'
        BFS(MAX);

        Arrays.sort(distance);
        System.out.println(distance[N]);
        sc.close();
    }

    private static void BFS(int index) {
        // -- LOG 'Start Node Visit' -> Data Structure --
        // LOG 'Visits' -> Current Node(visited Array)
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(index);

        visited[index] = true;

        while (!queue.isEmpty()) {
            // -- Import 'Node Data'(poll) <- queue --
            int now_node = queue.poll();

            for (Edge i : A[now_node]) {
                int e = i.e;
                int v = i.value;

                if (!visited[e]) {
                    visited[e] = true;
                    // Add Data + LOG -> 'visited'
                    // -- 'distance Array' Update --
                    // -> Current Node Distance + Edge's weight
                    queue.add(e);
                    distance[e] = distance[now_node] + v;
                }
            }
        }
    }
}

class Edge {
    int e;  // destination node
    int value;  // Edge's weight
    public Edge(int e, int value) {
        this.e = e;
        this.value = value;
    }
}