import java.io.IOException;
import java.util.Scanner;

// BAEKJOON num.10986
public class remain_add {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // N = 수열의 개수, M = 나누어 떨어져야 하는 수
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 합 배열
        long[] S = new long[N];
        // 같은 나머지의 인덱스를 카운트하는 배열
        long[] C = new long[M];
        // 결과값
        long answer = 0;

        S[0] = sc.nextInt();

        // 수열 합 배열 만들기
        for (int i = 1; i < N; i++) {
            S[i] = S[i-1] + sc.nextInt();
        }

        
        for (int i = 0; i < N; i++) {
            // 합 배열의 모든 값에 나누기 연산 수행
            int remainder = (int)(S[i] % M);
            // 0~i까지의 구간 합 자체가 0일 때 결과값 더하기
            if (remainder == 0) answer++;
            // 나머지가 같은 인덱스 개수 카운팅하기
            C[remainder]++;
        }

        for (int i = 0; i < M; i++) {
            if (C[i] > 1) {
                // 나머지가 같은 인덱스 중 2개를 뽑는 경우의 수 더하기
                answer = answer + (C[i] * (C[i]-1) / 2);
            }
        }

        System.out.println(answer);
        sc.close();
    }
}
