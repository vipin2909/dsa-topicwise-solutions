public class SumOfAllXorPairs {
    public int solve(int[] A) {
        int mod = 1000000007;
        int n = A.length;

        int sum = 0;
        for(int i = 0; i < 32; i++) {
            int zeroCount = 0, oneCount = 0;
            int tempSum = 0;
            for(int j = 0; j < n; j++) {
                if(A[j] % 2 == 0) {
                    zeroCount += 1;
                }
                else {
                    oneCount += 1;
                }
                A[j] /= 2;
            }
            tempSum = (int)(((long)zeroCount * oneCount * (1 << i)) % mod);
            sum = (sum % mod + tempSum % mod) % mod;
        }
        return sum;
    }    
}
