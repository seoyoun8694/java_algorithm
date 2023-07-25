import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// BAEKJOON num.17298
public class NGE {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        // Array of Sequences
        int[] A = new int[n];
        // Array of Answer
        int[] ans = new int[n];
        String[] str = bf.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(str[i]);
        }

        // -- Stack Reset --
        Stack<Integer> myStack = new Stack<>();
        myStack.push(0);

        for (int i = 0; i < n; i++) {
            // Store NGE as Stack A -- Answer Array --
            while (!myStack.isEmpty() && A[myStack.peek()] < A[i]) {
                ans[myStack.pop()] = A[i];
            }
            // i(New Data) Push to Stack
            myStack.push(i);
        }

        while (!myStack.empty()) {
            // Stack index Set '-1' --
            ans[myStack.pop()] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            bw.write(ans[i] + " ");
        }
        bw.write("\n");
        bw.close();
    }
}
