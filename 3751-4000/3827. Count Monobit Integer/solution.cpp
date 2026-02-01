#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    int countMonobit(int n) {
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            if ((i & (i + 1)) == 0) ans++;
        }
        return ans;
    }
};