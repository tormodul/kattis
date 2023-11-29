package includeScoring;





//////////////////////////////////////////////////////////////////////////
//                                                                      //
//                                                                      //
//         This Code does not work in JAVA, see Python solution         //
//                                                                      //
//          With trying som test cases, it seems to be working          //
//            But Kattis does not accept...                             //
//               Data structure differences, Python more fogiving       //
//                                                                      //
//////////////////////////////////////////////////////////////////////////


// import java.util.ArrayList;
// import java.util.Scanner;

// class Contestant {
//     int problemsSolved;
//     int timePenalty;
//     int timeSubmitted;
//     boolean onSite;
//     int endScore; // Add a field to store the score


//     public Contestant(int problemsSolved, int timePenalty, int timeSubmitted, boolean onSite) {
//         this.problemsSolved = problemsSolved;
//         this.timePenalty = timePenalty;
//         this.timeSubmitted = timeSubmitted;
//         this.onSite = onSite;
//     }
// }

// class SameScoreContestant extends Contestant {
//     int newAverageScore;

//     public SameScoreContestant(int problemsSolved, int timePenalty, int timeSubmitted, boolean onSite, int newAverageScore) {
//         super(problemsSolved, timePenalty, timeSubmitted, onSite);
//         this.newAverageScore = newAverageScore;
//     }
// }

// public class IncludeScoring {
//     public static void main(String[] args) {
//         Scanner in = new Scanner(System.in);

//         int n = in.nextInt();

//         // The score is calculated as follows:

//         // I should use a advanced data structure to store the data.
//         ArrayList<Contestant> contestants = new ArrayList<>();
//         ArrayList<Contestant> sameScoreContestants = new ArrayList<>();

//         // Read and store contestant data
//         for (int i = 0; i < n; i++) {
//             int problemsSolved = in.nextInt();
//             int timePenalty = in.nextInt();
//             int timeSubmitted = in.nextInt();
//             boolean onSite = (in.nextInt() == 1);

//             Contestant contestant = new Contestant(problemsSolved, timePenalty, timeSubmitted, onSite);
//             contestants.add(contestant);
//         };

//         // Sort the contestants based on the criteria
//         // 1. Number of problems solved, in descending order
//         // 2. Time penalty, in ascending order
//         // 3. Time submitted, in ascending order
//         // 4. On-site, in descending order

//         // Create the sorting algorithm 
//         // I should use a sorting algorithm that is stable, meaning that it preserves the order of equal elements

//         // Sort the contestants based on the criteria
//         contestants.sort((c1, c2) -> {
//             if (c1.problemsSolved != c2.problemsSolved) {
//                 return Integer.compare(c2.problemsSolved, c1.problemsSolved);
//             } else if (c1.timePenalty != c2.timePenalty) {
//                 return Integer.compare(c1.timePenalty, c2.timePenalty);
//             } else {
//                 return Integer.compare(c1.timeSubmitted, c2.timeSubmitted);
//             }
//         });

//         int endScore = 0;
//         int currentPlace = 0;
//         int sameScoreCount = 0; // Number of contestants with the same score

//         // If there are equal criterias, the score should be (a + b + ... + z) / (a + b + ... + z).length
//         // Meaning that if there are 2 people with the same score, they should get their place score as the average of the two places
//         // If there are 3 people with the same score, they should get their place score as the average of the three places


//         // Iterate through the contestants
//         for (int i = 0; i < contestants.size(); i++) {
//             Contestant contestant = contestants.get(i);

//             // If the current contestant is equal to the previous contestant, then they have the same score
//             if (i > 0 && areEqual(contestant, contestants.get(i - 1))) {
//                 sameScoreCount++;
//             } else {
//                 // If there are equal criteria, calculate the average score for contestants with the same score
//                 if (sameScoreCount > 0) {
//                     // Calculate the total score of contestants with the same score
//                     // The total score needs to handle cases where you have two or more contestants with the same score
//                     // It should use the sum of each place score, which is different for each place
//                     int totalScore = 0;
//                     for (int j = i - sameScoreCount; j < i; j++) {
//                         if (j >= 0) {
//                             int place = j + 1;
//                             totalScore += calculateScore(place, 0);
//                         }
//                     }

//                 // Corrected code
//                 for (int j = i - sameScoreCount; j < i; j++) {
//                     if (j >= 0) {
//                         // Calculate the individual rounded score for each contestant
//                         double individualAvgScore = (double) totalScore / sameScoreCount;
//                         contestants.get(j).endScore = (int) Math.ceil(individualAvgScore);
//                     }
//                 }
                    
//                 }


//                 sameScoreCount = 1; // Reset sameScoreCount for the new score
//                 currentPlace = i + 1;
//                 endScore = calculateScore(currentPlace, endScore);
//                 contestant.endScore = endScore;
//             }
//         }


