import java.util.*;

// BAEKJOON num.1929
public class primes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int N = in.nextInt();

        int[] A = new int[N+1];
        for (int i = 2; i <= N; i++) {
            A[i] = i;
        }

        // for -> N'square
        for (int i =2; i <= Math.sqrt(N); i++) {
            // Not Primes -> continue
            if(A[i] == 0) {
                continue;
            }
            // -- Multiple Clear --
            for (int j = i+i; j <= N; j = j+i) {
                A[j] = 0;
            }
        }

        for (int i = M; i <= N; i++) {
            if (A[i] != 0) {
                System.out.println(A[(int) i]);
            }
        }
        
        in.close();
    }
}
