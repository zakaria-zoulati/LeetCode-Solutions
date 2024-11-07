class Solution {
    public int largestCombination(int[] candidates) {
        int[] bits = new int[31]; 
        for( int num : candidates ){
            int i=0;
            while(num>0){
                if((num & 1 )==1){
                    bits[i]++; 
                }
                ++i; 
                num >>=1; 
            }
        }
        int rs = 0 ; 
        for( int i : bits )
            if(i>rs) rs = i ; 
        return rs ; 
    }
}