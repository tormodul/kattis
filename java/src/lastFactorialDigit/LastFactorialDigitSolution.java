package lastFactorialDigit;
import java.util.*;

public class LastFactorialDigitSolution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        for (int i=0; i<n; i++) {
            int num = in.nextInt();
            int factorial = 1;
            for (int j=1; j<=num; j++) {
                factorial *= j;
            }
            System.out.println(factorial % 10);
        }
    }
}
