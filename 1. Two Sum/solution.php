<?php 

    class Solution {
        /**
         * @param Integer[] $nums
         * @param Integer $target
         * @return Integer[]
         */
        function twoSum($nums, $target) {
            $n = count( $nums ) ; 
            $map = [ ] ;
            for( $i = 0 ; $i < $n ; ++$i  ){
                $curr = $target - $nums[$i] ; 
                if( isset( $map[$curr] ) ){
                    return [ $i , $map[ $curr ] ] ; 
                } 
                $map[ $nums[$i] ] = $i ; 
            }
            return [ ] ; 
        }
    }


?>