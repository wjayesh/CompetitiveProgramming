package May;

public class IntervalIntersections23 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int[][] result = new int[A.length + B.length][2];
        int index = 0, j = 0;
        for(int i = 0; i < A.length; i++) {
            int start = A[i][0], end = A[i][1];
            while(j < B.length && B[j][0] >= start && B[j][0] <= end) {
                result[index][0] = B[j][0];
                result[index][1] = Math.min(B[j][1], end);
                index++; 
                if(i+1 < A.length && B[j][1] == A[i+1][0]) {
                    result[index][0] = B[j][1];
                    result[index][1] = B[j][1];
                    index++;
                }
                j++;
            }
        }
        return result;
    }
}
