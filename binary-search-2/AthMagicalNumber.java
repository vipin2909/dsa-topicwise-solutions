// Before solving question one should know this formula
// Numbers divisible by B And C in range of [1, M] given by M / B + M / C - M / LCM(A, B)
public class AthMagicalNumber {
    int gcd(int A, int B) {
        if(B == 0) return A;
        return gcd(B, A%B);
    }

    public int solve(int A, int B, int C) {
        long lo = 0L, hi = (long)(1e18), ans = 0L;
        long lcm = (1L * B * C) / gcd(B, C);

        while(lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long di = mid / B + mid / C - mid / lcm;
            if(di >= A) {
                ans = mid;
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }

        return (int)(ans % ((int)(1e9)));

    }
}
