package quickEstimate;

import java.util.Scanner;

public class QuickEstimate {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        for (int i=0; i<n; i++) {
            String num = in.next();
            System.out.println(num.length());
        }
    }
}
