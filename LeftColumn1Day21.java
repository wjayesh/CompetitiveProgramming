import utils.BinaryMatrix;

public class LeftColumn1Day21 {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int n = binaryMatrix.dimensions().get(0);
        int m = binaryMatrix.dimensions().get(1);
        int minIndex = m;
        for(int i = 0; i < n; i++) {
            findOne(binaryMatrix, i, 0, m-1);
            if(firstOccurence < minIndex) {
                minIndex = firstOccurence;
            }
        }
        return (minIndex != m)? minIndex: -1;
    }

    private int firstOccurence = Integer.MAX_VALUE;
    private void findOne(BinaryMatrix binaryMatrix, int i, int start, int end) {
        if(start == end || binaryMatrix.get(i, end) == 0) {
            return;
        }
        int mid = (start + end)/2;
        if(binaryMatrix.get(i, mid) == 0) {
            findOne(binaryMatrix, i, mid, end);
        } else {
            if(mid < firstOccurence) {
                firstOccurence = mid;
            }
            findOne(binaryMatrix, i, start, mid);
        }
    }

}