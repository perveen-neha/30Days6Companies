
// QUESTION: https://leetcode.com/problems/evaluate-reverse-polish-notation/


class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length==1) return Integer.parseInt(tokens[0]);
        Stack<Integer> st = new Stack<>();
        int ans=0;
        for(String s: tokens)
        {
            if(s.equals("+") ||s.equals("-") ||s.equals("*") ||s.equals("/") )
            {
                char c=s.charAt(0);
                int y=st.pop();
                int x=st.pop();
                ans = evaluate(x,y,c);
                st.push(ans);
            }
            else
            {
                st.push(Integer.parseInt(s));
            }
        }
        return ans;
    }
    public int evaluate(int x, int y, char op)
    {
        switch(op)
        {
            case '+': return x+y;
            case '-': return x-y;
            case '*': return x*y;
            case '/': return x/y;
        }
        return 0;
    }
}