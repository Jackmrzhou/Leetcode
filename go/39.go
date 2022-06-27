import "sort"

func combinationSum(candidates []int, target int) [][]int {
	sort.Ints(candidates)
	return dfs(candidates, []int{}, target)
}

func dfs(candidates []int, path []int, target int) [][]int {
	if target == 0 {
		return [][]int{path}
	}
	if target < 0 {
		return nil
	}
	var res [][]int
	for i := 0; i < len(candidates); i++ {
		dst := make([]int, len(path))
		copy(dst, path)
		p := dfs(candidates[i:], append(dst, candidates[i]), target-candidates[i])
		if p != nil {
			res = append(res, p...)
		}
		for j := i + 1; j < len(candidates); j++ {
			if candidates[i] != candidates[j] {
				i = j - 1
				break
			}
		}
	}
	return res
}