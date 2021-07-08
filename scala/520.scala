object Solution {
    def detectCapitalUse(word: String): Boolean = {
        word(0).isUpper && word.slice(1, word.length).forall(_.isLower) || 
        word.forall(_.isLower) || word.forall(_.isUpper)
    }
}