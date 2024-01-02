#include<bits/stdc++.h>

#define mp make_pair
#define mt make_tuple
#define fi first
#define se second
#define pb push_back
#define sz(x) (int)((x).size())
#define all(x) (x).begin(), (x).end()
#define rall(x) (x).rbegin(), (x).rend()
#define forn(i, n) for(int i = 0; i < (int)(n); i++)
#define for1(i, n) for(int i = 1; i <= (int)(n); i++)
#define ford(i, n) for(int i = (int)(n) - 1; i >= 0; i -= 1)
#define fore(i, a, b) for(int i = (int)(a); i <= (int)(b); i++)
#define LOCAL_DEFINE 

using namespace std;

typedef pair<int, int> pii;
typedef vector<int> vi;
typedef vector<pii> vpi;
typedef vector<vi> vvi;
typedef long long i64;
typedef vector<i64> vi64;
typedef vector<vi64> vvi64;
typedef pair<i64, i64> pi64;
typedef double ld;

template<class T> bool uni(T &a, T b) { return a > b ? (a = b, true) : false;}
template<class T> bool uax(T &a, T b) { return a < b ? (a = b, true) : false;}

const i64 P = 1000000000 + 7;

/*
        int mod = 1000000007;
        int n = A.length;
        int m = A[0].length;
        long[][] prefix = new long[n][m];
        prefix[0][0] = (A[0][0]);
        prefix[n-1][m-1] = (A[n-1][m-1]);
        long res = prefix[n-1][m-1];
        for(int i = n-2; i >= 0; i-=1) {
            prefix[i][m-1] = (prefix[i+1][m-1]+A[i][m-1]);
            res = (Math.max(prefix[i][m-1], res));
        }

        for(int i = m-2; i >= 0; i-=1) {
            prefix[n-1][i] = (prefix[n-1][i+1]+A[n-1][i]);
            res = (Math.max(prefix[n-1][i], res));
        }

        for(int i = n-2; i >= 0; i-=1) {
            for(int j = m-2; j >= 0; j-=1) {
                prefix[i][j] = (prefix[i+1][j]+prefix[i][j+1]+A[i][j]-prefix[i+1][j+1]);
                res=(Math.max(res, prefix[i][j]));
            }
        }

        return res;
*/

i64 solve(vvi &A) {
    int n = sz(A);
    int m = sz(A[0]);
    vvi64 prefix(n);
    forn(i, n) prefix[i] = vector<i64>(m);
    prefix[0][0] = A[0][0];
    prefix[n-1][m-1] = A[n-1][m-1];

    i64 res = prefix[n-1][m-1];

    // checking from bottom right corner to top right corner if max_sum possible and updating prefix arr
    ford(i, n-1) {
        prefix[i][m-1] = prefix[i+1][m-1] + A[i][m-1];
        res = max(res, prefix[i][m-1]);
    }

    
    // checking from bottom right corner to bottom left corner if max_sum possible and updating prefix arr
    ford(i, m-1) {
        prefix[n-1][i] = prefix[n-1][i+1] + A[n-1][i];
        res = max(res, prefix[n-1][i]);
    }

    // now checking in sub-matrices if max_sum possible while updating prefix arr
    ford(i, n-1) {
        ford(j, m-1) {
            prefix[i][j] = A[i][j] + prefix[i+1][j] + prefix[i][j+1] - prefix[i+1][j+1];
            res = max(prefix[i][j], res);
        }
    }

    return res;


}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.precision(10);
    cout << fixed;
// #ifdef LOCAL_DEFINE
//     freopen("input.txt", "rt", stdin);
// #endif

   int n, m;
    cin >> n >> m;
    vvi A(n);
    forn(i, n) A[i] = vector<int>(m);
    forn(i, n) {
        forn(j, m) {
            cin >> A[i][j];
        }
    }

    i64 re = solve(A);
    cout << "Maximum Submatrix Sum: " + re;


#ifdef LOCAL_DEFINE
    cerr << "Time elapsed: " << 1.0 * clock() / CLOCKS_PER_SEC << " s.\n";
#endif
    return 0;
}

