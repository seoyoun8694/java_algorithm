import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// BAEKJOON num.1707
public class bipartite_graph {
    static ArrayList<Integer>[] A;
    static int[] check;
    static boolean visited[];
    static boolean IsEven;
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int t = 0; t < N; t++) {
            String[] s = br.readLine().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);

            A = new ArrayList[V+1];
            check = new int[V+1];
            visited = new boolean[V+1];
            IsEven = true;

            for (int i = 0; i < E; i++) {
                A[i] = new ArrayList<Integer>();
            }

            for (int i = 0; i < E; i++) {
                s = br.readLine().split(" ");
                int Start = Integer.parseInt(s[0]);
                int End = Integer.parseInt(s[1]);
                A[Start].add(End);
                A[End].add(Start);
            }

            // disldj
        }
    }
}
