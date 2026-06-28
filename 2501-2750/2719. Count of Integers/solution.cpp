#include <bits/stdc++.h>

using namespace std ; 

using ll = long long ; 
using vi = vector<int>;
using vvi = vector<vi>; 
using vvvi = vector<vvi>;

const int mod = 1e9 + 7; 

int dp[23][2][199] ; 

class Solution {
public:
    int helper(string &num , int mi , int ma ){
        int len = num.size() ; 
        reverse( num.begin() , num.end() ); 

        memset( dp , 0 , sizeof dp ) ; 
        
        for( int i=0 ; i<=min(ma,9) ; ++i ){
            dp[0][0][i] = 1 ; 
        }
        for( int i=0 ; i<=min(ma,num[0]-'0') ; ++i ){
            dp[0][1][i] = 1 ; 
        }

        for( int i=1 ; i<len ; ++i ){
            
            for( int j=0 ; j<=9 ; ++j ){
                for( int k=0 ; k+j<=ma ; ++k ){
                    dp[i][0][j+k] = ( dp[i][0][j+k] + dp[i-1][0][k] ) % mod ; 
                }
            }

            int d = num[i] - '0' ; 
            for( int j=0 ; j<=d-1 ; ++j ){
                for( int k=0 ; j+k<=ma ; ++k ){
                    dp[i][1][j+k] = ( dp[i][1][j+k] + dp[i-1][0][k] ) % mod ; 
                }
            }

            for( int j=0 ; j+d<=ma ; ++j ){
                dp[i][1][j+d] = ( dp[i][1][j+d] + dp[i-1][1][j] ) % mod ; 
            }
            

        }

        ll ans = 0 ;
        for( int i=mi ; i<=ma ; ++i ){
            ans += dp[len-1][1][i]  ; 
        }
        return (int) ( ans % mod ) ; 
    }
    int isValid( string &num , int mi , int ma ){
        int sum = 0 ; 
        for( char c : num ){
            sum += ( c-'0' ) ; 
        }
        return ( sum >= mi && sum <= ma ? 1 : 0 ) ; 
    }
    int count(string num1, string num2, int min_sum, int max_sum) {
        if( min_sum >= 9 *num2.size() ) return 0 ;
        if( min_sum >= 198 ) return 0 ;  
        max_sum = min( max_sum , min( 198 , 9*(int) num2.size() ) ) ; 
        int ans = ( helper( num2 , min_sum , max_sum ) - helper( num1 , min_sum , max_sum ) + isValid(num1,min_sum , max_sum ) + mod ) % mod ; 
        return ans ; 
    }
};