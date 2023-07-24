package Greedy;

import java.util.*;

// BAEKJOON num.1541
public class parentheses_placement {
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String example = sc. nextLine();
        String[] str = example.split("-");

        for (int i = 0; i < str.length; i++) {
            int temp = mySum(str[i]);

            // Add only the first value
            if (i == 0) {
                answer = answer + temp;
            }
            // latter part subtracts the added values.
            else {
                answer = answer - temp;
            }
        }
        
        System.out.println(answer);
        sc.close();
    }

    // prosecute funtion - Addition operation(divided groups)
    static int mySum(String a) {
        int sum = 0;
        String temp[] = a.split("[+]");

        for (int i = 0; i < temp.length; i++) {
            sum += Integer.parseInt(temp[i]);
        }

        return sum;
    }
}
