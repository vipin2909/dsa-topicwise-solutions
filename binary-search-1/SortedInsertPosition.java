
public class SortedInsertPosition {
    int solve(int[] A, int target) {
        int lo = 0, hi = A.length;
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if(A[mid] >= target) {
                hi = mid;
            }
            else {
                lo = mid + 1;
            }
        }
        return lo;
    }    
}
