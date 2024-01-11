
public class ConsecutiveNumbersSum {
    public int solve(int A) {
        int ans = 0;
        long n = 1;
        while((n * (n+1)) <= 2 * A) {
            long sum = (n*(n+1)) / 2;
            if((A-sum) % n == 0) ans += 1;
            n += 1;
        }
        return ans;
    }    
}
