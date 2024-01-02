#include<bits/stdc++.h>
using namespace std;

vector<int> solve(int A, vector<vector<int>> &B) {
    vector<int> arr(A);
    for(int i = 0; i < B.size(); i++) {
        int st = B[i][0];
        int en = B[i][1];
        int val = B[i][2];

        arr[st-1] += val;
        if(en <= A-1) {
            arr[en] += (-1*val);
        }
    }
    vector<int> prefix(A);
    prefix[0] = arr[0];
    for(int i = 1; i < arr.size(); i++) {
        prefix[i] = prefix[i-1] + arr[i];
    }
    return prefix;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int beggers;
    cin >> beggers;

    vector<vector<int>> B(3);

    for(int i = 0; i < B.size(); i++) {
        vector<int> temp(3);
        for(int j = 0; j < temp.size(); j++) {
            cin >> temp[j];
        }
        B.push_back(temp);
    }
    vector<int> amount = solve(beggers, B);

    for(int i = 0; i < amount.size(); i++) {
        cout << amount[i] << "\t";
    }
    cout << '\n';
    return 0;
}