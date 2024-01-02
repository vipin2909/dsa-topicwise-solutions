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

vi solve(string A) {
    int n = sz(A), k = 0, cnt = 0, best = 0, curr = 0, j = 0;
    vi arr(n);
    forn(i, n) {
      arr[k++] = A[i] == '1' ? -1 : 1;  
      cnt += (A[i] == '1' ? 1 : 0);
    } 
    vi res;
    if(cnt == n) return res;
    forn(i, n) {
        curr += arr[i];
        if(best < curr) {
            best = curr;
            res.clear();
            res.pb(j+1);
            res.pb(i+1);
        }
        else if(curr < 0) {
            curr = 0;
            j = i+1;
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

    string s;
    cin >> s;
    vi res = solve(s);
    if(sz(res) > 1)
    forn(i, sz(res)) cout << res[i] << "\t";
    else cout << "String contains all ones" << "\n";


#ifdef LOCAL_DEFINE
    cerr << "\nTime elapsed: " << 1.0 * clock() / CLOCKS_PER_SEC << " s.\n";
#endif
    return 0;
}

