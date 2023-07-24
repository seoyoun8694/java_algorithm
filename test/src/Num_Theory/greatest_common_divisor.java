package Num_Theory;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;

// BAEKJOON num.1850
public class greatest_common_divisor {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long a = sc.nextLong();
        long b = sc.nextLong();
        long result = gcd(a, b);

        while (result > 0) {
            bw.write("1");
            result--;
        }

        bw.flush();
        bw.close();
        sc.close();
    }

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        else {
            return gcd(b, a%b);
        }
    }
}
