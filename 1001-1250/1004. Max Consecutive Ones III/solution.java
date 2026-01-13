class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length ; 
        int rs = 0; 
        int max = 0 ;
        int cons = k ; 
        int i = 0 ; 
        for( i=0 ; i<n; i++ ){
            if( nums[i] == 1 ){
                max++ ; 
            }
            else if( cons >0  ){
                max++ ; 
                cons-- ;
            }else {
                break ; 
            }
        }
        rs = max ;  
        for(int j=1 ; j<n ; j++){
            max-- ; 
            if( nums[j-1] ==1 ) continue  ;
            cons++ ; 
            while( i<n ){
                if( nums[i] == 1 ){
                    max++ ;
                    i++ ;
                }else {
                    if( cons>0 ){
                        cons-- ; 
                        max++ ; 
                        i++ ; 
                    }else break ; 
                }
           }
           rs = Math.max(rs,max) ; 
        }
        return rs ; 

    }
}