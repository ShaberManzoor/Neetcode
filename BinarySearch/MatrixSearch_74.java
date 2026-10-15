package BinarySearch;

public class MatrixSearch_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, h = m * n - 1;

        while(l<=h) {
            int mid = (h - l) / 2 + l;
            int r = mid / n, c = mid % n;
            
            if(matrix[r][c]==target) return true;
            else if(matrix[r][c]>target) h = mid-1;
            else l = mid+1;
        }

        return false;
    }
}
