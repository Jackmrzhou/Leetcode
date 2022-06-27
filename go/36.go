func isValidSudoku(board [][]byte) bool {
	for i := range board {
		used := map[int]bool{}
		for j := 0; j < len(board[i]); j++ {
			if !test(board[i][j], used) {
				return false
			}
		}
	}

	for i := range board {
		used := map[int]bool{}
		for j := 0; j < len(board[i]); j++ {
			if !test(board[j][i], used) {
				return false
			}
		}
	}

	for i := 0; i < 9; i++ {
		used := map[int]bool{}
		for j := 0; j < 9; j++ {
			if !test(board[i/3*3+j/3][j%3+i%3*3], used) {
				return false
			}
		}
	}
	return true
}

func digit(b byte) int {
	return int(b) - int('0')
}

func test(b byte, used map[int]bool) bool {
	if b == '.' {
		return true
	}
	if used[digit(b)] {
		return false
	}
	used[digit(b)] = true
	return true
}