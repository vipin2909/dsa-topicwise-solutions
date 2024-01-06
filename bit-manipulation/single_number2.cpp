#include<bits/stdc++.h>
using namespace std;

int solve(vector<int> &A) {
     vector<int> arr(32);
    int N = A.size();
    int res = 0;
    for(int i = 0; i < N; i++) {
        for(int j = 0; j < 32; j++) {
            if((A[i] & (1 << j)) != 0) {
                arr[j] += 1;
            }
        }
    }

    for(int i = 0; i < arr.size(); i++) {
        if(arr[i] % 3 != 0) {
            res |= (1 << i);
        }
    }

    return res;
}
int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    int n;
    cin >> n;
    vector<int> A(n);
    for(int i = 0; i < n; i++) cin >> A[i];
    int res = solve(A);
    cout << "number that appears for only one time is: " << res;
    return 0;
}