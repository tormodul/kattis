package recount;

import java.util.*;

public class Recount {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, Integer> counts = new HashMap<>();
        String leadCandidate = "";
        int maxVotes = 0;
        boolean runoff = false;

        while (true) {
            String candidate = in.nextLine();
            if (candidate.equals("***")) {
                break;
            }

            counts.put(candidate, counts.getOrDefault(candidate, 0) + 1);
            int candidateVotes = counts.get(candidate);

            if (candidateVotes > maxVotes) {
                maxVotes = candidateVotes;
                leadCandidate = candidate;
                runoff = false;
            } else if (candidateVotes == maxVotes) {
                runoff = true;
            }
        }

        if (runoff) {
            System.out.println("Runoff!");
        } else {
            System.out.println(leadCandidate);
        }

        in.close();
    }
}

// Koden under er feil av en eller annen grunn...

// public class Recount {
//     public static void main(String[] args) {

//     Scanner in = new Scanner(System.in);
//     Map<String, Integer> counts = new HashMap<>();

//     String leadCandidate = "";

//     boolean runoff = false; 
//     for (String candidate=in.nextLine(); !candidate.equals("***"); candidate=in.nextLine()) {
//         if (counts.containsKey(candidate)) {
//             counts.put(candidate, counts.get(candidate) + 1);
//         } else {
//             counts.put(candidate, 1);
//         }
        
//     }

//     for (String candidate : counts.keySet()) {
//         if (leadCandidate.equals("")) {
//             leadCandidate = candidate;
//         } else if (counts.get(candidate) > counts.get(leadCandidate)) {
//             leadCandidate = candidate;
//             runoff = false;
//         } else if (counts.get(candidate) == counts.get(leadCandidate)) {
//             runoff = true;
//         }
//     }

//     if (runoff) System.out.println("Runoff!\n");
//     else System.out.println(leadCandidate);    

//     in.close();
//     }
// }

