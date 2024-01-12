
public class SingleElement {
    public int solve(int[] A) {
        int ans = 0;
        int lo = 0, N = A.length, hi = A.length - 1;

        if(N == 1) return A[0];
        if(A[lo] != A[lo+1]) return A[lo];
        if(A[hi] != A[hi-1]) return A[hi];

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(A[mid] != A[mid-1] && A[mid] != A[mid+1]) {
                ans = A[mid];
                break;
            }
            if(A[mid-1] == A[mid]) {
                mid -= 1;
            }
            if(mid % 2 == 0) {
                lo = mid + 2;
            }
            else {
                hi = mid - 1;
            }
        }
        return ans;
    }    
}
