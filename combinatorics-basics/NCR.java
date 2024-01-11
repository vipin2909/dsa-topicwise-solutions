public class NCR {
    public int power(long A, int B, int C) {
        if(B == 0) return 1 % C;
        A %= C;
        long res = 1L;
        while(B > 0) {
            if((B&1)==1) {
                res = (res * A) % C;
            }
            B >>= 1;
            A = (A * A) % C;
        }
        return (int)(res % C);
    }
    
    public int solve(int A, int B, int C) {
        // nCr = fact[n] * modInv(fact[r]) * modInv(fact[n-r]);
        long[] fact = new long[A+1];
        fact[0] = 1;
        for(int i = 1; i <= A; i++) {
            fact[i] = (fact[i-1] * i) % C;
        }
        long ans = fact[A];

        ans = (ans * power(fact[A-B], C-2, C)) % C;
        ans = (ans * power(fact[B], C-2, C)) % C;

        return (int)(ans%C);

    }
}
