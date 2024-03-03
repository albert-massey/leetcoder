class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            char c = s.charAt(0);
            if(Character.isDigit(c) || (c == '-' && s.length() > 1)) {
                int num = Integer.parseInt(s);
                st.push(num);
            } else if (c == '+') {
                int second = st.pop();
                int first = st.pop();
                int result = first + second;
                st.push(result);
            } else if (c == '-') {
                int second = st.pop();
                int first = st.pop();
                int result = first - second;
                st.push(result);
            } else if (c == '*') {
                int second = st.pop();
                int first = st.pop();
                int result = first * second;
                st.push(result);
            } else if (c == '/') {
                int second = st.pop();
                int first = st.pop();
                int result = first / second;
                st.push(result);
            }
        }
        return st.pop();
    }
}