class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if( k <= numOnes ){
            return k ; 
        }else if( k<= numOnes + numZeros ){
            return numOnes ; 
        }else{
            int curr = 0 ; 
            int rs = 0 ; 
            while( k - curr > numOnes + numZeros ){
                numNegOnes-- ; 
                curr++ ; 
                rs-- ; 
            }
            while( curr < k && numOnes>0 ){
                rs++ ; 
                numOnes-- ; 
                curr++ ; 
            }

            if( curr<k  ){
                if( curr + numZeros >= k  ){
                    return rs ; 
                }else{
                    curr += numZeros ; 
                }
            }
            
            return rs ; 


        }

    }
}