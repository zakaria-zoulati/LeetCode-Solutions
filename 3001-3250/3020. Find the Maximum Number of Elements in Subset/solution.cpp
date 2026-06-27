#include <bits/stdc++.h> 

using namespace std ; 

const int LIMIT = 31'623; 
class Solution {
public:
    int maximumLength(vector<int>& nums) {
        int n = nums.size() ; 
        bitset<LIMIT> freq1 , freq2 , after;  
        int start = INT_MAX ; 
        int end = -1 ; 
        int ones = 0 ; 
        int ans = 0 ; 
        for( int num : nums ){
            if( num == 1 ){
                ones++ ; 
            }else if( num < LIMIT ){
                start = min( start , num ) ; 
                end = max( end , num ) ; 
                if( !freq1[num] ){
                    freq1[num]=1 ; 
                }else {
                    freq2[num]=1;
                }
            }else {
                int r = sqrt(num);
                if( r * r == num ){
                    after[r]=1 ; 
                }
            }
        }
        ans = ((ones-1)/2)*2+1; 
        for( int i=start ; i<=end ; ++i ){
            if( freq1[i] ){
                if( freq2[i] ){ 
                    int curr = i ; 
                    int can = 2 ; 
                    while( true ){
                        if( curr * curr >= LIMIT ){
                            if( after[curr] ){
                                can++; 
                            }else {
                                can--; 
                            }
                            break ; 
                        }else {
                            curr *= curr; 
                            if( freq2[curr] ){
                                can += 2 ; 
                            }else {
                                if( freq1[curr] ){
                                    can++;
                                }else {
                                    can--; 
                                }
                                break ; 
                            }
                        }
                    }
                    ans = ( ans<can?can:ans );
                }else {
                   ans = ( ans==0?1:ans ); 
                }
            }
        }

        return ans;
    }
};