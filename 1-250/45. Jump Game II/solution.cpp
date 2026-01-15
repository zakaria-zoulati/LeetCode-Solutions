#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    int jump(vector<int>& nums) {
        int mx_jump = 0, curr_jump = 0, jumps = 0;
        // for each jump, you must jump to next mx_jump index
        for (int i = 0; i < nums.size() - 1; i++) {
            mx_jump = max(mx_jump, nums[i] + i);
            if (curr_jump == i) {
                curr_jump = mx_jump;
                jumps++;
            }
        }
        return jumps;
    }
};