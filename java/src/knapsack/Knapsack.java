package knapsack;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Knapsack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int C = scanner.nextInt();
            int n = scanner.nextInt();
            
            int[] values = new int[n];
            int[] weights = new int[n];
            
            for (int i = 0; i < n; i++) {
                values[i] = scanner.nextInt();
                weights[i] = scanner.nextInt();
            }
            
            // The DP array
            int[][] dp = new int[n+1][C+1];
            
            // Fill the DP array
            for (int i = 1; i <= n; i++) {
                for (int w = 0; w <= C; w++) {
                    if (weights[i-1] <= w) {
                        dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-weights[i-1]] + values[i-1]);
                    } else {
                        dp[i][w] = dp[i-1][w];
                    }
                }
            }
            
            // Find the items to take
            ArrayList<Integer> itemsTaken = new ArrayList<>();
            for (int i = n, w = C; i > 0 && w > 0; i--) {
                if (dp[i][w] != dp[i-1][w]) {
                    itemsTaken.add(i - 1);
                    w -= weights[i-1];
                }
            }
            
            // Output the result
            Collections.reverse(itemsTaken); // Reverse to get the original order
            System.out.println(itemsTaken.size());
            for (int index : itemsTaken) {
                System.out.print(index + " ");
            }
            System.out.println();
        }
        
        scanner.close();
    }
}
