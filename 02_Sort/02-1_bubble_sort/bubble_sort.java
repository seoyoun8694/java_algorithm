import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// BAEKJOON num.1377
public class bubble_sort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        mData[] A = new mData[N];

        // A Array Store
        for (int i = 0; i < N; i++) {
            A[i] = new mData(Integer.parseInt(br.readLine()), i);
        }

        // Sort A Array -- O(nlogn) Time Complexity
        Arrays.sort(A);
        int Max = 0;
        
        for (int i = 0; i < N; i++) {
            if (Max < A[i].inedx - i) {
                // Before Sort index - After Sort index
                // -- Store MAX Value --
                Max = A[i].inedx - i;
            }
        }
        System.out.println(Max + 1);
    }
}

class mData implements Comparable<mData> {
    int value;
    int inedx;

    public mData(int value, int index) {
        super();
        this.value = value;
        this.inedx = index;
    }

    @Override
    public int compareTo(mData o) {
        // Comparable Avatar
        // -- Sort Value -> Ascending --
        return this.value - o.value;
    }
}
