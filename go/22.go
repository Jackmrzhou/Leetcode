import "strings"

func generateParenthesis(n int) []string {
	return dfs(0, n, "")
}

func dfs(left, n int, cur string) []string {
	if n == 0 {
		return []string{cur + strings.Repeat(")", left)}
	}
	res := []string{}
	// push
	res = append(res, dfs(left+1, n-1, cur+"(")...)
	// pop
	if left > 0 {
		res = append(res, dfs(left-1, n, cur+")")...)
	}

	return res
}