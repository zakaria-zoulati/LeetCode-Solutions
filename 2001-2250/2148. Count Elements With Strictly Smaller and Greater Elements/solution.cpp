class Solution {
public:
    int countElements(vector<int>& nums) {
        int n = nums.size() ; 
        if( n <=2  ) return 0; 
        sort(nums.begin() , nums.end()) ; 
        int count = 0 ; 
        for(int i=1 ; i<n-1 ; i++){
            while( i<n-1 &&  nums[i] > nums[0] && nums[i] < nums[n-1] ){
                count++ ;
                i++ ;
            }
        }
        return count ; 
    }
};