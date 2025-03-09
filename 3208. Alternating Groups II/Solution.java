class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length ; 
        int rs = 0 ; 
        int curr = 1 ; 
        for( int i=1 ; i<n ; ++i ){
            if( colors[i] != colors[i-1] ){
                curr++; 
            }else {
                curr =1 ; 
            }
            if( curr >= k ){
                rs++ ; 
            }
        }
        for( int i=0 ; i<k-1 ; ++i ){
            if( i == 0 ){
                if( colors[n-1] != colors[i] ){
                    curr++ ; 
                }else {
                    break; 
                }
            }else {
                if( colors[i-1] != colors[i] ){
                    curr++; 
                }else {
                    break ; 
                }
            }
            if( curr >= k ){
                rs++ ; 
            }
        }
        return rs ; 
    }
}