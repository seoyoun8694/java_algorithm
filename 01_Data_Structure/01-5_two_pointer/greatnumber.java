import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// BAEKJOON num.1253
public class greatnumber {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int Result = 0;
        long A[] = new long[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());

        // A 배열에 데이터 저장하기
        for (int i = 1; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        // 배열 정렬
        Arrays.sort(A);

        for (int k = 0; k < N; k++) {
            // 변수 초기화
            long find = A[k];
            int i = 0;
            int j = N-1;
            
            // two pointer 알고리즘
            while (i < j) {
                if (A[i] + A[j] == find) {
                    // i, j모두 k가 아닐 때 결괏값 반영+while문 종료
                    if (i != k && j != k) {
                        Result++;
                        break;
                    }
                    // i, j가 k일때
                    else if (i == k) {
                        i++;
                    }
                    else if (j == k) {
                        j--;
                    }
                }

                else if (A[i] + A[j] < find) {
                    i++;
                }

                else {
                    j--;
                }
            }
        }

        System.out.println(Result);
        bf.close();
    }
}
