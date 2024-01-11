import java.util.Arrays;

public class MinAbsoluteDiff {
    public int solve(int[] A) {
        Arrays.sort(A);

        int best = Integer.MAX_VALUE, N = A.length;
        for(int i = 1; i < N; i++) {
            best = Math.min(best, A[i] - A[i-1]);
        }
        return best;
    }    
}
