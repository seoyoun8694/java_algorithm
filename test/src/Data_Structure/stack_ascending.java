package Data_Structure;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

// BAEKJOON num.1874
public class stack_ascending {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        StringBuffer bf = new StringBuffer();
        // Ascending Number
        int num = 1;
        boolean result = true;

        for ( int i = 0; i < A.length; i++) {
            // Number of Current Sequences
            int su = A[i];

            // push() -> until Values ​​are Equal! --
            if (su >= num) {
                while (su >= num) {
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            }
            // pop() -> Extract Sequence Elements! --
            else {
                int n = stack.pop();
                // -- Error --
                // pop() result > Sequence Number
                if(n > su) {
                    System.out.println("NO");
                    result = false;
                    break;
                }
                else {
                    bf.append("-\n");
                }
            }
        }

        if (result) {
            System.out.println(bf.toString());
        }

        sc.close();
    }
}
