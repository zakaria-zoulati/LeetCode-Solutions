package solution

func scoreOfString(s string) int {
    abs := func(a int) int {
        if a < 0 {
            return -a
        }
        return a
    }

    rs := 0
    for i := 0; i < len(s)-1; i++ {
        rs += abs(int(s[i+1]) - int(s[i]))
    }
    return rs
}