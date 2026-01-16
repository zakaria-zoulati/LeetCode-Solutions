#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    string convert(string s, int numRows) {
        if (numRows == 1) return s;
        string ans = "";
        int cycle = numRows * 2 - 2, n = s.size();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycle) {
                ans += s[j + i];
                if (i != 0 && i != numRows - 1 && j + cycle - i < n) {
                    ans += s[j + cycle - i];
                }
            }
        }
        return ans;
    }
};
// Optimized Solution
// TC -> O(n)
// SC -> O(1) (No extra space) + O(n) (To store answer)