package moscowDream;

import java.util.Scanner;

public class MoscowDreamSolution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt(); 
        int b = in.nextInt();
        int c = in.nextInt();
        int n = in.nextInt();

        if (a >= 1 && b >= 1 && c >= 1 && a + b + c >= n && n >= 3) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
