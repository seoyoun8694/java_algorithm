package Quest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// BAEKJOON num.1206
public class DFS_BFS {
    static boolean visited[];
    static ArrayList<Integer>[] A;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int start = sc.nextInt();
        A = new ArrayList[N+1];

        // -- Initialize -> ArrayList(A) Contiguous List --
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<Integer>();
        }

        // // -- Store -> 'Graph Data(S, E)'' in Adjacency List --
        for (int i = 0; i < M; i++) {
            int S = sc.nextInt();
            int E = sc.nextInt();
            A[S].add(E);
            A[E].add(S);
        }

        // -- Sort -> Associated each node --
        // !IF! Multiple Nodes that can be Visited
        // -> to visit == 'Lower Number' first
        for (int i = 1; i <= N; i++) {
            Collections.sort(A[i]);
        }

        // Reset -> visited Array + DFS start!
        visited = new boolean[N+1];
        DFS(start);
        System.out.println();

        // Reset -> visited Array + BFS start!
        visited = new boolean[N+1];
        BFS(start);
        System.out.println();

        sc.close();
    }

    public static void DFS(int Node) {
        // print Current Node
        System.out.println(Node + "");
        // Store -> Current Mode visit
        visited[Node] = true;

        // -- DFS -> 'Unquestioned Node' of the Current Node's Connection Node --
        // Recursive Function
        for (int i : A[Node]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }

    public static void BFS(int Node) {
        // Queue -> Insert 'Start Node'
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(Node);
        // Store -> Current Mode visit
        visited[Node] = true;

        while (!queue.isEmpty()) {
            // Get 'Node Data' <- queue
            int now_Node = queue.poll();
            System.out.println(now_Node + "");

            // Among the 'Connected Nodes' of the Current Node,
            // 'Unvisited Nodes' are Inserted -> 'queue'
            // + Stored -> visited Array
            for (int i : A[now_Node]) {
                visited[i] = true;
                queue.add(i);
            }
        }
    }
}
