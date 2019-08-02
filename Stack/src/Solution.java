import java.util.Stack;

class Solution {
    public boolean isValid(String s) {

        if(s.length() == 0){/*空串*/
            return true;
        }

        if(s.length()%2 !=0){ /*奇偶判断*/
            return false;
        }

        Stack<Character> stack = new Stack<>();
        Character char_i;
        for (int i = 0; i < s.length(); i++) {
            char_i = s.charAt(i);
            boolean can_push = (char_i == '(' || char_i == '[' || char_i == '{');

            if (can_push){/*有入栈*/
                stack.push(char_i);
            }else {
                if (!stack.empty()) {/*可以出栈*/
                    if (stack.peek() == '(' && char_i != ')') {
                        return false;
                    }
                    if (stack.peek() == '[' && char_i != ']') {
                        return false;
                    }
                    if (stack.peek() == '{' && char_i != '}') {
                        return false;
                    }
                    stack.pop();
                }else {/*不可以出栈*/
                    return false;
                }
            }
        }
        if (stack.empty()){/*出栈出完，匹配成功*/
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).isValid("[{()}]"));
        System.out.println((new Solution()).isValid("[{()}"));
        System.out.println((new Solution()).isValid(""));
    }
}