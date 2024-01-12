
public class FindAPeakElement {
    public int findPeakElement(int[] A) {
        int N = A.length, lo = 0, hi = A.length - 1;
        // base cases 
        // 1. when arr is of 1 length
        if(N == 1) return A[0];
        // 2. if peak exists at first index
        if(A[lo] > A[lo+1]) return A[lo];
        // 3. if peak exists at last index
        if(A[hi] > A[hi-1]) return A[hi];


        int ans = -1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(A[mid] >= A[mid+1] && A[mid] >= A[mid-1]) {
                ans = A[mid];
                break;
            }
            // other two cases are either arr is increasing or either arr is decresing 
            // Increasing
            else if(A[mid] > A[mid-1] && A[mid+1] > A[mid]) {
                lo = mid + 1;
            }
            // Decreasing
            else if(A[mid] > A[mid+1] && A[mid-1] > A[mid]) {
                hi = mid - 1;
            }

        }
        return ans;
    }    
}
