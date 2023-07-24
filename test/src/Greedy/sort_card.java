package Greedy;

import java.util.*;

// BAEKJOON num.1715
public class sort_card {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int data = sc.nextInt();
            pq.add(data);
        }

        int data1 = 0;
        int data2 = 0;
        int sum = 0;

        // Auto sort -> 2 small decks of cards pick
        // -- !Main funtion! --
        while (pq.size() != 1) {
            data1 = pq.remove();
            data2 = pq.remove();
            // sum = comparisons required to merge two decks of cards num
            sum += data1 + data2;
            pq.add(data1 + data2);
        }
        
        System.out.println(sum);
        sc.close();
    }
}
