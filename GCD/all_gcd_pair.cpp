#include<bits/stdc++.h>
using namespace std;
int gcd(int A, int B) {
    if(B == 0) return A;
    return gcd(B, A%B);
}
vector<int> solve(vector<int> &A) {
    int N = A.size();
    unordered_map<int, int> m;
    vector<int> res;

    sort(A.rbegin(), A.rend());
    for(int i = 0; i < N; i++) {
        if(m[A[i]] > 0) {
            m[A[i]] -= 1;
        }
        else {
            for(int j = 0; j < res.size(); j++) {
                m[gcd(res[j], A[i])] += 2;
            }
            res.push_back(A[i]);
        }
    }
    return res;
}
int main() {
    int n;
    cin >> n;
    vector<int> A(n);
    for(int i = 0; i < n; i++) cin >> A[i];

    vector<int> ans = solve(A);
    for(int i = 0; i < ans.size(); i++) {
        cout << ans[i] << " ";
    }
    cout << "\n";
    return 0;
 }