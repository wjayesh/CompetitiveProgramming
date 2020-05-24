public class SqSubmatWithAllOnes21 {
  public int countSquares(int[][] matrix) {
        int count = 0;
        for(int i=1,n=matrix.length; i<n; i++){
            for(int j=1,m=matrix[0].length; j<m; j++ ){
                if(matrix[i][j]==1){
                    matrix[i][j] += Math.min(Math.min(matrix[i-1][j-1], matrix[i-1][j]), matrix[i][j-1]);
                    count += matrix[i][j];
                }
            }
        }
        
        for(int i = 0; i<matrix[0].length; i++)
            count += matrix[0][i];
        
        for(int i = 1; i<matrix.length; i++)
            count += matrix[i][0];
        
        return count;
    }
}
