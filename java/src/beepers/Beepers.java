package beepers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Beepers {

    static int[][] distances; // distances between all points
    static int[][] dp; // dynamic programming table

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scenarios = scanner.nextInt();

        for (int scenario = 0; scenario < scenarios; scenario++) {
            int xSize = scanner.nextInt();
            int ySize = scanner.nextInt();
            int startX = scanner.nextInt() - 1;
            int startY = scanner.nextInt() - 1;
            int beepers = scanner.nextInt();

            int[][] points = new int[beepers + 1][2];
            points[0] = new int[]{startX, startY}; // Starting point

            for (int i = 1; i <= beepers; i++) {
                points[i] = new int[]{scanner.nextInt() - 1, scanner.nextInt() - 1};
            }

            precomputeDistances(points, xSize, ySize);
            initializeDP(beepers);
            computeDP(beepers);

            int minDistance = findMinDistance(beepers);
            System.out.println(minDistance);
        }

        scanner.close();
    }

    static void precomputeDistances(int[][] points, int xSize, int ySize) {
        int pointCount = points.length;
        distances = new int[pointCount][pointCount];
    
        for (int i = 0; i < pointCount; i++) {
            for (int j = 0; j < pointCount; j++) {
                if (i != j) {
                    distances[i][j] = bfsDistance(points[i], points[j], xSize, ySize);
                } else {
                    distances[i][j] = 0; // Distance to the same point is 0
                }
            }
        }
    }

    static int bfsDistance(int[] start, int[] end, int xSize, int ySize) {
        int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[xSize][ySize];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1], 0}); // x, y, distance
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], dist = current[2];

            if (x == end[0] && y == end[1]) {
                return dist;
            }

            for (int[] move : moves) {
                int newX = x + move[0], newY = y + move[1];
                if (newX >= 0 && newX < xSize && newY >= 0 && newY < ySize && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.offer(new int[]{newX, newY, dist + 1});
                }
            }
        }

        return Integer.MAX_VALUE; // In case there is no path
    }

    static void initializeDP(int beepers) {
        dp = new int[1 << beepers][beepers + 1];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
    }

    static void computeDP(int beepers) {
        for (int mask = 0; mask < (1 << beepers); mask++) {
            for (int i = 0; i <= beepers; i++) {
                if (dp[mask][i] == Integer.MAX_VALUE) continue;
    
                for (int j = 0; j < beepers; j++) {
                    if ((mask & (1 << j)) == 0) {
                        int nextMask = mask | (1 << j);
                        dp[nextMask][j + 1] = Math.min(dp[nextMask][j + 1], dp[mask][i] + distances[i][j + 1]);
                    }
                }
            }
        }
    }

    static int findMinDistance(int beepers) {
        int minDistance = Integer.MAX_VALUE;
        int finalMask = (1 << beepers) - 1;
        for (int i = 1; i <= beepers; i++) {
            minDistance = Math.min(minDistance, dp[finalMask][i] + distances[i][0]);
        }
        return minDistance;
    }
}
