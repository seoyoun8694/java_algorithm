package Greedy;

import java.util.*;

// BAEKJOON num.1744
public class Maxnum_add {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusPq = new PriorityQueue<>();

        int one = 0;
        int zero = 0;

        // -- separation store _ >1(plus), 1, 0, <1(minus) --
        for (int i = 0; i < N; i++) {
            int data = sc.nextInt();
            if (data > 1) {
                plusPq.add(data);
            }
            else if (data == 1) {
                one++;
            }
            else if (data == 0) {
                zero++;
            }
            else {
                minusPq.add(data);
            }
        }

        int sum = 0;
        // -- PLUS --
        while (plusPq.size() > 1) {
            // select two number + *(sum)
            int first = plusPq.remove();
            int second = plusPq.remove();
            sum = sum + first * second;
        }

        // data left(plus priority queue) -> +(sum)
        if (!plusPq.isEmpty()) {
            if (zero == 0) {
                sum = sum + plusPq.remove();
            }
        }

        // -- MINUS --
        while (minusPq.size() > 1) {
            // select two number + *(sum)
            int first = minusPq.remove();
            int second = minusPq.remove();
            sum = sum + first * second;
        }

        // data left(minus priority queue) -> +(sum)
        if (!minusPq.isEmpty()) {
            if (zero == 0) {
                sum = sum + minusPq.remove();
            }
        }

        sum = sum + one;
        
        System.out.println(sum);
        sc.close();
    }
}
