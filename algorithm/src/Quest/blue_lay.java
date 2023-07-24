package Quest;

import java.util.*;

// BAEKJOON num.1920
public class blue_lay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] A = new int[N];

        int start = 0;
        int end = 0;

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();

            // -- Store 'Max value(lesson)' -> Starting index --
            if (start < A[i]) {
                start = A[i];
            }
            // -- Store 'Sum of All lessons' -> Ending index --
            end = end + A[i];
        }

        while (start <= end) {
            int middle = (start + end) / 2;

            int sum = 0;
            int count = 0;

            // -- !Check -> All lessons Saved - 'middle value'! --
            for (int i = 0; i < N; i++) {
                if (sum + A[i] > middle) {
                    count++;
                    sum = 0;
                }
                sum = sum + A[i];
            }

            // blue_lay + 1
            if (sum != 0) {
                count++;
            }

            if (count > M) {
                start = middle + 1;
            }
            else {
                end = middle - 1;
            }

            System.out.println(count);
        }

        System.out.println(start);
        sc.close();
    }
}
