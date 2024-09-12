class Solution {
public:
    const int mod= 1e9+7;
    long long solve(long long x, long long n){
        if(n==0) return 1;
        if(n%2==0){
            return solve((x*x)%mod, n/2);
        }
        else{
            return (x*solve(x, n-1))%mod;
        }
      }
    int countGoodNumbers(long long n) {
        long long even=n/2+n%2;
        long long odd=n/2;
        long long first=solve(5,even);
        long long second=solve(4,odd);
        long long ans= ((first)*(second))%mod;
        return ans;
    }
};