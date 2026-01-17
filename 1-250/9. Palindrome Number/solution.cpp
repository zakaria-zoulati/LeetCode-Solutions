#include<bits/stdc++.h>
using namespace std;
class Solution {
#define ll long long
public:
    bool isPalindrome(int x) {
        if (x < 0) return false;
        ll rev = 0;
        int temp = x;
        while (x) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return rev == temp;
    }
};