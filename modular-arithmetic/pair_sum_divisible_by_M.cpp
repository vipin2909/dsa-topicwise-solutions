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

int modpow(int A, int B) {
    if(B == 0) return (1%P);
    i64 u = modpow(A, B/2);
    u = (u * u) % P;
    if(B&1) u = (u * A) % P;
    return (int)(u % P);
}

int solve(vi &A, int B) {
    int N = sz(A);
    vi arr(B);
    i64 sum = 0;
    forn(i, N) arr[A[i]%B]+=1;
    forn(i, B) {
        int temp = B-i;
        if(temp < i) break;
        
        if(i == 0 || i+i == B) {    
            int x = arr[i]%P;
            int y = (arr[i]-1)%P;
            sum = (sum % P + (1L*x*y / 2) % P) % P;
        }
        else {
            int x = arr[i]%P;
            int y = arr[B-i]%P;
            sum = (sum % P + (1L*x*y) % P) % P;
        }
    }
    return (int)(sum % P);
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
    vi A(n);
    forn(i, n) cin >> A[i];

    int ans = solve(A, m);

    cout << ans << "\n";


#ifdef LOCAL_DEFINE
    cerr << "Time elapsed: " << 1.0 * clock() / CLOCKS_PER_SEC << " s.\n";
#endif
    return 0;
}

