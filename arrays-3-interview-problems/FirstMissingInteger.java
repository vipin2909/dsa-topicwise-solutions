public class FirstMissingInteger {
    public int solve(int[] A) {
        int i = 0, N = A.length;
        while(i < N) {
            if(A[i] >= 1 && A[i] <= N) {
                int currIndex = A[i] - 1;
                if(A[currIndex] != A[i]) {
                    int temp = A[currIndex];
                    A[currIndex] = A[i];
                    A[i] = temp;
                }
                else {
                    i += 1;
                }
            }
            else {
                i += 1;
            }
        }

        for(int k = 0; k < N; k++) 
            if(A[k] - 1 != k) return k + 1;
        
        return N + 1;
    }
}