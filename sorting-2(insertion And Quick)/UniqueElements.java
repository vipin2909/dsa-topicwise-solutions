import java.util.Arrays;


public class UniqueElements {
    public int solve(int[] A) {
        Arrays.sort(A);
        int cnt = 0, N = A.length;
        for(int i = 1; i < N; i++) {
            if(A[i] == A[i-1]) {
                cnt += 1;
                A[i] += 1;
            }
            else if(A[i] < A[i-1]) {
                cnt += (A[i-1]-A[i]+1);
                A[i] = A[i-1]+1;
            }
        }
        return cnt;
    }    
}
