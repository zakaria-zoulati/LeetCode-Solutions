class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n = nums1.length ; 
        int m = nums2.length ; 
        int len = 0 ; 
        int[] f = new int[1_001] ; 
        for( int[] i : nums1 ){
            if( f[ i[0] ]++ == 0 ) len++ ; 
        }
        for( int[] j : nums2 ){
            if( f[ j[0] ]++ == 0 ) len++ ; 
        }
        int[][] rs = new int[ len ][2] ; 
        int idx1 = 0 ; 
        int idx2 = 0 ; 
        int i = 0 ; 
        while( idx1 < n && idx2 < m  ){
            if( nums1[idx1][0] < nums2[idx2][0]  ){
                rs[i++] = nums1[idx1++] ; 
            }else if( nums1[idx1][0] > nums2[idx2][0] ){
                rs[i++] = nums2[idx2++] ; 
            }else {
                rs[i++] = new int[]{ nums1[idx1][0] ,nums1[idx1++][1] + nums2[idx2++][1]  } ;
            }
        }
        while( idx1 < n ){
            rs[i++] = nums1[idx1++] ;  
        }
        while( idx2 < m ){
            rs[i++] = nums2[idx2++] ; 
        }
        return rs ;  
    }
}