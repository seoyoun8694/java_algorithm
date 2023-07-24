package Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// BAEKJOON num.2751
public class Sort_num2 {
    public static int[] A, temp;
    // public static long result;
    public static void main(String[] args) throws IOException {
        System.out.print("N: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        temp = new int[N+1];

        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        // -- Start Parallel Sort Function --
        merget_sort(1, N);

        System.out.println("-- Result --");
        for (int i = 1; i <= N; i++) {
            bw.write(A[i] + ", ");
        }
        bw.flush();
        bw.close();
    }

    private static void merget_sort(int s, int e) {
        if (e-s < 1) {
            return;
        }
        int m = s + (e-s) / 2;

        // -- Implemented -> Recursive Function --
        // -> Merget Sort _ (s, m) / (m+1, e)
        merget_sort(s, m);
        merget_sort(m+1, e);
        for (int i = s; i <= e; i++) {
            temp[i] = A[i];
        }

        int k = s;
        int index1 = s;
        int index2 = m+1;

        // -- Logic -> Merge(MIX) Two Groups --
        // == Store 'Smaller Number' -> A Array
        // + index'a' one space -> Move Right
        while (index1 <= m && index2 <= e) {
            if (temp[index1] > temp[index2]) {
                A[k] = temp[index2];
                k++;
                index2++;
            }
            else {
                A[k] = temp[index1];
                k++;
                index1++;
            }
        }

        // -- Clean Up -> Remaining Values(index'a') --
        while (index1 <= m) {
            A[k] = temp[index1];
            k++;
            index1++;
        }
        while (index2 <= e) {
            A[k] = temp[index2];
            k++;
            index2++;
        }
    }
}
