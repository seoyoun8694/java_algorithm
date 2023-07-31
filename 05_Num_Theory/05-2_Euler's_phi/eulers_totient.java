import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// BAEKJOON num.11689
public class eulers_totient {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long result = n;

        for (long p = 2; p <= Math.sqrt(n); p++) {
            // if -> current value is 'Prime'
            if (n%p == 0) {
                result = result - result / p;
                // remove -> current sub-argument history
                while (n%p == 0) {
                    n /= p;
                }
            }
        }

        // n => last Prime
        if (n > 1) {
            result = result - result / n;
        }
        
        System.out.println(result);
    }
}
