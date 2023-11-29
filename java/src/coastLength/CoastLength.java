package coastLength;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CoastLength {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input and split it into two variables: Amount of arrays given and length of each array given
        String initialInput = scanner.nextLine();
        String[] initialInputList = initialInput.split(" ");

        // Add two to each of these variables to build an extra 'border' of sea around the given map
        int amountOfListsGiven = Integer.parseInt(initialInputList[0]) + 2;
        int lengthOfListsGiven = Integer.parseInt(initialInputList[1]) + 2;

        int[][] map2DArray = new int[amountOfListsGiven][lengthOfListsGiven];

        // Initialize with 0 values
        for (int i = 0; i < amountOfListsGiven; i++) {
            for (int j = 0; j < lengthOfListsGiven; j++) {
                map2DArray[i][j] = 0;
            }
        }

        // Build the map with user input
        for (int i = 1; i < amountOfListsGiven - 1; i++) {
            String currentArrayInput = scanner.nextLine();
            char[] currentArrayRow = currentArrayInput.toCharArray();

            // Build a new row with 0 as its first and last elements (to build a 'border' of sea around the list)
            map2DArray[i][0] = 0;
            for (int j = 1; j < lengthOfListsGiven - 1; j++) {
                map2DArray[i][j] = Character.getNumericValue(currentArrayRow[j - 1]);
            }
            map2DArray[i][lengthOfListsGiven - 1] = 0;
        }

        // Add the 'border' of sea at the top and bottom of the map
        for (int i = 0; i < lengthOfListsGiven; i++) {
            map2DArray[0][i] = 0;
            map2DArray[amountOfListsGiven - 1][i] = 0;
        }

        System.out.println(iterateSeaTiles(map2DArray));
    }

    public static int iterateSeaTiles(int[][] mapArray) {
        Set<Coordinate> unvisitedSeaCoordinates = new HashSet<>();
        unvisitedSeaCoordinates.add(new Coordinate(0, 0));
        int totalSeaCoastCount = 0;

        // Offsets to avoid index out of bounds errors
        int[][] offsets = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

        // Iterate through the set of unvisited sea tiles until it is empty (i.e., visited every sea tile)
        while (!unvisitedSeaCoordinates.isEmpty()) {
            Coordinate coordinate = unvisitedSeaCoordinates.iterator().next();
            unvisitedSeaCoordinates.remove(coordinate);
            int yPosition = coordinate.y;
            int xPosition = coordinate.x;
            mapArray[yPosition][xPosition] = 2;

            for (int[] offset : offsets) {
                int targetY = yPosition + offset[0];
                int targetX = xPosition + offset[1];

                // Check if the target location is out of bounds
                if (targetY < 0 || targetY >= mapArray.length || targetX < 0 || targetX >= mapArray[0].length) {
                    continue;
                }

                // If the neighbor is a 0, add it to the set of unvisited sea tiles
                if (mapArray[targetY][targetX] == 0) {
                    unvisitedSeaCoordinates.add(new Coordinate(targetY, targetX));
                }
                // If the neighbor is a 1, increment the total sea coastline by 1
                else if (mapArray[targetY][targetX] == 1) {
                    totalSeaCoastCount++;
                }
            }
        }

        return totalSeaCoastCount;
    }
}

class Coordinate {
    int y;
    int x;

    public Coordinate(int y, int x) {
        this.y = y;
        this.x = x;
    }

    @Override
    public int hashCode() {
        return y * 31 + x;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Coordinate other = (Coordinate) obj;
        return y == other.y && x == other.x;
    }
}



// import java.util.Scanner;

// public class CoastLength {
//     public static void main(String[] args) {
//         Scanner in = new Scanner(System.in);

//         int n = in.nextInt();
//         int m = in.nextInt();
//         in.nextLine(); // Consume the newline character

//         char[][] grid = new char[n][m];

//         // Read in the grid
//         for (int i = 0; i < n; i++) {
//             String row = in.nextLine();
//             for (int j = 0; j < m; j++) {
//                 grid[i][j] = row.charAt(j);
//             }
//         }

//         int coastLength = computeCoastLength(grid, n, m);

//         // Output the coast length
//         System.out.println(coastLength);
//     }

//     public static int computeCoastLength(char[][] grid, int n, int m) {
//         int coastLength = 0;

