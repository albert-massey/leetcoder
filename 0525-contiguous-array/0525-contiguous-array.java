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
                // rSum[i] = sum;
            } else {
                sum++;
                // rSum[i] = sum;            
            }
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
            if(map.containsKey(sum)) {
                int diff = i - map.get(sum);
                max = Math.max(max, diff);
            }
        } 
        System.out.println(rSum);
              
        return max;
    }
}