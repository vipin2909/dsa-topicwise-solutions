#include<bits/stdc++.h>
using namespace std;

int solve(vector<int> &A) {
    int N = A.size(), best = INT_MAX, xo = 0;
    sort(A.begin(), A.end());
    for(int i = 1; i < N; i++) {
        xo = A[i] ^ A[i-1];
        best = min(xo, best);
    }
    return best;
}
int main() {
    int n;
    cin >> n;
    vector<int> A(n);
    for(int i = 0; i < n; i++) {
        cin >> A[i];
    }

    int res = solve(A);
    cout << "Min Xor of two elements: " << res;
    return 0;
}