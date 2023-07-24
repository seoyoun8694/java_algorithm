package Data_Structure;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BAEKJOON num.11659
public class section_add1 {
    public static void main (String[] args) throws IOException {
        System.out.print("데이터의 개수: ");
        BufferedReader bufferedReader_suNo = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer_suNo = new StringTokenizer(bufferedReader_suNo.readLine());

        System.out.print("질문 개수: ");
        BufferedReader bufferedReader_quizNo = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer_quizNo = new StringTokenizer(bufferedReader_quizNo.readLine());

        int suNo = Integer.parseInt(stringTokenizer_suNo.nextToken());
        int quizNo = Integer.parseInt(stringTokenizer_quizNo.nextToken());
        long[] S = new long[suNo + 1];

        System.out.print("데이터 입력: ");
        stringTokenizer_suNo = new StringTokenizer(bufferedReader_suNo.readLine());
        System.out.println("----------------");

        // 입력 받은 데이터 배열의 합 배열(S) 생성
        for (int i = 1; i <= suNo; i++) {
            S[i] = S[i-1] + Integer.parseInt(stringTokenizer_suNo.nextToken());
        }
        
        // 배열 구간 입력받기 _ i번째 수에서 j번째 수까지의 합
        for (int q = 0; q < quizNo; q++) {
            System.out.printf("%d번째 배열 구간 입력: ", q+1);
            stringTokenizer_quizNo = new StringTokenizer(bufferedReader_quizNo.readLine());
            int i = Integer.parseInt(stringTokenizer_quizNo.nextToken());
            int j = Integer.parseInt(stringTokenizer_quizNo.nextToken());
            System.out.printf("%d번째배열 계산 결과: %d \n", q+1, S[j] - S[i-1]);
        }
        System.out.println("----------------");
    }
}