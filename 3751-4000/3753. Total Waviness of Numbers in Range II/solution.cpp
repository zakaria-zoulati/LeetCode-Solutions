#include <bits/stdc++.h>

using namespace std ; 

using ll = long long;
using vl = vector<ll>; 
using vvl = vector<vl>;
using vvvl = vector<vvl>; 

ll dp[16][100][2] ; 
ll nums[16] ; 

class Solution {
public:
    bool isGood( ll x , ll y , ll z ){
        if( y == x || y == z ) return false;  
        return ( x < y ) == ( z < y ) ; 
    }

    int digits( ll n ){
        int in = 0 ; 
        while( n > 0 ){
            nums[in++] = n%10 ; 
            n /= 10; 
        }
        return in ;
    }

    ll helper( ll n ){
        if( n < 100 ){
            return 0 ; 
        }
        
        int len = digits(n) ; 
        memset( dp , 0 , sizeof dp ) ; 

       ll suff = 0;     
       ll f = 1 ; 

       for( int i=2 ; i<len ; ++i ){
            ll curr = nums[i] * 10 + nums[i-1] ;  

            for( int j=0 ; j<100 ; ++j ){
                for( int k=0 ; k<10; ++k ){
                    ll x = j / 10 ; 
                    ll y = j % 10 ; 
                    dp[i][j][0] += dp[i-1][ y*10 + k ][0] ;
                    if( isGood( k , y , x ) ){
                        dp[i][j][0] += f ; 
                    }
                }
            }

            for( ll j=0 ; j<curr ; ++j ){
                ll z = j/10 ; 
                ll y = j%10 ;
                for( ll x = 0 ; x<10 ; ++x ){
                    dp[i][j][1] += dp[i-1][x+y*10][0] ; 
                    if( isGood( x , y , z ) ){
                        dp[i][j][1] += f ; 
                    }
                } 
            } 

            
            for( ll j = 0 ; j<10 ; ++j ){
                ll x = curr % 10 ; 
                ll y = curr / 10 ; 
                dp[i][curr][1] += dp[i-1][x*10+j][1]; 
                if( isGood( j,x,y )){
                    if( j <  nums[i-2] ) dp[i][curr][1] += f ;       
                    else if( j == nums[i-2] ) dp[i][curr][1] += suff+1 ;
                }
            }

            suff += nums[i-2]*f ;  
            f *= 10 ; 
       }


       ll ans = 0 ;
       for( int i=0; i<100 ; ++i ){
            ans += dp[len-1][i][1] ; 
       }
       
       f = 1 ; 
       ll pad = 0 ; 
       for( int i=2 ; i<len ; ++i ){
            pad += 45*f ; 
            f *= 10 ; 
       }

       return ans - pad;
    }

    ll totalWaviness(ll num1, ll num2) {
        ll ans = helper(num2) - helper(num1-1) ;
        return ans ; 
    }
};