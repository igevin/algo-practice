func climbStairs(n int) int {
	if n < 2 {
		return 1
	}
	i, j := 1, 1
	for k := 2; k <= n; k++ {
		i, j = j, i+j
	}
	return j
}