class Solution {
    public:
        bool check( vector<int> &nums , int n , int k ){
            bool prev = false ;
            for( int i=0 ; i<n; ++i ){
                int curr = 1 ; 
                while( i+1<n && nums[i+1] > nums[i] ){
                    curr++ ;
                    ++i; 
                }
                if( curr >= k ){
                    if( curr>=2*k || prev ) return true ; 
                    prev = true ;
                }else {
                    prev = false ;
                }
            }
            return false ;
        }
        int maxIncreasingSubarrays(vector<int>& nums) {
            int n = nums.size() ;
            int l = 1 ; 
            int r = n/2 ; 
            while( l < r ){
                int mid = l + ( r - l + 1 )/2 ; 
                if( check( nums , n  , mid ) ){
                    l = mid ; 
                }else {
                    r = mid-1 ; 
                }
            }
            return l ; 
        }
    };