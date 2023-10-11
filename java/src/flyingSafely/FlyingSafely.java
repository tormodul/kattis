package flyingSafely;

import java.util.Scanner;

public class FlyingSafely {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int v = scanner.nextInt();
            int e = scanner.nextInt();

            for (int j = 0; j < e; j++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
            }

            System.out.println(v - 1);
        }
    }
}
