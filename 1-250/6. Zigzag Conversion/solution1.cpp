#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    string convert(string s, int numRows) {
        if (numRows == 1) return s;
        vector<vector<char>> str(numRows);
        int n = 0, f = 1;
        for (auto ch: s) {
            if (f) {
                str[n].push_back(ch);
                if (n == numRows - 1) {
                    f = 0;
                    n--;
                    continue;
                }
                n++;
            } else {
                str[n].push_back(ch);
                if (n == 0) {
                    f = 1;
                    n++;
                    continue;
                }
                n--;
            }
        }
        string ans = "";
        for (auto v: str) {
            for (auto ch: v) ans += ch;
        }
        return ans;
    }
};