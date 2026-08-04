class Solution {
public:
    vector<int> findMissingElements(vector<int>& nums) {
        bitset<101> b(0) ; 
        int s = 101 , l = 0 ; 
        for( int num : nums ){
            b[num] = 1 ;
            l = max( l , num ) ; 
            s = min( s , num ) ; 
        }
        vector<int> res; 
        for( int i=s ; i<=l ; ++i ){
            if( !b[i] ){
                res.push_back(i) ;
            }
        }
        return res; 
    }
};