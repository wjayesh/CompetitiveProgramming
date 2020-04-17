
public class IslandsDay17 {
    public static int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1' && noNearbyIsland(grid, i, j)) {
                    grid[i][j] = '2';
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean noNearbyIsland(char[][] grid, int i, int j) {
        int up = Math.max(i - 1, 0); int down = Math.min(i + 1, grid.length - 1);
        int left = Math.max(j - 1, 0); int right = Math.min(j + 1, grid[0].length - 1);

        if(grid[up][j] == '2' || grid[down][j] == '2' 
            || grid[i][left] == '2' || grid[i][right] == '2') {
            grid[i][j] = '2';
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(numIslands(grid));
    }

}