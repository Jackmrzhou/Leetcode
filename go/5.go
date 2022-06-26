func longestPalindrome(s string) string {
	res := 0
	l, r := 0, 0
	for i := range s {
		ll, rr, res1 := expand(i, i, s, 0)
		if res1 > res {
			res = res1
			l = ll
			r = rr
		}
		ll, rr, res2 := expand(i, i+1, s, 0)
		if res2 > res {
			res = res2
			l = ll
			r = rr
		}
	}
	return s[l : r+1]
}

func expand(l, r int, s string, length int) (int, int, int) {
	if l < 0 || r >= len(s) {
		return l + 1, r - 1, length
	}
	if s[l] == s[r] {
		if l == r {
			return expand(l-1, r+1, s, length+1)
		}
		return expand(l-1, r+1, s, length+2)
	}
	return l + 1, r - 1, length
}