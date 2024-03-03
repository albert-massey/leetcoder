class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;  
        int n = nums.length;
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        q.add(0);
        set.add(0);
        while(!q.isEmpty()) {// 2 3 0 1 4
            int currIdx = q.poll(); // 0
            for(int i = 1; i <= nums[currIdx]; i++) {
                int newIdx = currIdx + i;
                if(newIdx >= n -1)  return true;
                if(!set.contains(newIdx)){
                    q.add(newIdx);
                    set.add(newIdx);
                }
            }
        }
        return false;
    }
}