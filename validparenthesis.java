import java.util.*;
class Solution {

    public boolean isValid(String input) {

        if (input.isEmpty()) {
            return true;
        } 
        else 
        {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < input.length(); i++) {
                char current = input.charAt(i);
                //System.out.println("current char " + current);
                if (current == '(' || current == '[' || current == '{') {
                    stack.push(current);
                } else {
                    if(stack.isEmpty()  ) {                   
                          return false;
                    }
                   
                    char peekChar = stack.peek();
                    System.out.println("peek char" + peekChar);
                    if ((current == ')' && peekChar != '(')
                            || (current == '}' && peekChar != '{')
                            || (current == ']' && peekChar != '[')) {
                        return false; 
                    } 

                    else {
                        stack.pop();
                    }
                }
                            //System.out.println("stack size now " + stack.size());
           
            }

            final Set<Character> set1 = new HashSet<Character>(Collections.list(stack.elements()));
            stack.clear();
            stack.addAll(set1);
            if (stack.size() == 1 || stack.size() == 2 || stack.size() ==3)
                    return false;
            return true; 
        }
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isValid(""));
        System.out.println(sol.isValid("()"));
        System.out.println(sol.isValid("()[]{}"));
        System.out.println(sol.isValid("(]"));
        System.out.println(sol.isValid("([)]"));
        System.out.println(sol.isValid("{[]}"));
    }

}
