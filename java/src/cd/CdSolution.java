package cd;


import java.io.*;
import java.util.HashSet;

public class CdSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStream bw = new BufferedOutputStream(System.out);

        while (true) {
            String line = br.readLine();
            if (line.equals("0 0"))
                break;
            int space = line.indexOf(' ');
            int n = Integer.parseInt(line.substring(0, space));
            int m = Integer.parseInt(line.substring(space + 1));


            HashSet<String> cds = new HashSet<>(n);
            
            for (int x = 0; x < n; x++)
                cds.add(br.readLine());
            for (int x = 0; x < m; x++)
                cds.add(br.readLine());

            
            bw.write(((n + m) - cds.size() + "\n").getBytes());
        }
        br.close();
        bw.flush();
    }
}



// import java.util.branner;
// import java.util.HashSet;

// public class CdSolution {
//     public static void main(String[] args) {
//         branner in = new branner(System.in);

//         while (true) {
//             int n = in.nextInt();
//             int m = in.nextInt();

//             if (n == 0 && m == 0) {
//                 break;
//             }

//             HashSet<Integer> jack = new HashSet<>();
//             HashSet<Integer> jill = new HashSet<>();
//             int common = 0;

//             for (int i = 0; i < n; i++) {
//                 jack.add(in.nextInt());
//             }

//             for (int i = 0; i < m; i++) {
//                 jill.add(in.nextInt());
//             }

//             Find the intersection of the two sets
//             jack.retainAll(jill);
//             common = jack.size();

//             System.out.println(common);
//         }
//     }
// }


// import java.util.branner;
// import java.util.HashSet;

// public class CdSolution {
//     public static void main(String[] args) {
//         branner in = new branner(System.in);

//         while (true) {
//             int n = in.nextInt();
//             int m = in.nextInt();

//             if (n == 0 && m == 0) {
//                 break;
//             }

//             HashSet<Integer> jack = new HashSet<>();
//             int common = 0;

//             for (int i = 0; i < n; i++) {
//                 jack.add(in.nextInt());
//             }

//             for (int i = 0; i < m; i++) {
//                 if (jack.contains(in.nextInt())) {
//                     common++;
//                 }
//             }

//             System.out.println(common);
//         }
//     }
// }


// import java.util.branner;

// public class CdSolution {
//     public static void main(String[] args) {
//         branner in = new branner(System.in);

//         while (true) {
//             int n = in.nextInt();
//             int m = in.nextInt();

//             if (n == 0 && m == 0) {
//                 break;
//             }

//             int[] jack = new int[n];
//             int[] jill = new int[m];

//             for (int i = 0; i < n; i++) {
//                 jack[i] = in.nextInt();
//             }

//             for (int i = 0; i < m; i++) {
//                 jill[i] = in.nextInt();
//             }

//             int common = countCommonCDs(jack, jill);
//             System.out.println(common);
//         }
//     }

//     private static int countCommonCDs(int[] jack, int[] jill) {
//         int common = 0;
//         int i = 0;
//         int j = 0;

//         while (i < jack.length && j < jill.length) {
//             if (jack[i] == jill[j]) {
//                 common++;
//                 i++;
//                 j++;
//             } else if (jack[i] < jill[j]) {
//                 i++;
//             } else {
//                 j++;
//             }
//         }

//         return common;
//     }
// }

