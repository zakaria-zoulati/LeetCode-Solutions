<?php

    /** 
     * The API guess is defined in the parent class.
     * @param  num   your guess
     * @return 	     -1 if num is higher than the picked number
     *			      1 if num is lower than the picked number
    *               otherwise return 0
    * public function guess($num){}
    */

    class Solution extends GuessGame {
        /**
         * @param  Integer  $n
         * @return Integer
         */
        function guessNumber($n) {
            $l = 1 ; 
            $r = $n ; 
            while( $l < $r ){
                $mid = intdiv( $l + $r , 2  ) ; 
                $curr = $this->guess( $mid ) ; 
                if( $curr == 0 ){
                    return $mid ; 
                }else if( $curr == -1 ){
                    $r = $mid  - 1 ;  
                }else {
                    $l = $mid + 1 ; 
                }
            }
            return $l ; 
        }
    }

?>