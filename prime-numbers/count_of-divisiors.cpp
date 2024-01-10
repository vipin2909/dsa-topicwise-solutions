#include<iostream>
#include<vector>

using namespace std;

int spf[1000005]; // spf[x] = smallest prime factor of x
void sieve() {
    for(int i = 1; i <= 1000000; i += 1) {
        spf[i] = i;
    }
    for(int i = 2; i * i <= 1000000; ++i) {
        if(spf[i] == i) {
            for(int j = i * i ; j <= 1000000; j += i) {
                if(spf[j] == j) 
                   spf[j] = i;
            }
        }
    }
}

vector<int> solve(vector<int> &A) {
    sieve();
    // using prime factorization to get the number of divisors of every integer
    vector<int> sol;
    for(int i = 0; i < A.size(); i++) {
        int temp = A[i];
        int ans = 1;
        while(temp != 1) {
            int cnt = 1;
            int d = spf[temp];
            while(temp != 1 and temp % d == 0) {
                cnt += 1;
                temp /= d;
            }
            ans *= cnt;
        }
        sol.push_back(ans);
    }
    return sol;
}