package reverseBinaryNumbers;

import java.util.Scanner;

public class ReverseBinaryNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        String binary = "";

        while (n > 0) {
            if (n % 2 == 1) {
                binary = "1" + binary;
            } else {
                binary = "2" + binary;
            }
            n /= 2;
        }

        int answer = 0;
        int power = 1;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                answer = answer + power;
            }
            power = power * 2;
        }

        System.out.println(answer);
    }
}
