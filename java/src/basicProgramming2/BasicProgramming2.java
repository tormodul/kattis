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
            // Case 5: Use counting sort to sort values in the range [100, 999]
            int[] sorted = countingSortInRange(a, 100, 999);

            // Print the sorted values
            for (int i = 0; i < sorted.length; i++) {
                if (i > 0) {
                    System.out.print(" ");
                }
                System.out.print(sorted[i]);
            }
        }

    }

    // Counting sort for values in the range [low, high]
    private static int[] countingSortInRange(int[] arr, int low, int high) {
        int[] count = new int[high - low + 1];

        // Count the occurrences of each value within the specified range
        for (int x : arr) {
            if (x >= low && x <= high) {
                count[x - low]++;
            }
        }

        int index = 0;

        // Determine the number of valid elements within the specified range
        int validCount = 0;
        for (int i = low; i <= high; i++) {
            validCount += count[i - low];
        }

        // Reconstruct the sorted array with the exact size needed
        int[] sorted = new int[validCount];
        for (int i = low; i <= high; i++) {
            while (count[i - low] > 0) {
                sorted[index] = i;
                index++;
                count[i - low]--;
            }
        }

        return sorted;
    }
}
