package popcorn;

// This is a solution that does NOT work, only the
import java.util.Scanner;

public class Popcorn {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        long n = in.nextLong() / 4; 
        long totalBags = 2 * n * (n - 1) + 4;

        System.out.println(totalBags);
    }
}