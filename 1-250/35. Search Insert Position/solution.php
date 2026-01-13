<?php
    class Solution {

        /**
         * @param Integer[] $nums
         * @param Integer $target
         * @return Integer
         */
        function searchInsert($nums, $target) {
            $n = count( $nums ) ; 
            for( $i = 0;  $i < $n ; ++$i ){
                if( $nums[ $i ] >= $target ){
                    return $i ; 
                }
            }
            return $n ; 
        }
    }
?>