var letterMap = map[byte]string{
	'2': "abc",
	'3': "def",
	'4': "ghi",
	'5': "jkl",
	'6': "mno",
	'7': "pqrs",
	'8': "tuv",
	'9': "wxyz",
}

func letterCombinations(digits string) []string {
	if digits == "" {
		return []string{}
	}
	v := letterCombinations(digits[1:])
	if len(v) == 0 {
		for _, ch := range letterMap[digits[0]] {
			v = append(v, string(ch))
		}
		return v
	}
	var res []string
	for _, ch := range letterMap[digits[0]] {
		for i := range v {
			res = append(res, string(ch)+v[i])
		}
	}
	return res
}