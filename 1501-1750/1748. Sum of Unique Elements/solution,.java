class Solution {
    public int sumOfUnique(int[] nums) {
        int[] freq = new int[101] ; 
        for( int num : nums ){
            freq[num]++ ; 
        }
        int rs = 0 ; 
        for( int i=1 ; i<101 ; ++i ){
            if( freq[i] == 1  ) rs += i ; 
        }
        return rs ; 
    }
}