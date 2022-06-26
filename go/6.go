func convert(s string, numRows int) string {
	if numRows == 1 {
		return s
	}
	res := ""
	for r := 1; r <= numRows; r++ {
		if r == 1 || r == numRows {
			for i := r; i <= len(s); i += 2*numRows - 2 {
				res += string(s[i-1])
			}
		} else {
			for i := r; ; {
				if i-2*r+2 > 0 {
					if i-2*r+2 > len(s) {
						break
					}
					res += string(s[i-2*r+2-1])
				}
				if i > len(s) {
					break
				}
				res += string(s[i-1])
				i += 2*numRows - 2
			}
		}
	}
	return res
}

/*
1    2n-1 2n-1+2n-2 = 4n-3
*/