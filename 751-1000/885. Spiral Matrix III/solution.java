class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int bn = rows*cols ;
        int[][] result = new int[bn][2] ; 
         for(int i=0 ; i<bn ; ++i){
            result[i] = new int[2] ; 
        }
        int first = 0 ; 
        int current = 1 ; 
        int tour = 1 ;
        boolean flag = true ; 
        result[first][0] = rStart ; 
        result[first][1] = cStart ; 
        first++ ; 
        while( current != bn ){
           if( flag ){
                for(int i=0; i<tour ; ++i ){
                    cStart++  ;
                    if( current != bn  && cStart>=0 && cStart<cols && rStart>=0 && rStart<rows ){
                        result[ first ][0] = rStart ; 
                        result[ first++ ][1] = cStart ; 
                        current++ ; 
                    }
                }
                for(int i=0; i<tour ; ++i ){
                    rStart++  ;
                    if( current != bn  && cStart>=0 && cStart<cols && rStart>=0 && rStart<rows ){
                        result[ first ][0] = rStart ; 
                        result[ first++ ][1] = cStart ; 
                        current++ ; 
                    }
                }
           }else {
                for(int i=0; i<tour ; ++i ){
                    cStart--  ;
                    if( current != bn  && cStart>=0 && cStart<cols && rStart>=0 && rStart<rows ){
                        result[ first ][0] = rStart ; 
                        result[ first++ ][1] = cStart ; 
                        current++ ;  
                    }
                }
                for(int i=0; i<tour ; ++i ){
                    rStart--  ;
                    if( current != bn  && cStart>=0 && cStart<cols && rStart>=0 && rStart<rows ){
                         result[ first ][0] = rStart ; 
                        result[ first++ ][1] = cStart ; 
                        current++ ;  
                    }
                }
           }
           flag = !flag ; 
           tour++ ; 
        }
        return result ;
    }
}