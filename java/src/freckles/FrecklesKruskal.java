package freckles;

import java.util.Scanner;
import java.util.PriorityQueue;

public class FrecklesKruskal {
    
    // Class to represent an edge in the graph
    static class Edge implements Comparable<Edge> {
        int src, dest;  
        double weight; 

        // Function to compare two edges based on their weight for PriorityQueue sorting
        public int compareTo(Edge compareEdge) {
            return Double.compare(this.weight, compareEdge.weight);
        }
    }

    // Class to represent subsets for union-find
    static class Subset {
        int parent, rank;
    }

    int V;  
    PriorityQueue<Edge> edgeQueue = new PriorityQueue<>();  // PriorityQueue to hold the edges sorted by weight

    FrecklesKruskal(int v) {
        V = v;
    }

    // A function to find set of an element i 
    int find(Subset subsets[], int i) {
        // find root and make root as parent of i
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    // A function that does union of two sets x and y (uses union by rank)
    void union(Subset subsets[], int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        // Attach smaller rank tree under root of higher rank tree
        if (subsets[xroot].rank < subsets[yroot].rank) {
            subsets[xroot].parent = yroot;
        } else if (subsets[xroot].rank > subsets[yroot].rank) {
            subsets[yroot].parent = xroot;
        } else {
            // If ranks are same, then make one as root and increment its rank by one
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    // Main function to construct MST using Kruskal's algorithm
    double kruskalMST() {
        Edge result[] = new Edge[V];  
        int e = 0; 
        double totalWeight = 0.0;  
        Subset subsets[] = new Subset[V];

        // Create V subsets with single elements
        for (int i = 0; i < V; ++i) {
            subsets[i] = new Subset();
            subsets[i].parent = i;
            subsets[i].rank = 0;
        }

        // Keep combining edges until we have a spanning tree
        while (e < V - 1 && !edgeQueue.isEmpty()) {
            Edge next_edge = edgeQueue.poll();
            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            // If including this edge doesn't cause a cycle, add it to the result
            if (x != y) {
                result[e++] = next_edge;
                union(subsets, x, y);
                totalWeight += next_edge.weight;
            }
        }
        return totalWeight;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();  

        // Loop for each test case
        while (T-- > 0) {
            int V = sc.nextInt();  
            double points[][] = new double[V][2];  

            // Reading the coordinates of the points
            for (int i = 0; i < V; i++) {
                points[i][0] = sc.nextDouble();
                points[i][1] = sc.nextDouble();
            }

            FrecklesKruskal graph = new FrecklesKruskal(V);
            
            // Create a complete graph by calculating the distance between each pair of points
            for (int i = 0; i < V - 1; i++) {
                for (int j = i + 1; j < V; j++) {
                    Edge e = new Edge();
                    e.src = i;
                    e.dest = j;
                    e.weight = Math.sqrt(Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2));
                    graph.edgeQueue.offer(e);  // Add the edge to the PriorityQueue
                }
            }
            
            System.out.printf("%.2f\n", graph.kruskalMST());
            if (T > 0) System.out.println();
        }
        sc.close(); 
    }
}

