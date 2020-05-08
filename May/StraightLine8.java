package May;

public class StraightLine8 {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length == 0 || coordinates.length == 1) {
            return true;
        }
        int a = coordinates[1][1] - coordinates[0][1];
        int b = coordinates[0][0] - coordinates[1][0];
        int c = (a * coordinates[0][0]) + (b * coordinates[0][1]);
        for (int i = 2; i < coordinates.length; i++) {
            if ((a * coordinates[i][0]) + (b * coordinates[i][1]) != c) {
                return false;
            }
        }
        return true;
    }
}