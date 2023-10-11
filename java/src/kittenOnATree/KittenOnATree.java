package kittenOnATree;

import java.util.*;

public class KittenOnATree {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<Integer, Integer> parentMap = new HashMap<>();

        Integer catPosition = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        while (true) {
            String[] tokens = scanner.nextLine().split(" ");
            Integer parent = Integer.parseInt(tokens[0]);

            if (parent == -1) {
                break;
            }

            for (int i = 1; i < tokens.length; i++) {
                Integer child = Integer.parseInt(tokens[i]);
                parentMap.put(child, parent);
            }
        }

        // Trace the path from the cat to the root and store it in the stack
        while (catPosition != null) {
            System.out.print(catPosition + " ");
            catPosition = parentMap.get(catPosition);
        }

        scanner.close();
    }
}






        // Scanner scanner = new Scanner(System.in);

        // Map<Integer, Integer> parentMap = new HashMap<>();
        // Stack<Integer> pathToGround = new Stack<>();

        // Integer catPosition = scanner.nextInt();
        // scanner.nextLine(); // Consume the newline character

        // while (true) {
        //     String[] tokens = scanner.nextLine().split(" ");
        //     Integer parent = Integer.parseInt(tokens[0]);

        //     if (parent == -1) {
        //         break;
        //     }

        //     for (int i = 1; i < tokens.length; i++) {
        //         Integer child = Integer.parseInt(tokens[i]);
        //         parentMap.put(child, parent);
        //     }
        // }

        // // Trace the path from the cat to the root and store it in the stack
        // while (catPosition != null) {
        //     pathToGround.push(catPosition);
        //     catPosition = parentMap.get(catPosition);
        // }

        // // Output the path to the ground starting with the branch on which the kitten sits
        // while (!pathToGround.isEmpty()) {
        //     System.out.print(pathToGround.pop() + " ");
        // }

        // scanner.close();

        // Lets try another approach, beacuse the output with the code above is in the wrong order
        // The node of the kitten is always the first node in the output