/*
    You are given a number A and a number B. Greatest Common Divisor (GCD) of all numbers between A and B inclusive is taken (GCD(A, A+1, A+2 ... B)).
    As this problem looks a bit easy, it is given that numbers A and B can be in the range of 10100.

    You have to return the value of GCD found.

    The greatest common divisor of 2 numbers, A and B, is the largest number, D that divides both A and B perfectly.
*/

#include<iostream>
using namespace std;

string solution(string A, string B) {
    return A == B ? A : "1";
}
int main() {
    string A, B;
    cin >> A >> B;
    string sol = solution(A, B);
    cout << "Result Is: " << sol << "\n";
    return 0;
}

// approach used is if A and B are not equal then for any A, A+1 pair gcd is 1.