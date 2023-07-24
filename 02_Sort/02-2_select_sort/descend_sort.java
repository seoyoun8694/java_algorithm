import java.io.IOException;
import java.util.Scanner;

// BAEKJOON num.1427
public class descend_sort {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int[] A = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            // -- Store -> substring --
            A[i] = Integer.parseInt(str.substring(i, i+1));
        }

        for (int i = 0; i < str.length(); i++) {
            int Max = i;

            for (int j = i+1; j < str.length(); j++) {
                // -- Descend Sort -> MAX --
                if (A[j] > A[Max]) {
                    Max= j;
                }
            }

            // -- Swap --
            if (A[i] < A[Max]) {
                int temp = A[i];
                A[i] = A[Max];
                A[Max] = temp;
            }
        }

        for (int i = 0; i < str.length(); i++) {
            System.out.println(A[i]);
        }

        sc.close();
    }
}
