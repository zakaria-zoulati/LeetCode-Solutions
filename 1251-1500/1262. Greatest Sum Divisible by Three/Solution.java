class Solution {
    int MAX = Integer.MAX_VALUE ;
    public int maxSumDivThree(int[] nums) {
        int sum = 0 ; 
        int one1 = MAX ; 
        int one2 = MAX ; 
        int two1 = MAX ; 
        int two2 = MAX ; 

        for( int num : nums ){
            sum += num ;

            if( num % 3 == 1 ){
                if( num < one1 ){
                    one2 = Math.min( one2 , one1 ) ; 
                    one1 = num ; 
                }else if( num < one2 ){
                    one2 = num ; 
                }
            }else if( num % 3 == 2 ){
                if( num < two1 ){
                    two2 = Math.min( two2 , two1 ) ; 
                    two1 = num ; 
                }else if( num < two2 ){
                    two2 = num ; 
                }
            }
        }
        

        if( sum % 3 == 0 ){
            return sum ; 
        }

        if( sum % 3 == 1 ){
            int ans = 0; 
            if( one1 != MAX ){
                ans = sum - one1 ; 
            }
            if( two2 != MAX ){
                ans = Math.max( ans , sum - two1 - two2 ) ; 
            }
            return ans ; 
        }

        int ans = 0; 
        if( two1 != MAX ){
            ans = sum - two1 ; 
        }
        if( one2 != MAX ){
            ans = Math.max( ans , sum - one1 - one2 ) ; 
        }
        return ans ; 
    }
}