// Time Complexity :O(L)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * Approach 1 - Using a counter for each type of paranthesis but this would have not worked because the order of closing 
 * also matters.
 * 
 * Approach 2 - 
 * 1 - Use a stack. For every opening paranthesis, add to the stack a matching paranthesis.
 * 2 - Compare the top of the stack with the incoming char - if it is not same then the order is not maintained and return
 * false
 */

public class ValidParanthesis {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        
        for(int i = 0; i < n; i++)
        {
            char c = s.charAt(i);
            if(c == '(')
                st.push(')');
            else if(c == '{')
                st.push('}');
            else if(c == '[')
                st.push(']');
            else if(st.isEmpty() || st.pop() != c)
                return false;
        }
        if(!st.isEmpty())
            return false;
        
        return true;
    }
}
