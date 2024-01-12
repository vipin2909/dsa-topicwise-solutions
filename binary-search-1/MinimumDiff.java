import java.util.Arrays;
public class MinimumDiff {
    int lowerBound(int[] A, int x) {
        int lo = 0, hi = A.length - 1, ans = -1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(A[mid] == x) return mid;
            else if(A[mid] < x) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
                ans = mid;
            }
        }

        if(ans == -1) return lo - 1;
        return ans;
    }    

    public int solve(int A, int B, int[][] C) {
        int ans = Integer.MAX_VALUE;
        for(int[] ele: C) Arrays.sort(ele);
        for(int i = 0; i < A-1; i++) {
            for(int j = 0; j < B; j++) {
                int p = lowerBound(C[i+1], C[i][j]);
                ans = Math.min(ans, Math.abs(C[i+1][p] - C[i][j]));
                if(p - 1 >= 0) {
                    ans = Math.min(ans, Math.abs(C[i][j] - C[i+1][p-1]));
                }
            }
        }
        return ans;
    }
}
