import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BAEKJOON num.1722
public class permutation_order {
    public static void main(String[] args) throws IOException {
        int N, Q;
        long F[] = new long[21];
        int S[] = new int[21];
        boolean visit[] = new boolean[21];

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        Q = Integer.parseInt(st.nextToken());

        F[0] = 1;
        for (int i = 1; i <= N; i++) {
            F[i] = F[i - 1] * i;
        }

        if (Q == 1) {
            long K = Long.parseLong(st.nextToken());

            for (int i = 1; i <= N; i++) {
                for (int j = 1, cnt = 1; j <= N; j++) {
                    if (visit[j]) {
                        continue;
                    }
                    if (K <= cnt * F[N - i]) {
                        K -= ((cnt - 1) * F[N - i]);
                        S[i] = j;
                        visit[j] = true;
                        break;
                    }
                    cnt++;
                }
            }
            
            for (int i = 1; i <= N; i++) {
                System.out.print(S[i] + " ");
            }

        }
        else {
            long K = 1;

            for (int i = 1; i <= N; i++) {
                S[i] = Integer.parseInt(st.nextToken());
                long cnt = 0;

                for (int j = 1; j < S[i]; j++) {
                    if (visit[j] == false) {
                        cnt++;
                    }
                }

                K += cnt * F[N - i];
                visit[S[i]] = true;
            }

            System.out.println(K);
        }
    }
}