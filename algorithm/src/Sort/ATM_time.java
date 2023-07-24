package Sort;

import java.io.IOException;
import java.util.Scanner;

// BAEKJOON num.11399
public class ATM_time {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];
        int[] S = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        
        // -- Insert Sort --
        for (int i = 1; i < N; i++) {
            int insert_point = i;
            int insert_value = A[i];

            // -- FIND Insertion Point -> Current(insert_value) Scope --
            for (int j = i-1; j >= 0; j--) {
                if (A[j] < A[i]) {
                    insert_point = j + 1;
                    break;
                }
                if (j == 0) {
                    insert_point = 0;
                }
            }

            // -- Push back -> Insert i --
            for (int j = i-1; j > insert_point; j--) {
                A[j] = A[j-1];
            }

            A[insert_point] = insert_value;
        }

        S[0] = A[0];
        // -- SUM Array --
        for (int i = 0; i < N; i++) {
            S[i] = S[i-1] + A[i];
        }

        // -- SUM Array -> Total Sum --
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum = sum + S[i];
        }

        System.out.println(sum);
        sc.close();
    }
}
