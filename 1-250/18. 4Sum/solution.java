class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length ; 
        List<List<Integer>> rs = new ArrayList<>() ; 
        if( n < 4 ) return rs ; 
        Arrays.sort( nums ) ;
        for( int i=0 ; i+3<n ; ++i ){
            for( int j = n-1 ; j>=i+3 ; --j ){ 
                long curr = nums[i] + nums[j] ; 
                int left = i+1 ; 
                int right = j-1 ; 
                while( left < right   ){
                    if(nums[left] + nums[right] == target - curr ){
                        List<Integer> list = new ArrayList<>() ; 
                        list.add( nums[i] ) ; 
                        list.add( nums[j] ) ; 
                        list.add( nums[left]) ; 
                        list.add( nums[right]) ; 
                        while( left+1<n && nums[left+1] == nums[left] ){
                            ++left ; 
                        }
                        left++ ;
                        right-- ; 
                        rs.add(list) ; 
                    }else if( nums[left] + nums[right] > target - curr ){
                        right-- ; 
                    }else {
                        left++ ; 
                    }
                }
                while( j-1 >=0 && nums[j-1]==nums[j] ){
                    --j ; 
                }
            }
            while( i+3<n && nums[i+1] == nums[i] ){
                ++i ; 
            }
        }
         
        return rs ; 
    }
}