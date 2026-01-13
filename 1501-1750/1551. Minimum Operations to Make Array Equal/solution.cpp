class Solution {
public:
    int minOperations(int n) {
        int req=n,ans=0;
        
        for(int i=0;i<n/2;i++){
            ans += req - (2*i) -1;
        }
        return ans;
    }
};