//         // Where the same score contestants are stored, move them back to the contestants list in the correct order as the original contestants list
//         for (int i = 0; i < sameScoreContestants.size(); i++) {
//             Contestant sameScoreContestant = sameScoreContestants.get(i);
//             Contestant contestant = contestants.get(i);

//             // If the same score contestant is not equal to the original contestant, then move the same score contestant to the correct place
//             if (!areEqual(sameScoreContestant, contestant)) {
//                 // Find the index of the same score contestant in the contestants list
//                 int index = contestants.indexOf(sameScoreContestant);

//                 // Swap the same score contestant with the original contestant
//                 contestants.set(i, sameScoreContestant);
//                 contestants.set(index, contestant);
//             }
//         }

//         for (Contestant c : contestants) {
//             if (c.onSite) {
//                 c.endScore += 1;
//             }
//             System.out.println(c.endScore);
//         }
//     }
        

//     private static int calculateScore (int place, int endScore) {
//             // Calculate the score based on place and other criteria
//             if (place == 1) {
//                 endScore = 100;
//             } else if (place == 2) {
//                 endScore = 75;
//             } else if (place == 3) {
//                 endScore = 60;
//             } else if (place == 4) {
//                 endScore = 50;
//             } else if (place == 5) {
//                 endScore = 45;
//             } else if (place == 6) {
//                 endScore = 40;
//             } else if (place == 7) {
//                 endScore = 36;
//             } else if (place == 8) {
//                 endScore = 32;
//             } else if (place == 9) {
//                 endScore = 29;
//             } else if (place == 10) {
//                 endScore = 26;
//             } else if (place == 11) {
//                 endScore = 24;
//             } else if (place == 12) {
//                 endScore = 22;
//             } else if (place == 13) {
//                 endScore = 20;
//             } else if (place == 14) {
//                 endScore = 18;
//             } else if (place == 15) {
//                 endScore = 16;
//             } else if (place == 16) {
//                 endScore = 15;
//             } else if (place == 17) {
//                 endScore = 14;
//             } else if (place == 18) {
//                 endScore = 13;
//             } else if (place == 19) {
//                 endScore = 12;
//             } else if (place == 20) {
//                 endScore = 11;
//             } else if (place == 21) {
//                 endScore = 10;
//             } else if (place == 22) {
//                 endScore = 9;
//             } else if (place == 23) {
//                 endScore = 8;
//             } else if (place == 24) {
//                 endScore = 7;
//             } else if (place == 25) {
//                 endScore = 6;
//             } else if (place == 26) {
//                 endScore = 5;
//             } else if (place == 27) {
//                 endScore = 4;
//             } else if (place == 28) {
//                 endScore = 3;
//             } else if (place == 29) {
//                 endScore = 2;
//             } else if (place == 30) {
//                 endScore = 1;
//             } else {
//                 endScore = 0;
//             }


//             return endScore;
//     }

//     private static boolean areEqual(Contestant c1, Contestant c2) {
//         return c1.problemsSolved == c2.problemsSolved &&
//                c1.timePenalty == c2.timePenalty &&
//                c1.timeSubmitted == c2.timeSubmitted &&
//                c1.onSite == c2.onSite;
//     }
// }

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Scanner;

// class Contestant {
//     int problemsSolved;
//     int timePenalty;
//     int timeSubmitted;
//     boolean onSite;
//     int endScore;

//     public Contestant(int problemsSolved, int timePenalty, int timeSubmitted, boolean onSite) {
//         this.problemsSolved = problemsSolved;
//         this.timePenalty = timePenalty;
//         this.timeSubmitted = timeSubmitted;
//         this.onSite = onSite;
//         this.endScore = onSite ? 1 : 0; // Initialize with onsite value
//     }

// }

// public class IncludeScoring {
//     public static void main(String[] args) {
//         Scanner in = new Scanner(System.in);

//         int n = in.nextInt();
//         List<Contestant> contestants = new ArrayList<>();

//         for (int i = 0; i < n; i++) {
//             int problemsSolved = in.nextInt();
//             int timePenalty = in.nextInt();
//             int timeSubmitted = in.nextInt();
//             boolean onSite = (in.nextInt() == 1);

//             Contestant contestant = new Contestant(problemsSolved, timePenalty, timeSubmitted, onSite);
//             contestants.add(contestant);
//         }

//         contestants.sort((c1, c2) -> {
//             if (c1.problemsSolved != c2.problemsSolved) {
//                 return Integer.compare(c2.problemsSolved, c1.problemsSolved);
//             }
//             if (c1.timePenalty != c2.timePenalty) {
//                 return Integer.compare(c1.timePenalty, c2.timePenalty); // This is the correct order
//             }
//             if (c1.timeSubmitted != c2.timeSubmitted) {
//                 return Integer.compare(c1.timeSubmitted, c2.timeSubmitted); // This is the correct order
//             }
//             return Boolean.compare(c2.onSite, c1.onSite);
//         });
        
        

