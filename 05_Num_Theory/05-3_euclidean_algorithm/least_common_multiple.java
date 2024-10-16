import java.util.*;

// BAEKJOON num.1934
public class least_common_multiple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 0; i <= t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            // euclidean function -> gcd
            int result = a*b / gcd(a, b);
            System.out.println(result);
        }

        sc.close();
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        // b -> least num / a -> great num
        // == recursive function
        else {
            return gcd(b, a%b);
        }
    }
}
