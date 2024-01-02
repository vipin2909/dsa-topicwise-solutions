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

vi solve(vvi &A, vi &B, vi &C, vi &D, vi &E) {
    int q = sz(B);
    int n = sz(A);
    int m = sz(A[0]);

    vvi64 prefix(n);
    forn(i, n) prefix[i] = vector<i64>(m);
    forn(i, n) {
        forn(j, m) {
            if(i == 0 && j == 0) {
                prefix[i][j] = (A[i][j]%P)%P;
            }
            else if(i == 0 && j > 0) {
                prefix[i][j] = (prefix[i][j-1] % P + (A[i][j] + P) % P + P) % P;
            }
            else if(i > 0 && j == 0) {
                 prefix[i][j] = (prefix[i-1][j] % P + (A[i][j] + P) % P + P) % P;
            }
            else {
                 prefix[i][j] = (prefix[i][j-1] % P + prefix[i-1][j] % P - prefix[i-1][j-1] % P + (A[i][j] + P) % P + P) % P;
            }
        }
    }

    vi64 res(q);
    forn(i, q) {
        int x1 = B[i] - 1;
        int x2 = D[i] - 1;
        int y1 = C[i] - 1;
        int y2 = E[i] - 1;

        if(x1 == 0 && y1 == 0) {
            res[i] = (prefix[x2][y2] % P)%P;
        }
       else if(x1 == 0) {
                res[i] = (prefix[x2][y2]%P - prefix[x2][y1-1]%P)%P;
            } 
            else if(y1 == 0) {
                res[i] = (prefix[x2][y2]%P - prefix[x1-1][y2]%P)%P;
            }

            else {
                res[i] = (prefix[x2][y2]%P - prefix[x2][y1-1]%P-prefix[x1-1][y2]%P + prefix[x1-1][y1-1]%P) % P;
            }
    }
    vi ans(q);
    forn(i, q) {
        ans[i] = (int)((res[i]%P+P)%P);
    }
    return ans;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.precision(10);
    cout << fixed;
// #ifdef LOCAL_DEFINE
//     freopen("input.txt", "rt", stdin);
// #endif

    int n, m, q;
    cin >> n >> m;
    vvi A(n);
    forn(i, sz(A)) A[i] = vector<int>(m);
    vi B(q), C(q), D(q), E(q);
    forn(i, n) {
        forn(j, m) {
            cin >> A[i][j];
        }
    }
    cin >> q;
    forn(i, q) cin >> B[i];
    forn(i, q) cin >> C[i];
    forn(i, q) cin >> D[i];
    forn(i, q) cin >> E[i];

    vi ans = solve(A, B, C, D, E);
    forn(i, sz(ans)) cout << ans[i] << "\t";
    cout << "\n";

#ifdef LOCAL_DEFINE
    cerr << "Time elapsed: " << 1.0 * clock() / CLOCKS_PER_SEC << " s.\n";
#endif
    return 0;
}



/*
*/