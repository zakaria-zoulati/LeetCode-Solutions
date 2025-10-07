from typing import List
from collections import deque
class Solution:
    def avoidFlood(self, rains: List[int]) -> List[int]:
        n = len(rains)
        ans = [2]*n
        q = deque( [] )
        m = { } 
        for i , rain in enumerate( rains ) :
            if rain > 0  :
                ans[i] = -1 
                if rain in m : 
                    if not q or q[-1] < m[ rain ] : 
                        return []
                    else : 
                        l = 0 
                        r = len(q) - 1 
                        while l < r : 
                            mid = l + ( r - l )//2 
                            if q[mid] > m[rain] : 
                                r = mid 
                            else :
                                l = mid + 1 
                        ans[ q[l] ] = rain 
                        del q[l]
                        m[ rain ] = i 
                else : 
                    m[ rain ] = i 
            else : 
                q.append(i) 
        return ans 
