import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// BAEKJOON num.11286
public class modulus_hip {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        PriorityQueue<Integer> MyQueue = new PriorityQueue<>((o1, o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);

            // 'Negative' first order -- if Absolute Value Equal --
            if (first_abs == second_abs) {
                return o1 > o2 ? 1 : -1;
            }
            // -- Sort by Absolute Value --
            else {
                return first_abs - second_abs;
            }
        });

        for (int i = 0; i < N; i++) {
            int request = Integer.parseInt(bf.readLine());

            if (request == 0) {
                if (MyQueue.isEmpty()) {
                    System.out.println("0");
                }
                // -- 0 -> Queue's Front Values print --
                else {
                    System.out.println(MyQueue.poll());
                }
            }
            // -- 1-> request(New Data) Add to MyQueue
            else {
                MyQueue.add(request);
            }
        }
    }
}
