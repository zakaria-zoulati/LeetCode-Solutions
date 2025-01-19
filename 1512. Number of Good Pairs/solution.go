package solution

func numIdenticalPairs(nums []int) int {
    n := len(nums) 
    rs := 0
    f := make( []int , 101 )
    for i:=0 ; i<n ; i++ {
        f[nums[i]]++
    }
    for i:=1 ; i<=100 ; i++ {
        rs += ( f[i] )*( f[i] -1 )/2
    }
    return rs
}