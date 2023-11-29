package hidingPlaces;

import java.util.*;

public class hidingplaces {

    static class Square {
        int x, y, distance;

        Square(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        // Chess notation for the square
        public String toString() {
            return "" + (char) ('a' + y) + (8 - x);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine(); // Consume the rest of the line

        while (n-- > 0) {
            String location = in.nextLine();
            int startX = 8 - (location.charAt(1) - '0');
            int startY = location.charAt(0) - 'a';

            int[][] moves = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};
            int[][] distance = new int[8][8];
            for (int[] row : distance) Arrays.fill(row, Integer.MAX_VALUE);

            bfs(startX, startY, distance, moves);

            ArrayList<Square> furthestSquares = new ArrayList<>();
            int maxDistance = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (distance[i][j] != Integer.MAX_VALUE && distance[i][j] > maxDistance) {
                        maxDistance = distance[i][j];
                        furthestSquares.clear();
                        furthestSquares.add(new Square(i, j, maxDistance));
                    } else if (distance[i][j] == maxDistance) {
                        furthestSquares.add(new Square(i, j, maxDistance));
                    }
                }
            }

            // Sort the squares according to the problem's criteria
            Collections.sort(furthestSquares, Comparator.comparing((Square s) -> s.x).thenComparing(s -> s.y));

            // Output the result
            System.out.print(maxDistance);
            for (Square square : furthestSquares) {
                System.out.print(" " + square);
            }
            System.out.println();
        }
        in.close();
    }

    private static void bfs(int startX, int startY, int[][] distance, int[][] moves) {
        Queue<Square> queue = new LinkedList<>();
        queue.add(new Square(startX, startY, 0));
        distance[startX][startY] = 0;

        while (!queue.isEmpty()) {
            Square s = queue.poll();
            for (int[] move : moves) {
                int x = s.x + move[0];
                int y = s.y + move[1];
                if (isValid(x, y) && distance[x][y] == Integer.MAX_VALUE) {
                    distance[x][y] = s.distance + 1;
                    queue.add(new Square(x, y, distance[x][y]));
                }
            }
        }
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }
}