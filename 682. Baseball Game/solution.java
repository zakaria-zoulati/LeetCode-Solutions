class Solution {
    public int calPoints(String[] operations) {
        int n = operations.length ; 
        int rs = 0 ; 
        int[] arr = new int[n+2] ; 
        int current = 0; 
        arr[current++] = 0 ;
        arr[current++] = 0 ;
        for( String item : operations ){
            if( item.equals("D") ){
                int a = arr[current-1]  ;
                rs += 2*a ; 
                arr[current++] = 2*a ;
            }else if( item.equals( "C" )){
                int a = arr[current-1 ] ; 
                current-- ; 
                rs -= a; 
            }else if( item.equals("+") ){
                int a = arr[current-1] + arr[current-2] ; 
                arr[current++] = a ; 
                rs += a; 
            }else {
                int a = Integer.parseInt( item ) ; 
                arr[current++] = a ; 
                rs += a ;
            }
        }
        return rs ; 
    }
}