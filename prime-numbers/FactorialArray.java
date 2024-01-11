import java.util.Arrays;

public class FactorialArray {
    public int solve(int[] A) {
        Arrays.sort(A);
        int N = A.length;
        int maxEle = A[N-1];
        boolean[] isPrime = new boolean[maxEle+1];

        Arrays.fill(isPrime, true);
        for(int p = 2; p * p <= maxEle; p++) {
            if(isPrime[p]) {
                for(int i = p * p; i <= maxEle; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        long sum = 0L;
        int mod = (int)(1e9+7), ind = 0;

        int[] primeCount = new int[maxEle+1];
        for(int i = 2; i <= maxEle; i++) {
            if(isPrime[i]) {
                primeCount[i] = primeCount[i-1] + 1;
            }
            else {
                primeCount[i] = primeCount[i-1];
            }
        }

        int cnt = 1;
        if(A[0] < 2) cnt = 0;

        for(int i = 0; i < N - 1; i++) {
            if(primeCount[A[i]] == primeCount[A[i+1]]) cnt += 1;
            else {
                sum = (sum % mod + (1L * (1 << cnt) - 1) % mod) % mod;
            }
        }

        sum = (sum + (1 << cnt) - 1) % mod;

        return (int)(sum % mod);



    }    
}
