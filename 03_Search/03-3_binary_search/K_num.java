import java.util.*;

// BAEKJOON num.1300
public class K_num {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        long start = 1, end = K;
        long ans = 0;

        // -- binary search --
        while (start <= end) {
            long middle = (start + end) / 2;
            long cnt = 0;

            // small number count
            // -- !Main logic! --
            for (int i = 1; i <= N; i++)  {
                cnt += Math.min(middle / 1, N);
            }

            if (cnt < K) {
                start = middle + 1;
            }
            // -- Store the medianc(current step) -> ans/end variable --
            else {
                ans = middle;
                end = middle - 1;
            }
        }

        System.out.println(ans);
        sc.close();
    }
}
