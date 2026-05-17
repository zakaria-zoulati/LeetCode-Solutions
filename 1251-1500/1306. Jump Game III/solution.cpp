#include <bits/stdc++.h>

using namespace std;

class Solution
{
public:
    bool canReach(vector<int> &arr, int start)
    {
        int n = arr.size();
        queue<int> q;
        vector<bool> seen(n, false);
        q.push(start);
        seen[start] = true;
        while (!q.empty())
        {
            int curr = q.front();
            q.pop();
            if (arr[curr] == 0)
            {
                return true;
            }
            int r = curr + arr[curr], l = curr - arr[curr];
            if (r < n && !seen[r])
            {
                q.push(r);
                seen[r] = true;
            }
            if (l >= 0 && !seen[l])
            {
                q.push(l);
                seen[l] = true;
            }
        }
        return false;
    }
};