import java.util.*;

// BAEKJOON num.11047
public class coin_num {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // coin num
        int K = sc.nextInt();  // amount

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int count = 0;
        // high value coin -> least count
        for (int i = N-1; i >= 0; i--) {
            if (A[i] <= K) {
                // value _ current coin -> less & equal to K => add composition
                // + Update K == remaining amount after using the current coin
                count += (K / A[i]);
                K = K % A[i];
            }
        }

        System.out.println(count);
        sc.close();
    }
}
