package solution

func minBitFlips(start int, goal int) int {
    inter := start ^ goal 
    rs := 0 
    for inter >0 {
        rs += inter % 2 
        inter >>= 1
    }
    return rs 
}