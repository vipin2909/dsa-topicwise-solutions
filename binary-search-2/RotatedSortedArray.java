
public class RotatedSortedArray {
    public int search(final int[] A, int B) {
        int N = A.length;
        int lo = 0, hi = N - 1;

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(A[mid] == B) return mid;
            if(A[mid] >= A[lo]) {
                if(B <= A[mid] && B >= A[lo]) {
                    hi = mid - 1;
                }
                else {
                    lo = mid + 1;
                }
            }
            else {
                if(B <= A[hi] && B >= A[mid]) {
                    lo = mid + 1;
                }
                else {
                    hi = mid - 1;
                }
            }
            
        }
        return -1;
    }    
}
