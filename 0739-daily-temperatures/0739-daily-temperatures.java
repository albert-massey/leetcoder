class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures.length == 0 || temperatures == null) return new int[0];
        Stack<Integer> st = new Stack<>();
        // st.push(0);
        int[] result = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                int popped = st.pop();
                result[popped] = i - popped;
            } 
            st.push(i);
        }
        return result;
    }
}