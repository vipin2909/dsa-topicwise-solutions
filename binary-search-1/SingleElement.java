
public class SingleElement {

    // modified solution 
    public int singleElement(int[] A) {
        int ans = 0, N = A.length;
        int lo = 0, hi = N - 1;

        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            // if mid reached last position it means all the elements are twice repeted
            if(mid == N-1) return A[N-1];
            if(A[mid] == A[mid+1]) mid += 1;
            if(mid % 2 == 1) lo = mid + 1;
            else {
                ans = mid;
                hi = mid - 1;
            }
        }

        return ans;
    }
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
