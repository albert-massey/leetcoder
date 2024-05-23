class Solution {
    public int findMaxLength(int[] nums) {
        if(nums.length == 1) return 0;
        int max = Integer.MIN_VALUE;
        int[] rSum = new int[nums.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for(int i= 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                sum--;
                rSum[i] = sum;
            } else {
                sum++;
                rSum[i] = sum;            
            }
            if(!map.containsKey(rSum[i])) {
                map.put(rSum[i], i);
            }
        } 
        System.out.println(rSum);
        for(int i= 1; i < rSum.length; i++) {
            if(map.containsKey(rSum[i])) {
                int diff = i - map.get(rSum[i]);
                max = Math.max(max, diff);
            }
        }        
        return max;
    }
}