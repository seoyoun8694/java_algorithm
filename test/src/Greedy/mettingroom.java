package Greedy;

import java.util.*;

// BAEKJOON num.1931
public class mettingroom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // [Start time] [End time]
        int[][] A = new int[N][2];
        for (int i = 0; i < N; i++) {
            A[i][0] = sc.nextInt();
            A[i][1] = sc.nextInt();
        }

        Arrays.sort(A, new Comparator<int[]>() {
            @Override
            public int compare(int[] S, int[] E) {
                // -- End Time == Start Time --
                // => Sort -> Start Time
                if (S[1] == E[1]) {
                    return S[0] - E[0];
                }
                // Sort -> End Time
                return S[1] - E[1];
            }
        });

        int count = 0;
        int end = -1;
        for (int i = 0; i < N; i++) {
            // -- Front metting 'End time' < 'Start time' metting --
            // (Non-overlapping next meeting)
            if (A[i][0] >= end) {
                // Update end time _ present metting end time
                end = A[i][1];
                // progressable metting +1
                count++;
            }
        }
        
        System.out.println(count);
        sc.close();
    }
}