//         boolean[][] visited = new boolean[n][m];

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 if (grid[i][j] == '1' && !visited[i][j]) {
//                     if (isCoast(grid, visited, n, m, i, j)) {
//                         coastLength++;
//                     }
//                 }
//             }
//         }

//         return coastLength;
//     }

//     public static boolean isCoast(char[][] grid, boolean[][] visited, int n, int m, int i, int j) {
//         int[] dx = { -1, 1, 0, 0 };
//         int[] dy = { 0, 0, -1, 1 };

//         visited[i][j] = true;

//         boolean isCoast = false;

//         for (int k = 0; k < 4; k++) {
//             int ni = i + dx[k];
//             int nj = j + dy[k];

//             if (ni < 0 || ni >= n || nj < 0 || nj >= m) {
//                 // This cell is at the edge of the grid
//                 isCoast = true;
//             } else if (grid[ni][nj] == '0' && !visited[ni][nj]) {
//                 isCoast = true;
//             } else if (grid[ni][nj] == '1' && !visited[ni][nj]) {
//                 isCoast |= isCoast(grid, visited, n, m, ni, nj);
//             }
//         }

//         return isCoast;
//     }
// }










// import java.util.Scanner;

// public class CoastLength {
//     public static void main(String[] args) {
//         Scanner in = new Scanner(System.in);

//         int n = in.nextInt();
//         int m = in.nextInt();

//         int[][] grid = new int[n][m];

//         // Read in the grid
//         for (int i = 0; i < n; i++) {
//             String row = in.next();
//             for (int j = 0; j < m; j++) {
//                 grid[i][j] = row.charAt(j) - '0';
//             }
//         }

//         int coastLength = 0;

//         // Check the four adjacent cells
//         // If 0 and all four adjacent cells are 1, don't increment coastLength

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {

//                 if (grid[i][j] == 1) { // Check land cells only
//                     if (i == 0 || grid[i - 1][j] == 0) {
//                         coastLength++; // Cell above is water
//                     }
//                     if (i == n - 1 || grid[i + 1][j] == 0) {
//                         coastLength++; // Cell below is water
//                     }
//                     if (j == 0 || grid[i][j - 1] == 0) {
//                         coastLength++; // Cell to the left is water
//                     }
//                     if (j == m - 1 || grid[i][j + 1] == 0) {
//                         coastLength++; // Cell to the right is water
//                     }
//                 }
                
//                 // Check if 0 and all four adjacent cells are 1
//                 if (grid[i][j] == 0 && i > 0 && i < n - 1 && j > 0 && j < m - 1) {
//                     if (grid[i - 1][j] == 1 && grid[i + 1][j] == 1 && grid[i][j - 1] == 1 && grid[i][j + 1] == 1) {
//                         coastLength = coastLength - 4;
//                     }
//                 }
//             }
//         }
        
        
//         // Handle additional boundary cases
//         if (coastLength < 0) {
//             coastLength = 0; // Ensure coastLength is non-negative
//         }
        
//         // Output the coast length
//         System.out.println(coastLength);
//     }
// }



// import java.util.Scanner;

// public class CoastLength {
//     public static void main(String[] args) {
//         Scanner in = new Scanner(System.in);

//         int n = in.nextInt();
//         int m = in.nextInt();

//         int[][] grid = new int[n][m];

//         // Read in the grid
//         for (int i = 0; i < n; i++) {
//             String row = in.next();
//             for (int j = 0; j < m; j++) {
//                 grid[i][j] = row.charAt(j) - '0';
//             }
//         }

//         int coastLength = 0;

//         // Create a visited array to track visited cells
//         boolean[][] visited = new boolean[n][m];

//         // Define the four possible directions: up, down, left, right
//         int[] dx = { -1, 1, 0, 0 };
//         int[] dy = { 0, 0, -1, 1 };

//         // Perform DFS to find connected components and calculate coast length
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 if (grid[i][j] == 1 && !visited[i][j]) {
//                     int componentPerimeter = dfs(grid, i, j, n, m, dx, dy, visited);
//                     coastLength += componentPerimeter;
//                 }
//             }
//         }

//         System.out.println(coastLength);
//     }

//     static int dfs(int[][] grid, int x, int y, int n, int m, int[] dx, int[] dy, boolean[][] visited) {
//         visited[x][y] = true;
//         int perimeter = 0;

//         for (int dir = 0; dir < 4; dir++) {
//             int newX = x + dx[dir];
//             int newY = y + dy[dir];

//             if (newX < 0 || newX >= n || newY < 0 || newY >= m) {
//                 // If we're out of bounds, increment perimeter
//                 perimeter++;
//             } else if (grid[newX][newY] == 0) {
//                 // If the neighboring cell is water, increment perimeter
//                 perimeter++;
//             } else if (grid[newX][newY] == 1 && !visited[newX][newY]) {
//                 // If it's a land cell and not visited, continue DFS
//                 perimeter += dfs(grid, newX, newY, n, m, dx, dy, visited);
//             }
//         }

//         return perimeter;
//     }
// }
