<?php
        class Solution {
            /**
             * @param Integer $x
             * @param Integer $y
             * @return String
             */
            function winningPlayer($x, $y) {
                $count = min( $x , intdiv( $y , 4 ) ) ; 
                if( $count % 2 == 1 ){
                    return "Alice" ; 
                }else {
                    return "Bob" ; 
                }
            }
        }

?>