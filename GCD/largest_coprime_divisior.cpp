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

int solve(int A, int B);
int gcd(int A, int B);

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.precision(10);
    cout << fixed;
// #ifdef LOCAL_DEFINE
//     freopen("input.txt", "rt", stdin);
// #endif

    int A, B;
    cin >> A >> B;
    cout << "Largest Co prime divisior is: " << solve(A, B) << "\n";


#ifdef LOCAL_DEFINE
    cerr << "Time elapsed: " << 1.0 * clock() / CLOCKS_PER_SEC << " s.\n";
#endif
    return 0;
}

int gcd(int A, int B) {
    if(B == 0) return A;
    return gcd(B, A%B);
}

int solve(int A, int B) {
    int res = 1;
    if(gcd(A, B) == 1) return A;
    for(int i = 2; i * i <= A; i += 1) {
        if(A%i == 0 && gcd(B, i) == 1) {
            res = max(res, i);
        }
        if(A%i == 0 && gcd(A/i, B) == 1) {
            res = max(res, A/i);
        }
    }

    return res;
}
