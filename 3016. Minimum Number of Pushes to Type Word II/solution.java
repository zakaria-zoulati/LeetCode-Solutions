class Solution {
    public int minimumPushes(String word) {
        int n = word.length() ; 
        if( n <=8 ){
            return n ; 
        }
        int[] freq = new int[26] ; 
        for(int i=0 ;i<n ; i++){
            freq[ word.charAt(i) -'a']++ ; 
        } 
        Arrays.sort(freq) ; 
        int rs = 0 ; 
        int curr = 1 ;
        int counter = 0 ; 
        for(int i=25 ; i>=0 ; --i ){
            counter++ ;
            rs += (freq[i]*curr) ; 
            if( counter%8 == 0 ) curr++ ;
        }
        return rs ; 

    }
}