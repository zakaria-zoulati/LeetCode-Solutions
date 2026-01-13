class Solution {
    public String numberToWords(int num) {
        if( num==0 ){
            return "Zero" ; 
        }
        int[] arr = new int[3] ; 
        arr[0] = (int) Math.pow( 10,3) ;
        arr[1] = (int) Math.pow( 10,6) ;
        arr[2] = (int)  Math.pow( 10,9) ;
        StringBuilder rs = new StringBuilder() ; 
        if( num >= arr[2] ){
            rs.append( third(num/arr[2]) )  ;
            rs.append(" Billion " )  ;
            num = num%arr[2] ; 
        }
        if( num >= arr[1] ){
             rs.append( third(num/arr[1]) )  ;
             rs.append(" Million " )  ;
            num = num%arr[1] ; 
        }
        if( num >= arr[0] ){
            rs.append( third(num/arr[0]) ) ; 
            rs.append( " Thousand " ) ;
            num = num%arr[0] ; 
        }
        if( num !=0 ){
            rs.append( third(num) ) ;
        }
        return rs.toString().trim() ; 
    }

    public String third( int n ){
        String[] helper = new String[100] ; 
        helper[1] = "One" ; 
        helper[2] = "Two" ; 
        helper[3] = "Three" ;  
        helper[4] = "Four" ; 
        helper[5] = "Five" ; 
        helper[6] = "Six" ; 
        helper[7] = "Seven" ; 
        helper[8] = "Eight" ; 
        helper[9] = "Nine" ; 
        helper[10] = "Ten" ;
        helper[11] = "Eleven" ; 
        helper[12] = "Twelve" ; 
        helper[13] = "Thirteen" ; 
        helper[14] = "Fourteen" ; 
        helper[15] = "Fifteen" ; 
        helper[16] = "Sixteen" ; 
        helper[17] = "Seventeen" ; 
        helper[18] = "Eighteen" ; 
        helper[19] = "Nineteen" ; 
        helper[20] = "Twenty" ; 
        helper[30] = "Thirty" ; 
        helper[40] = "Forty" ; 
        helper[50] = "Fifty" ; 
        helper[60] = "Sixty" ; 
        helper[70] = "Seventy" ; 
        helper[80] = "Eighty" ; 
        helper[90] = "Ninety" ; 
        StringBuilder rs = new StringBuilder() ; 
        if( n>= 100 ){
            rs.append( helper[n/100] ) ; 
            rs.append( " Hundred " ) ; 
            n = n%100 ;
        }
        if( n!=0 && ( n%10 == 0 || ( n >=11 && n <= 19  ) || n<=9 ) ){
            rs.append( helper[n] ) ;
        }
        else if( n!=0 ){
            rs.append( helper[ (n/10)*10 ] + " " +  helper[n%10]  )  ;
        }
        return rs.toString().trim() ;
    }
}