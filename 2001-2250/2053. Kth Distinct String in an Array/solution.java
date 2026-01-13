class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashSet<String> db = new HashSet<>() ; 
         HashSet<String> set = new HashSet<>() ; 
        int n = arr.length ; 
        for( int  i=0; i<n  ; i++  ){
            if( set.contains( arr[i] ) ){
                db.add( arr[i] ) ;
            }else {
                set.add( arr[i] ) ;
            }
        }   
        if( set.size() - db.size() < k  ){
            return "" ; 
        }else {
            for( int  i=0 ; i<n  ; i++){
                if( !db.contains( arr[i] ) ){
                    k-- ; 
                    if( k == 0 ){
                        return arr[i] ;
                    }
                }
            }
        }
        return "" ; 
    }
}