class Solution {
    public int candy(int[] ratings) {
        // int[] candies = new int[ratings.length];
        // Arrays.fill(candies, 1);
        int count = 0;
        int n = ratings.length;
        int[] result = new int[n];
        Arrays.fill(result, 1);
        int sum = 0;
        //left pass
        for (int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i-1]) {
                result[i] = result[i-1]+1;
            }
        }
        sum = result[n-1];
        for (int i = n -2; i >= 0; i--) {
            if(ratings[i] > ratings[i+1]) {
                result[i] = Math.max(result[i], result[i+1] + 1);
            }
            sum += result[i];
        }

        return sum;
    }
}