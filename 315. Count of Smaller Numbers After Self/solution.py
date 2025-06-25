from sortedcontainers import SortedList
class Solution:
    def countSmaller(self, nums: List[int]) -> List[int]:
        rs = [] 
        sl = SortedList() 
        for x in reversed(nums) : 
            index = sl.bisect_left(x)
            rs.append(index) 
            sl.add(x)

        return rs[ : : -1 ]