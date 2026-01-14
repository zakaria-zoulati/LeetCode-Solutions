#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    bool canJump(vector<int>& nums) {
        // I am thinking in the direction that 0 in nums array is the main problem
        // if i am at index where nums[i] = 0
        // I need to check whether i can go beyond this index or not
        // if i cannot return false
        // otherwise go to next index
        int mx_jump = 0;
        for (int i = 0; i < nums.size() - 1; i++) {
            mx_jump = max(mx_jump, i + nums[i]);
            if (nums[i] == 0 && mx_jump <= i) return false;
        }
        return true;
    }
};