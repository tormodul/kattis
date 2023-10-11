package tornToPieces;

import java.util.*;

public class TornToPieces {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Map<String, List<String>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            String station = line[0];
            graph.put(station, new ArrayList<>());

            for (int j = 1; j < line.length; j++) {
                graph.get(station).add(line[j]);
                graph.computeIfAbsent(line[j], k -> new ArrayList<>()).add(station);
            }
        }

        String start = scanner.next();
        String end = scanner.next();
        scanner.close();

        List<String> path = findRoute(graph, start, end);

        if (path != null) {
            for (String station : path) {
                System.out.print(station + " ");
            }
        } else {
            System.out.println("no route found");
        }
    }

    private static List<String> findRoute(Map<String, List<String>> graph, String start, String end) {
        if (!graph.containsKey(start) || !graph.containsKey(end)) {
            return null; // Handle the case where start or end stations are not present
        }

        Set<String> visited = new HashSet<>();
        Map<String, String> parentMap = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (current.equals(end)) {
                return buildPath(parentMap, start, end);
            }

            for (String neighbor : graph.get(current)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    parentMap.put(neighbor, current);
                }
            }
        }

        return null; // No route found
    }

    private static List<String> buildPath(Map<String, String> parentMap, String start, String end) {
        List<String> path = new ArrayList<>();
        String current = end;
        while (!current.equals(start)) {
            path.add(current);
            current = parentMap.get(current);
        }
        path.add(start);
        Collections.reverse(path);
        return path;
    }

    
}
