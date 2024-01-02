#include<bits/stdc++.h>
using namespace std;

int maxSubArray(const vector<int> &A) {
    int best = INT_MIN;
    int sum = 0;
    for(int i = 0; i < A.size(); i++) {
        sum = max(sum+A[i], A[i]);
        best = max(best, sum);
    }
    return best;
}


int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int n;
    cin >> n;
    vector<int> v(n);
    for(int i = 0; i < n; i++) {
        cin >> v[i];
    }

    int res = maxSubArray(v);

    cout << "Max Continoue subarray sum is: " << res << '\n';

}