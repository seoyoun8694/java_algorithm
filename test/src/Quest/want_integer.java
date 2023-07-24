package Quest;

import java.util.Arrays;
import java.util.Scanner;

// BAEKJOON num.1920
public class want_integer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int [] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Arrays.sort(A);
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            boolean find = false;
            int target = sc.nextInt(); // find Number

            int start = 0;
            int end = A.length - 1;

            while (start <= end) {
                // midle value
                int midi = (start+end) / 2;
                int midV = A[midi];

                // -- Binary Search --
                if (midV > target) {
                    end = midi - 1;
                }
                else if (midV < target) {
                    start = midi + 1;
                }
                else {
                    find = true;
                    break;
                }
            }

            if (find) {
                System.out.println(1);
            }
            else {
                System.out.println(0);
            }
        }
        sc.close();
    }
}
