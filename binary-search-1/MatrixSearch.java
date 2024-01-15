
public class MatrixSearch {
    public int searchMatrix(int[][] A, int B) {
        int N = A.length, M = A[0].length;
        int lo = 0, hi = N * M - 1;
        
        while(lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            int row = mid / M, col = mid % M;
            if(A[row][col] == B) {
                return 1;
            }
            else if(A[row][col] < B) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }

        return 0;
    }    
}
