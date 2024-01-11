
public class FindRank {
    int mod = 1000003;
    int fact(int n) {
        if(n == 1) return 1;
        return n * fact(n-1) % mod;
    }
    int findRank(String A) {
        char[] arr = A.toCharArray();
        int ans = 0, N = arr.length;
        for(int i = 0; i < N - 1; i++) {
            int count = 0; // count of the digits who are smaller than arr[i]
            for(int j = i+1; j < N; j++) {
                if(arr[j] < arr[i]) count += 1;
            }
            ans += (count * fact(N-i-1)) % mod;
        }
        return (ans + 1) % mod;
    }    
    public static void main(String[] args) {
        String A = "cdba";
        int rank = new FindRank().findRank(A);
        System.out.println("Rank of String " + A + " is: " + rank);
    }
}
