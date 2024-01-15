
public class SquareRoot {
    public int solve(int A) {
        if(A < 2) return A;
        int lo = 1, hi = A, ans = 0;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(mid <= A / mid) {
                ans = mid;
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }

        return ans;
    }
}
