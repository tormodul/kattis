package basicProgramming2;

import java.util.*;

public class BasicProgramming2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int t = scanner.nextInt();

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        if (t == 1) {
            // Use a HashSet to store values already seen
            Set<Integer> set = new HashSet<>();

            for (int x : a) {
                int complement = 7777 - x;

                if (set.contains(complement)) {
                    System.out.println("Yes");
                    return;
                }

                set.add(x);
            }

            System.out.println("No");
        } else if (t == 2) {
            Set<Integer> set = new HashSet<>();

            for (int x : a) {
                if (set.contains(x)) {
                    System.out.println("Contains duplicate");
                    return;
                }
                set.add(x);
            }

            System.out.println("Unique");
        } else if (t == 3) {
            Map<Integer, Integer> count = new HashMap<>();

            for (int x : a) {
                count.put(x, count.getOrDefault(x, 0) + 1);

                if (count.get(x) > n / 2) {
                    System.out.println(x);
                    return;
                }
            }

            System.out.println(-1);
        } else if (t == 4) {
            Arrays.sort(a);

            if (n % 2 == 1) {
                System.out.println(a[n / 2]);
            } else {
                System.out.println(a[n / 2 - 1] + " " + a[n / 2]);
            }
        } else if (t == 5) {
            int[] validNumbers = new int[n];
            int count = 0;
            
            for (int x : a) {
                if (x >= 100 && x <= 999) {
                    validNumbers[count++] = x;
                }
            }
        
            validNumbers = Arrays.copyOf(validNumbers, count);
            Arrays.sort(validNumbers);
        
            for (int i = 0; i < count; i++) {
                System.out.print(validNumbers[i]);
                if (i < count - 1) {
                    System.out.print(" ");
                }
            }
        }
        
        
    }
}
