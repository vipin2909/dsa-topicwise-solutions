import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
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

    static void findAllPrimes(int A, ArrayList<Integer> res) throws IOException {
        int[] arr = new int[A+1];
        Arrays.fill(arr, 0);
        for(int i = 2; i * i <= A; i += 1) {
            if(arr[i] == 0) {
                for(int j = i * i; j <= A; j += i) {
                    arr[j] = 1;
                }
            }
        }

        for(int i = 2; i <= A; i++) {
            if(arr[i] == 0) res.add(i);
        }
    }

    public static void solve() throws IOException {
        int A = nextInt();
        ArrayList<Integer> res = new ArrayList<>();
        findAllPrimes(A, res);
        for(int ele: res) {
            out.print(ele + " ");
        }
        out.println();
        
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
