class Solution {
    public int calculate(String s) {
        // if(s == null || s.length() == 0) return 
        Stack<Integer> st = new Stack<>();
        s = s.trim();
        int i = 0;
        int curr = 0;
        char sign = '+';
        while(i < s.length()) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                curr = curr*10 + c -'0'; 
                if(i == s.length() - 1) {
                    if(sign == '-') {
                        curr = -curr;
                    }
                    st.push(curr);
                }
            } else if(c == '(') {
                if(sign == '-'){
                    st.push(-1);
                    st.push(Integer.MAX_VALUE);                    
                } else {
                    st.push(1);
                    st.push(Integer.MAX_VALUE);
                }
                sign = '+';
            } else if(c == ')') {
                if(sign == '-') {
                    curr = -curr;
                }
                while(st.peek() != Integer.MAX_VALUE) {
                    curr += st.pop();
                }
                st.pop();
                st.push(st.pop()*curr);
                curr = 0;
            } else if(c == '+') {
                if(sign == '-') {
                    curr = -curr;
                }
                st.push(curr);
                curr = 0;
                sign = '+';
            } else if(c == '-') {
                if(sign == '-') {
                    curr = -curr;
                }              
                st.push(curr);
                curr = 0;
                sign = '-';
            }
            i++;
        }
        int result = 0;
        while(!st.isEmpty()) {
            result += st.pop();
        }
        return result;
    }
}