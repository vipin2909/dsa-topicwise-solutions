/*
    Given two integers A and B, find the greatest possible positive integer M, such that A % M = B % M.
*/

#include<bits/stdc++.h>
using namespace std;
int solve(int A, int B) {
    return abs(A-B);
}
int main() {
    int n, m;
    cin >> n >> m;
    int res = solve(n, m);
    cout << "Result is: " << res << "\n";
    return 0;
}