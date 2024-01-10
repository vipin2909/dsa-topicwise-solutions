#include<bits/stdc++.h>

using namespace std;

int getNumberOfPrimeFactors(int x) {
    int cnt = 0;
    for(int i = 2; i * i <= x; i += 1) {
        if(x % i == 0) {
            cnt += 1;
            while(x % i == 0) {
                x /= i;
            }
        }
    }

    if(x > 1) cnt += 1;
    return cnt;
}

int solve(int A) {
    int res[A+1];
    int cnt = 0;
    for(int i = 2; i <= A; i++) {
        int x = getNumberOfPrimeFactors(i);
        if(x == 2) cnt += 1;
    }
    return cnt;
}

int main() {
    int n;
    cin >> n;
    int res = solve(n);
    cout << "result will be: " << res << "\n";
}