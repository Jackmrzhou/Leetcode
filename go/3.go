func lengthOfLongestSubstring(s string) int {
	indexMap := map[byte]int{}
	l, r := 0, 0
	res := 0
	for r < len(s) {
		if i, ok := indexMap[s[r]]; ok {
			for k, v := range indexMap {
				if v < i {
					delete(indexMap, k)
				}
			}
			l = i + 1
		}
		indexMap[s[r]] = r

		if r-l+1 > res {
			res = r - l + 1
		}
		r++
	}
	return res
}