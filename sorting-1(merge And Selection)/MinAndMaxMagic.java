import java.util.Arrays;

public class MinAndMaxMagic {
    int[] solve(int[] A) {
        Arrays.sort(A);
        int max = 0, min = 0, mod = (int)(1e9+7), N = A.length;
        
        for(int i = 0; i < N/2; i++) {
            max = (max % mod + (A[N-i-1]-A[i]) % mod) % mod;
        }
        for(int i = 1; i < N; i+=2) {
            min = (min % mod + (A[i] - A[i-1] % mod)) % mod;
        }

        return new int[]{max % mod, min % mod};
    }    
}
