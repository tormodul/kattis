package shortestpath1;

import java.util.*;

public class ShortestPath1 {

    static final int INF = Integer.MAX_VALUE;
    
    static class Edge {
        int node;
        int weight;

        Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    static class Graph {
        List<List<Edge>> adjList;
        int numNodes;

        Graph(int numNodes) {
            this.numNodes = numNodes;
            adjList = new ArrayList<>();
            for (int i = 0; i < numNodes; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        void addEdge(int u, int v, int w) {
            adjList.get(u).add(new Edge(v, w));
        }

        int[] dijkstra(int start) {
            int[] dist = new int[numNodes];
            Arrays.fill(dist, INF);
            dist[start] = 0;
            
            PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
            pq.add(new Edge(start, 0));

            while (!pq.isEmpty()) {
                Edge current = pq.poll();
                int u = current.node;
                int uDist = current.weight;

                if (uDist > dist[u]) {
                    continue;
                }

                for (Edge e : adjList.get(u)) {
                    int v = e.node;
                    int vDist = uDist + e.weight;
                    if (vDist < dist[v]) {
                        dist[v] = vDist;
                        pq.add(new Edge(v, vDist));
                    }
                }
            }
            
            return dist;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int q = scanner.nextInt();
            int s = scanner.nextInt();

            if (n == 0 && m == 0 && q == 0 && s == 0) break;

            Graph graph = new Graph(n);

            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                int w = scanner.nextInt();
                graph.addEdge(u, v, w);
            }

            int[] distances = graph.dijkstra(s);

            for (int i = 0; i < q; i++) {
                int query = scanner.nextInt();
                int distance = distances[query];
                if (distance == INF) {
                    System.out.println("Impossible");
                } else {
                    System.out.println(distance);
                }
            }
            System.out.println(); // print blank line between cases
        }
        scanner.close();
    }
}

