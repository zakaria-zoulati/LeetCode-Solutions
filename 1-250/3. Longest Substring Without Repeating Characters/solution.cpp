#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int n = s.size();
        vector<int> pos(128, -1);
        int mxLen = 0, previ = 0;
        for (int i = 0; i < n; i++) {
            if (pos[s[i]] != -1 && pos[s[i]] >= previ) {
                previ = pos[s[i]] + 1;
            } else {
                mxLen = max(mxLen, i - previ + 1);
            }
            pos[s[i]] = i;
        }
        return mxLen;
    }
};