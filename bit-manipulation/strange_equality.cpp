#include<bits/stdc++.h>
using namespace std;

int solve(int A) {
    int no_of_bits = (int) log2(A) + 1;
    int x = 0;
    // x is equal to the summation of unset bits in A
    for(int i = 0; i < no_of_bits; i++) {
        if(A & (1 << i)) continue;
        x += (1 << i);
    }

    // y equals to the power of 2 just greater than A
    int y = (1 << no_of_bits);

    int ans = (x ^ y);
    return ans;
}
int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int A;
    cin >> A;
    int res = solve(A);
    cout << "Result: " << res << "\n";
}