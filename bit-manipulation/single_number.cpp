#include<bits/stdc++.h>
using namespace std;

int solve(vector<int> &A) {
    int xo = 0;
    for(int ele: A) {
        xo ^= ele;
    }
    return xo;
}
int main() {
    int n;
    cin >> n;
    vector<int> A(n);
    for(int i = 0; i < n; i++) cin >> A[i];
    int num = solve(A);
    cout << "number appears single time: " << num;
}