package leetcodeJava;

class Solution {
    public int evalRPN(String[] tokens) {
        var stack = new LinkedList<Integer>();
        for (var token : tokens) {
            if (token.equals("-")) {
                var op1 = stack.removeLast();
                var op2 = stack.removeLast();
                stack.add(op2 - op1);
            } else if (token.equals("+")) {
                var op1 = stack.removeLast();
                var op2 = stack.removeLast();
                stack.add(op1+op2);
            } else if (token.equals("*")) {
                var op1 = stack.removeLast();
                var op2 = stack.removeLast();
                stack.add(op1*op2);
            } else if (token.equals("/")) {
                var op1 = stack.removeLast();
                var op2 = stack.removeLast();
                stack.add(op2 / op1);
            } else {
                stack.add(Integer.valueOf(token));
            }
        }
        return stack.removeLast();
    }
}
