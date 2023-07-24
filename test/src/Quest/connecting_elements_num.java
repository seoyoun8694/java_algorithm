package Quest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// BAEKJOON num.11724
public class connecting_elements_num {
    static ArrayList<Integer>[] A;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        A = new ArrayList[n+1];
        visited = new boolean[n+1];

        // -- Adjacency List(A) Initialization --
        for (int i = 1; i < n+1; i++) {
            A[i] = new ArrayList<Integer>();
        }

        // -- Store Graph Data(s, e) -> Adjacency List(A) --
        // -> !Di-Directional Edge!
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }

        // for -> No 'Unvisited Nodes'
        int count = 0;
        for (int i = 1; i < n+1; i++) {
            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }

    static void DFS(int v) {
        if (visited[v]) {
            return;
        }

        // Current Node Visit Store
        visited[v] = true;
        
        // -- Executing DFS -> 'Non-Visited Node' --
        // Among Connected Nodes of the Current Node
        // -> Recursive Function
        for (int i : A[v]) {
            if (visited[i] == false) {
                DFS(i);
            }
        }
    }
}
