import java.util.*;

// BAEKJOON num.1747
public class remain_palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // for -> 10^7(10^14's square)
        int[] A = new int[10000001];
        for (int i = 2; i <= N; i++) {
            A[i] = i;
        }

        // for -> N'square
        for (int i = 2; i <= Math.sqrt(A.length); i++) {
            // Not Primes -> continue
            if (A[i] == 0) {
                continue;
            }
            // -- Multiple Clear --
            for (int j = i+i; j < A.length; j = j+i) {
                A[j] = 0;
            }
        }

        int i = N;
        while (true) {
            // rseult = Primes && Palindrome
            if (A[i] != 0) {
                int result = A[i];
                if (isPalindrome(result)) {
                    System.out.println(result);
                    break;
                }
            }
            i++;
        }
        sc.close();
    }

    // -- !Palindrome funtion! --
    private static boolean isPalindrome(int target) {
        // Integer -> Char Array
        char temp[] = String.valueOf(target).toCharArray();
        int s = 0;
        int e = temp.length - 1;

        while (s < e) {
            if (temp[s] != temp[e]) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }
}
