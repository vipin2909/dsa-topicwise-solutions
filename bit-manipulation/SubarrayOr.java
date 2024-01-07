public class SubarrayOr {
    public int solve(int[] A) {
        long ans = 0;
        int[] idx = new int[32];
        int N = A.length;
        for(int i = 1; i <= N; i++) {
            long temp = A[i-1];
            for(int j = 0; j < 31; j++) {
                long pw = (1 << j);
                if((temp & pw) != 0) {
                    ans += pw * i;
                    idx[j] = i;
                }
                else if(idx[j] != 0) {
                    ans += pw * idx[j];
                }
            }
        }
        return (int)(ans%1000000007);
    }
}
