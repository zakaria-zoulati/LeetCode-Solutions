class Solution:
    def minimumAbsDifference(self, arr: List[int]) -> List[List[int]]:
        ans = [] 
        arr.sort() 
        diff = float( 'inf' )
        for i in range( 1 , len(arr) ) : 
           curr = arr[i] - arr[i-1]
           if curr == diff : 
                ans.append( [ arr[i-1] , arr[i] ] )
           elif curr < diff : 
                diff = curr
                ans = [[arr[i-1],arr[i]]]

        return ans 