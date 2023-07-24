package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BAEKJOON num.11004
public class K_num {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // -- Start QuickSort --
        quickSort(A, 0, N - 1, K - 1);
        System.out.println(A[K - 1]);
    }

    // Arrays A + Start S + End E + K
    public static void quickSort(int[] A, int S, int E, int K) {
        if (S < E) {
            int privot = partition(A, S, E);
            
            // -- Kth Number == privot -> STOP --
            if (privot == K) {
                return;
            }
            // -- Kth Number < privot -> Sort Left Group --
            else if (K < privot) {
                quickSort(A, S, privot - 1, K);
            }
            // -- Kth Number < privot -> Sort Right Group --
            else {
                quickSort(A, privot + 1, E, K);
            }
        }
    }

    // Privot Funtion -> Array A + Start S, End E
    public static int partition(int[] A, int S, int E) {
        // -- Middle Value -> Set Privot --
        int M = (S + E) / 2;
        swap(A, S, M);

        // -- Middle Value -> Store 1th Value --
        int privot = A[S];
        int i = S;
        int j = E;

        while (i < j) {
            // -- J-- -> Less than Privot --
            while (privot < A[j]) {
                j--;
            }
            // -- I++ -> Greater than Privot --
            while (i < j && privot >= A[i]) {
                i++;
            }
            // Exchange(SWAP) -> i & j
            swap(A, i, j);
        }

        // -- 'i == j' Value -> Set Center on both sides --
        A[S] = A[i];
        A[i] = privot;
        return i;
    }

    // Exchange Funtion
    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
