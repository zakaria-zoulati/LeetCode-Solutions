class Solution {
    public long countOfSubstrings(String s, int k) {
        int n = s.length() ; 
        long rs = 0L ; 
        int[] count = new int[128] ; 
        int vowels = 0 ; 
        boolean[] isVowel = new boolean[128] ; 
        isVowel['a'] = true ; 
        isVowel['e'] = true ; 
        isVowel['u'] = true ; 
        isVowel['i'] = true ; 
        isVowel['o'] = true ;
        int left = 0 ; 
        int cons = 0 ; 
        int back = 1 ;
        for( int i=0 ; i<n ; ++i ){
            char c = s.charAt(i) ; 
            if( isVowel[c] ){
                if( count[c]++ == 0 ){
                    vowels++ ; 
                }
            }else {
                cons++ ; 
            }
            if( vowels == 5 ){
                if( cons == k ){
                    while( isVowel[ s.charAt(left) ] && count[s.charAt(left) ] > 1  ){
                        back++ ; 
                        count[s.charAt(left)]-- ; 
                        left++ ; 
                    }
                    rs += back ; 
                }else if( cons > k ) {
                    back = 1 ; 
                    while( cons > k ){
                        while( isVowel[ s.charAt(left) ] ){
                            if( count[s.charAt(left)]-- == 1 ){
                                vowels-- ; 
                            }
                            left++ ; 
                        }
                        cons-- ; 
                        left++ ; 
                    }
                    if( vowels == 5 ){
                        while( isVowel[ s.charAt(left) ] && count[s.charAt(left) ] > 1  ){
                            back++ ; 
                            count[s.charAt(left)]-- ; 
                            left++ ; 
                        }
                        rs += back ; 
                    }
                }
            }
        }
        return rs ; 
    }
}