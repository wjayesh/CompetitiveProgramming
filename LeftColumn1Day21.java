import utils.BinaryMatrix;

public class LeftColumn1Day21 {
    public int leftMostColumnWithOne(BinaryMatrix matrix) {

        int row = matrix.dimensions().get(0);
        int col = matrix.dimensions().get(1);
        if (matrix == null || row == 0 || col == 0)
            return -1;

        int m = 0;
        int n = col - 1;

        while (m < row && n >= 0) {
            if (matrix.get(m, n) == 1) {
                n--;
            } else {
                m++;
            }
        }
        return n != col - 1 ? n + 1 : -1;
    }

}