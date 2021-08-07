object Solution extends SolBase {
    def rand10(): Int = {
        var num = 0;
        do {
            val r1 = rand7();
            val r2 = rand7();
            num = (r1 - 1) * 7 + r2;
        } while (num > 40);
        (num - 1) % 10 + 1;
    }
}