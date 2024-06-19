package com.demo.stack;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */
public class IsValid {



    public boolean isValid(String s) {
        int length = s.length();

        if (length % 2 == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        Character pop = null;
        for (int i = 0; i < length; i++) {
            switch (s.charAt(i)) {
                case '{':
                case '[':
                case '(':
                    stack.push(s.charAt(i));
                    break;
                case '}':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    pop = stack.pop();
                    if (pop != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    pop = stack.pop();
                    if (pop != '[') {
                        return false;
                    }
                    break;
                case ')':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    pop = stack.pop();
                    if (pop != '(') {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        IsValid isValid = new IsValid();
        System.out.println(isValid.isValid("){"));
    }
}
