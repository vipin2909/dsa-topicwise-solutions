#include<iostream>

using namespace std;

int solve(int n) {
    int i = 1, cnt = 0;
    while(i*i <= n) {
        cnt += 1;
        i += 1;
    }
    return cnt;
}


int main() {
    int n;
    cin >> n;
    int res = solve(n);
    cout << "Result: " << res << '\n';
    return 0;
}