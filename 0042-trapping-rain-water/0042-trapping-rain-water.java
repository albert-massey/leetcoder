class Solution {
    //[0,1,0,2,1,0,1,3,2,1,2,1]
    //[0,0,1,1,2,2,2,2,3,3,3,3]
    //[3,3,3,3,3,3,3,2,2,2,1,0]
    public int trap(int[] height) {
        int[] leftMaxArr = new int[height.length];
        int[] rightMaxArr = new int[height.length];
        int lMax = 0;
        for(int i = 0; i < leftMaxArr.length; i++) {
            leftMaxArr[i] = lMax;
            lMax = Math.max(lMax, height[i]);
            // System.out.print(" "+leftMaxArr[i]);
        }
        int rMax = 0;
        for(int i = rightMaxArr.length-1; i >= 0; i--) {
            rightMaxArr[i] = rMax;
            rMax = Math.max(rMax, height[i]);
            System.out.print(" "+rightMaxArr[i]);
        }
        int result = 0;
        for(int i = 0; i < height.length; i++) {
            System.out.print("i= "+i);
            if(Math.min(leftMaxArr[i], rightMaxArr[i]) > height[i]){
                result+= Math.min(leftMaxArr[i], rightMaxArr[i]) - height[i];
            }
        }
        return result;
    }
}