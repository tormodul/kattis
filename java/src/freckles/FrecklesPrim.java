package freckles;

import java.util.Scanner;
import java.util.Arrays;

public class FrecklesPrim {

    // Function to compute the distance between two points
    public static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        // Iterating through each test case
        while (T-- > 0) {

            int V = sc.nextInt();

            // array to store the coordinates of each vertex 
            double points[][] = new double[V][2];

            // Reading the coordinates of each vertex
            for (int i = 0; i < V; i++) {
                points[i][0] = sc.nextDouble();
                points[i][1] = sc.nextDouble();
            }

            // Array to track vertices that are already in the Minimum Spanning Tree (MST)
            boolean[] inMST = new boolean[V];

            // Key values used to pick the minimum weight edge in the cut
            double[] key = new double[V];
            Arrays.fill(key, Double.MAX_VALUE);
            key[0] = 0; 

            double totalWeight = 0;

            // Prim's algorithm main loop to cover all vertices
            for (int count = 0; count < V; count++) {

                // Finding the vertex with the minimum key value
                int u = -1;
                for (int v = 0; v < V; v++) {
                    if (!inMST[v] && (u == -1 || key[v] < key[u])) {
                        u = v;
                    }
                }
                
                // Adding the found vertex to the MST
                inMST[u] = true;
                totalWeight += key[u]; 

                // For the chosen vertex, check all its adjacent vertices 
                // and update their key values
                for (int v = 0; v < V; v++) {
                    double dist = distance(points[u][0], points[u][1], points[v][0], points[v][1]);
                    if (!inMST[v] && dist < key[v]) {
                        key[v] = dist; 
                    }
                }
            }

            System.out.printf("%.2f\n", totalWeight);

            if (T > 0) System.out.println();
        }

        sc.close();
    }
}