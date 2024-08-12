class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length ;
        int product = 1 ; 
        int[] rs = new int[n] ;
        int flag = 0 ;
        for(int i=0 ; i<n ; i++){
            if(nums[i]!=0){
                 product = product * nums[i] ;
            }
            else {
                flag++ ;
            }
        }
        for(int j=0 ; j<n; j++){
            if(nums[j]!=0  ){
                if(flag==0){
                    rs[j] = product/nums[j] ;
                }
                else{
                    rs[j] =0 ;
                }
                
            }
            else {
                if(flag==1){
                    rs[j] = product ;
                }
               
            }
            
        }
        return rs ;
    }
}