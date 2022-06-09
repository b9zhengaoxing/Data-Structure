//leetcode 20
//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//        An input string is valid if:
//
//        Open brackets must be closed by the same type of brackets.
//        Open brackets must be closed in the correct order.
//
//
//        Example 1:
//
//        Input: s = "()"
//        Output: true
//        Example 2:
//
//        Input: s = "()[]{}"
//        Output: true
//        Example 3:
//
//        Input: s = "(]"
//        Output: false

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (character == '(' || character == '[' || character == '{') {
                stack.push(character);
            } else {
                if (stack.isEmpty())
                    return false;
                    char top = stack.pop();
                if (character == ')' && top != '(') {
                    return false;
                } else if (character == ']' && top != '[') {
                    return false;
                } else if (character == '}' && top != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty() == true;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        String test_string1 = "(])";
        String test_string2 = "()[]{}";
        String test_string3 = "(]";

        System.out.println(test_string1 + solution.isValid(test_string1));
        System.out.println(test_string2 + solution.isValid(test_string2));
        System.out.println(test_string3 + solution.isValid(test_string3));
    }
}
