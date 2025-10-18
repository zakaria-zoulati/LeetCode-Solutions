# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def isCritical( self , a : int , b : int , c : int ) -> bool : 
        if a < b and c < b : 
            return True 
        if a > b and c > b : 
            return True 
        return False 

    def nodesBetweenCriticalPoints(self, head: Optional[ListNode]) -> List[int]:
        if not head.next or not head.next.next : 
            return [-1,-1]
        prev = head.val 
        first_ind = -1 
        last_ind = -1 
        head = head.next 
        ind = 1 
        d = pow( 10 , 6 )
        while head.next : 
            if self.isCritical( prev , head.val , head.next.val ) : 
                if first_ind == -1 : 
                    first_ind = ind 
                else :
                    d = min( d , ind - last_ind )
                last_ind = ind 
            ind += 1 
            prev = head.val
            head = head.next 
        
        if last_ind == first_ind : 
            return [-1,-1]
        return [ d , last_ind - first_ind ]
