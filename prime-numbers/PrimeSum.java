import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PrimeSum {
    
    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer tok;
    
    static String next() throws IOException {
        while(tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(br.readLine());
        }
        return tok.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    static int[] sieve(int A) throws IOException {
        
        int[] isPrime = new int[A+1];
        Arrays.fill(isPrime, -1);

        for(int i = 2; i * i <= A; i+=1) {
            if(isPrime[i] == -1) {
                for(int j = i * i; j <= A; j += i) {
                    isPrime[j] = 1;
                }
            }
        }
        return isPrime;
    } 

    public static void solve() throws IOException {
        int A = nextInt();
        int[] isPrime = sieve(A);
        int[] ans = new int[2];
        for(int i = 2; i <= A; i++) {
            if(isPrime[i] == -1 && isPrime[A-i] == -1) {
                ans = new int[]{i, A-i};
                break;
            }
        }

        out.println(ans[0]+" "+ans[1]);  
    }

    public static void main(String[] args) {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            solve();
            br.close();
            out.close();
        }

        catch(Throwable e) {
            e.printStackTrace();
        }
    }

    
}
