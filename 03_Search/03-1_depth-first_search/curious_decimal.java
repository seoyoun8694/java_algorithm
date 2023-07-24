import java.io.IOException;
import java.util.Scanner;

// BAEKJOON num.2023
public class curious_decimal {
    static int N;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        // Decimal -> 2, 3, 5, 7
        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);

        sc.close();
    }

    static void DFS(int num, int jarisu) {
        if (jarisu == N) {
            // -- Print Decimal --
            if (isPrime(num)) {
                System.out.println(num);
            }
            return;
        }
        
        for (int i = 1; i < 10; i++) {
            // -- Even Number -> continue --
            if (i % 2 == 0) {
                continue;
            }
            // -- Decimal -> Recursive Function-- 
            // DFS = jarisu+1, Number*10+Decimal
            if (isPrime(num * 10 + i)) {
                DFS(num * 10 + i, jarisu + 1);
            }
        }
    }

    // -- Finding Primes Funtion --
    static boolean isPrime(int number) {
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}