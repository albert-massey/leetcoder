class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // Find the closest element index
        int clo = 0;
        List<Integer> result = new ArrayList<>();
        if (x <= arr[0]) {
            clo = 0;
        } else if (x >= arr[arr.length - 1]) {
            clo = arr.length - 1;
        } else {
            int low = 0;
            int high = arr.length - 1;
            while (low < high) { // Changed from `low <= high` to `low < high`
                int mid = low + (high - low) / 2;
                if (arr[mid] >= x) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            clo = low; // Set clo to low directly after the binary search
        }

        // Initialize two pointers to find the k closest elements
        int left = clo - 1;
        int right = clo;
        while (k > 0) {
            if (left < 0) {
                result.add(arr[right]);
                right++;
            } else if (right >= arr.length) {
                result.add(arr[left]);
                left--;
            } else if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                result.add(arr[left]);
                left--;
            } else {
                result.add(arr[right]);
                right++;
            }
            k--;
        }

        Collections.sort(result);
        return result;
    }

//     public static void main(String[] args) {
//         Solution solution = new Solution();
//         int[] arr1 = {1, 2, 3, 4, 5};
//         int k1 = 4;
//         int x1 = 3;
//         System.out.println(solution.findClosestElements(arr1, k1, x1)); // Output: [1, 2, 3, 4]

//         int[] arr2 = {1, 2, 3, 4, 5};
//         int k2 = 4;
//         int x2 = -1;
//         System.out.println(solution.findClosestElements(arr2, k2, x2)); // Output: [1, 2, 3, 4]

//         int[] arr3 = {2, 4, 4, 4, 4, 4, 10, 15};
//         int k3 = 2;
//         int x3 = 4;
//         System.out.println(solution.findClosestElements(arr3, k3, x3)); // Output: [4, 4]
//     }
}