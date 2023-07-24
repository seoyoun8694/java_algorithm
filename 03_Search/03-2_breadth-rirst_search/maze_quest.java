import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BAEKJOON num.2178
public class maze_quest {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int[][] A;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // row
        M = Integer.parseInt(st.nextToken()); // column

        // A & visited Reset
        A = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();

            // LOG -> A(array) [x][y]
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(line.substring(j, j+1));
            }
        }

        BFS(0, 0);
        System.out.println(A[N-1][M-1]);
    }

    public static void BFS(int i, int j) {
        // -- LOG 'Start Node Visit' -> Data Structure --
        // LOG 'Visits' -> Current Node(visited Array)
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { i, j});

        while (!queue.isEmpty()) {
            // -- Import 'Node Data'(poll) <- queue --
            int now[] = queue.poll();
            visited[i][j] = true;

            // -- !Quest -> Up, down, left, right! --
            for (int k = 0; k < 4; i++) {
                int x = now[0] + dx[k];
                int y = now[1] + dx[k];

                // Valid Coordinates
                if (x >= 0 && y >= 0 && x < N && y < M) {
                    // Moveable && Unvisited Node
                    if (A[x][y] != 0 && !visited[x][y]) {
                        // LOG -> 'visited'
                        // -- UPDATE -> A(array)'s depth => Current Node's 'depth+1' --
                        visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] + 1;
                        queue.add(new int[] { x, y});
                    }
                }
            }
        }
    }
}
