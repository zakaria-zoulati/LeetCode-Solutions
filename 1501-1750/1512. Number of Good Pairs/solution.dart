class Solution {
  int numIdenticalPairs(List<int> nums) {
    var n = nums.length ; 
    var rs = 0 ; 
    for( int i=0 ; i<n ; ++i ){
        for(int j=i+1 ; j<n ; ++j){
            if( nums[i] == nums[j] ){
                rs++ ; 
            }
        }
    }
    return rs ; 

  }
}