class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < 2*n; i++) {
            int k = i % n;
            while(!st.isEmpty() && nums[k] > nums[st.peek()]) {
                int popped = st.pop();
                result[popped] = nums[k];
            }
            if(i < n) {
                st.push(k);            
            }
        }
        return result;
    }
}