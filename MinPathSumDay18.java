
public class MinPathSumDay18 {
    public int minPathSum(int[][] grid) {
        return minPathSumDP(grid, 0, 0);
    }

    private int minPathSumDP(int[][] grid, int i, int j) {
        if(i == grid.length - 1) {
            int sum = 0;
            while(j != grid[0].length) {
                sum += grid[i][j];
                j++;
            }
            return sum;
        }
        if(j == grid[0].length - 1) {
            int sum = 0;
            while(i != grid.length) {
                sum += grid[i][j];
                i++;
            }
            return sum;
        }
        return grid[i][j] + Math.min(minPathSumDP(grid, i, j+1), minPathSumDP(grid, i+1, j));
    }
}