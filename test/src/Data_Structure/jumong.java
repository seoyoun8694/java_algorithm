package Data_Structure;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

// BAEKJOON num.1940
public class jumong {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());

        // 자료 배열 저장
        for (int i = 0; i < N; i++) {
            A[i]= Integer.parseInt(st.nextToken());
        }

        // 자료 배열 정렬
        Arrays.sort(A);
        int count = 0;
        int i = 0;
        int j = N-1;

        while (i < j) {
            // 작은 번호 재료 한칸 위로 올리기
            if (A[i] + A[j] < M) {
                i++;
            }
            // 큰 번호 재료 한칸 밑으로 내리기
            else if (A[i] + A[j] > M) {
                j--;
            }
            // 예외 - count 증가, 양쪽 index 각각 변경하기
            else {
                count++;
                i++;
                j--;
            }
        }

        System.out.println(count);
        bf.close();
    }
}
