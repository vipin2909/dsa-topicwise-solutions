#include<bits/stdc++.h>
using namespace std;
int gcd(int A, int B) {
    if(B == 0)
    return A;
    return gcd(B, A%B);
 }
int sol(int A, int B, int C) {
    int x = B * C /gcd(B, C);
    return A/x;
}
int main() {
    int A, B, C;
    cin >> A >> B >> C;
    int res = sol(A, B, C);
    cout << "Result: " << res << "\n";
    return 0;
}