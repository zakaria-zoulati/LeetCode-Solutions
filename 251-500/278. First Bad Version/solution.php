<?php 
    /* The isBadVersion API is defined in the parent class VersionControl.
      public function isBadVersion($version){} */

      class Solution extends VersionControl {
        /**
         * @param Integer $n
         * @return Integer
         */
        function firstBadVersion($n) {
            $l = 1;
            $r = $n ; 
            while( $l < $r ){
                $mid = intdiv( $l + $r , 2 ) ; 
                if($this->isBadVersion($mid) ){
                    $r = $mid ; 
                }else {
                    $l = $mid + 1 ;
                }
            }  
            return $l ; 
        }
    }

?>
