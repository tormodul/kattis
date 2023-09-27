package helpACandidate;

import java.util.Scanner;

public class HelpACandidateSolution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine()); 

        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            if (line.equals("P=NP")) {
                System.out.println("skipped");
            } else {
                String[] nums = line.split("\\+");
                System.out.println(Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]));
            }
        }
    }
}

