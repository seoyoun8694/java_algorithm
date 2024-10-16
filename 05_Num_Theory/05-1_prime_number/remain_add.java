import java.util.*;

// BAEKJOON num.1456
public class remain_add {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long Min = sc.nextLong();
        long Max = sc.nextLong();

        // for -> 10^7(10^14's square)
        long[] A = new long[10000001];
        for (int i = 2; i <+ A.length; i++) {
            A[i] = i;
        }

        // for -> N'square
        for (int i = 2; i <= Math.sqrt(A.length); i++) {
            // Not Primes -> continue
            if (A[i] == 0) {
                continue;
            }
            // -- Multiple Clear --
            for (int j = i+i; j < A.length; j = j+i) {
                A[j] = 0;
            }
        }

        int count = 0;
        for (int i = 2; i < 10000001; i++) {
            if (A[i] != 0) {
                long temp = A[i];
                // Base: `Current Prime's Square < MAX`
                // `* > log around` => Binomial Theorem
                while ((double)A[i] <= (double)Max / (double)temp) {
                    if ((double)A[i] >= (double)Min / (double)temp) {
                        count++;
                    }
                    temp = temp * A[i];
                }
            }
        }

        System.out.println(count);
        sc.close();
    }
}
