package Data_Structure;
import java.io.IOException;
import java.util.Scanner;

// BAEKJOON num.2018
public class two_pointer {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 사용 변수 초기화
        int count = 1;
        int start_index = 1;
        int end_index = 1;
        int sum = 1;

        while (end_index != N) {
            if (sum == N) {
                count++;
                end_index++;
                sum = sum + end_index;
            }
            else if (sum > N) {
                sum = sum - start_index;
                start_index++;
            }
            else {
                end_index++;
                sum = sum + end_index;
            }
        }

        System.out.println(count);
        sc.close();
    }
}
