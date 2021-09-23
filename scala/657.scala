object Solution {
    def judgeCircle(moves: String): Boolean = {
        moves.count(_ == 'R') == moves.count(_ == 'L') && moves.count(_ == 'U') == moves.count(_ == 'D')
    }
}
