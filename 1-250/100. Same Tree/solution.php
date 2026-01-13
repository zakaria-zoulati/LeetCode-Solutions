<?php

    /**
     * Definition for a binary tree node.
     * class TreeNode {
     *     public $val = null;
     *     public $left = null;
     *     public $right = null;
     *     function __construct($val = 0, $left = null, $right = null) {
     *         $this->val = $val;
     *         $this->left = $left;
     *         $this->right = $right;
     *     }
     * }
     */
    class Solution {
        /**
         * @param TreeNode $p
         * @param TreeNode $q
         * @return Boolean
         */
        function isSameTree($p, $q) {
            if( $p == null && $q == null ){
                return true ; 
            }else if( $p == null || $q == null ){
                return false ; 
            }else {
                return $p->val == $q->val && $this->isSameTree( $p->right , $q->right ) && 
                $this->isSametree( $p->left ,  $q->left ) ; 
            }
        }
    }


?>