//         int endScore = 0;
//         int sameScoreCount = 0;

//         for (int i = 0; i < contestants.size(); i++) {
//             Contestant contestant = contestants.get(i);
//             int currentPlace = i + 1;

//             if (i > 0 && areEqual(contestant, contestants.get(i - 1))) {
//                 sameScoreCount++;
//             } else {
//                 if (sameScoreCount > 0) {
//                     distributeSameScores(contestants, i - sameScoreCount, i);
//                 }

//                 sameScoreCount = 1;
//                 endScore = calculateScore(currentPlace);
//                 contestant.endScore = endScore;
//             }
//         }

//         if (sameScoreCount > 0) {
//             distributeSameScores(contestants, contestants.size() - sameScoreCount, contestants.size());
//         }

//         for (Contestant c : contestants) {
//             if (c.onSite) {
//                 c.endScore += 1;
//             }
//             System.out.println(c.endScore);
//         }
//     }

//     private static void distributeSameScores(List<Contestant> contestants, int startIndex, int endIndex) {
//         int totalScore = 0;
//         int count = endIndex - startIndex;
        
//         for (int i = startIndex; i < endIndex; i++) {
//             totalScore += calculateScore(i + 1);
//         }
        
//         int averageScore = (int) Math.ceil((double) totalScore / count);
        
//         for (int i = startIndex; i < endIndex; i++) {
//             contestants.get(i).endScore = averageScore;
//         }
//     }
    

//     private static final int[] SCORES = {
//         100, 75, 60, 50, 45, 40, 36, 32, 29, 26,
//         24, 22, 20, 18, 16, 15, 14, 13, 12, 11,
//         10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0
//     };
    
//     private static int calculateScore(int place) {
//         return place < SCORES.length ? SCORES[place-1] : 0;
//     }
    

//     private static boolean areEqual(Contestant c1, Contestant c2) {
//         return c1.problemsSolved == c2.problemsSolved &&
//                c1.timePenalty == c2.timePenalty &&
//                c1.timeSubmitted == c2.timeSubmitted &&
//                c1.onSite == c2.onSite;
//     }
// }



import java.util.*;

class Contestant implements Comparable<Contestant> {
    int problemsSolved;
    int timePenalty;
    int timeSubmitted;
    boolean onSite;
    int endScore;

    public Contestant(int problemsSolved, int timePenalty, int timeSubmitted, boolean onSite) {
        this.problemsSolved = problemsSolved;
        this.timePenalty = timePenalty;
        this.timeSubmitted = timeSubmitted;
        this.onSite = onSite;
        this.endScore = onSite ? 1 : 0;
    }

    @Override
    public int compareTo(Contestant o) {
        if (this.problemsSolved != o.problemsSolved) {
            return o.problemsSolved - this.problemsSolved;
        }
        if (this.timePenalty != o.timePenalty) {
            return this.timePenalty - o.timePenalty;
        }
        if (this.timeSubmitted != o.timeSubmitted) {
            return this.timeSubmitted - o.timeSubmitted;
        }
        return Boolean.compare(o.onSite, this.onSite);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contestant o = (Contestant) obj;
        return this.problemsSolved == o.problemsSolved &&
               this.timePenalty == o.timePenalty &&
               this.timeSubmitted == o.timeSubmitted;
    }

    @Override
    public int hashCode() {
        return Objects.hash(problemsSolved, timePenalty, timeSubmitted);
    }
}

public class IncludeScoring {
    private static final int[] SCORES = {
        100, 75, 60, 50, 45, 40, 36, 32, 29, 26,
        24, 22, 20, 18, 16, 15, 14, 13, 12, 11,
        10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0
    };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        List<Contestant> contestants = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            contestants.add(new Contestant(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt() == 1));
        }

        Collections.sort(contestants);

        int rank = 0;
        int i = 0;
        while (i < contestants.size()) {
            Contestant current = contestants.get(i);
            List<Contestant> equalScores = new ArrayList<>();
            equalScores.add(current);

            int j = i + 1;
            while (j < contestants.size() && current.equals(contestants.get(j))) {
                equalScores.add(contestants.get(j));
                j++;
            }

            int totalScore = 0;
            for (int k = rank; k < rank + equalScores.size(); k++) {
                int scoreValue = (k < SCORES.length) ? SCORES[k] : 0;
                totalScore += scoreValue;
            }

            int averageScore = (int) Math.ceil((double) totalScore / equalScores.size());
            for (Contestant c : equalScores) {
                c.endScore += averageScore;
            }

            rank += equalScores.size();
            i = j;
        }

        for (Contestant c : contestants) {
            System.out.println(c.endScore);
        }
    }
}

