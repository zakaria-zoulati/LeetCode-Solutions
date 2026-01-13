class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length ; 
        int m = matrix[0].length ; 
        int row = 0;
        int col = matrix[0].length - 1;
        while(row < n && col >= 0) {
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] > target) --col;
            else ++row;
        }
        return false;
    }
}