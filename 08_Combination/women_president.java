import java.util.*;

// BAEKJOON num.2755
public class women_president {
    static int T, N, K;
    static int[][] D;

    public static void main(String[] args) throws Exception {
        D = new int[15][15];

        for (int i = 0; i < 15; i++) {
            D[i][1] = 1;
            D[0][i] = i;
        }

        for (int i = 1; i < 15; i++) {
            for (int j = 2; j < 15; j++) {
                D[i][j] = D[i][j - 1] + D[i - 1][j];
            }
        }

        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            K = sc.nextInt();
            N = sc.nextInt();
            System.out.println(D[K][N]);
        }
        sc.close();
    }
}