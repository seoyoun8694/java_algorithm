import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// BAEKJOON num.2164
public class CardGame {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> myQueue = new LinkedList<>();

        int N = sc.nextInt();
        for (int i = 0; i <= N; i++) {
            myQueue.add(i);
        }
        while (myQueue.size() > 1) {
            myQueue.poll();
            myQueue.add(myQueue.poll());
        }
        System.out.println(myQueue.poll());
        sc.close();
    }
}
