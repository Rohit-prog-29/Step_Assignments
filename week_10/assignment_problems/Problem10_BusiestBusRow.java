import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Category C · Coding Assignment
 * Problem 10: Busiest Bus Row
 *
 * TASK:
 * A college bus records how many students sit in each seat as a 2D grid, where each row
 * is one row of seats. The transport office wants to know which row carries the most students.
 *
 * Implement a function busiestRow(grid) that returns the index of the row with the largest
 * total and that total. If two rows tie, return the one with the smaller index.
 *
 * CONSTRAINTS:
 * - 1 <= rows, columns <= 10
 * - 0 <= grid[i][j] <= 3
 *
 * COMPLEXITY REQUIREMENTS:
 * - Time Complexity: O(r * c) where r is the number of rows and c is the number of columns,
 *   as each seat element in the grid is visited and summed exactly once.
 * - Auxiliary Space Complexity: O(1) extra space beyond the input grid, requiring only a few
 *   primitive variables to track the best index and maximum sum.
 * - Tie-Breaking: Using strict inequality (rowSum > maxTotal) ensures that if multiple rows
 *   have the same maximal sum, the row with the smaller index is preserved.
 */
public class Problem10_BusiestBusRow {

    public static class RowResult {
        public final int rowIndex;
        public final int totalStudents;

        public RowResult(int rowIndex, int totalStudents) {
            this.rowIndex = rowIndex;
            this.totalStudents = totalStudents;
        }

        @Override
        public String toString() {
            return "Row " + rowIndex + ", Total " + totalStudents;
        }
    }

    /**
     * Determines the row index with the largest seat total.
     * Ties are broken in favor of the smaller row index.
     */
    public static RowResult busiestRow(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return new RowResult(0, 0);
        }

        int bestRowIndex = 0;
        int maxTotal = -1;

        for (int r = 0; r < grid.length; r++) {
            int rowSum = 0;
            if (grid[r] != null) {
                for (int c = 0; c < grid[r].length; c++) {
                    rowSum += grid[r][c];
                }
            }
            // Strict inequality guarantees smaller index wins ties
            if (rowSum > maxTotal) {
                maxTotal = rowSum;
                bestRowIndex = r;
            }
        }

        return new RowResult(bestRowIndex, maxTotal);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<int[]> rowList = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;
            // Parse row format, e.g. "[2, 0, 1]," or "2 0 1"
            line = line.replace("[", "").replace("]", "").replace(",", " ").trim();
            Scanner lineScanner = new Scanner(line);
            List<Integer> rowVals = new ArrayList<>();
            while (lineScanner.hasNextInt()) {
                rowVals.add(lineScanner.nextInt());
            }
            lineScanner.close();
            if (!rowVals.isEmpty()) {
                int[] rowArr = new int[rowVals.size()];
                for (int i = 0; i < rowVals.size(); i++) rowArr[i] = rowVals.get(i);
                rowList.add(rowArr);
            }
        }

        int[][] grid;
        if (!rowList.isEmpty()) {
            grid = rowList.toArray(new int[0][]);
            System.out.println(busiestRow(grid));
        } else {
            // Default sample demonstration:
            // grid = [[2, 0, 1],
            //         [3, 3, 1],
            //         [1, 1, 1]]
            // Expected Output: Row 1, Total 7
            int[][] sampleGrid = {
                {2, 0, 1},
                {3, 3, 1},
                {1, 1, 1}
            };
            System.out.println(busiestRow(sampleGrid));
        }

        scanner.close();
    }
}
