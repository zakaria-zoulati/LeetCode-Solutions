class Solution {
    public int[] findArray(int[] pref) {
        int n = pref.length ; 
        int[] rs = new int[n] ; 
        rs[0] = pref[0] ;
        for(int i=1 ; i<n ; ++i ){
            rs[i] = pref[i]^pref[i-1] ; 
        }
        return rs ; 
    }
}