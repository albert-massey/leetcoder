class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
    //find the closest element index
        int clo = 0;
        List<Integer> result = new ArrayList<>();
        if(x <= arr[0]) clo = 0;
        else if(x >= arr[arr.length-1]) clo = arr.length-1;
        else{
            int low = 0;
            int high = arr.length-1;
            //1 5 10
            //h l
            while(low <= high) {
                int mid = low + (high-low)/2;
                if(arr[mid] == x) {
                    clo = mid;
                    break;
                }
                else if(arr[mid] < x) {
                    low = mid + 1;
                } else if(arr[mid] > x) {
                    high = mid -1;
                }
            }
        System.out.println(clo);
            if(low > high) {
                clo = low;
            }
            // if (low >= arr.length || (low > 0 && x - arr[low - 1] <= arr[low] - x)) {
            //     clo = low - 1;
            // } else {
            //     clo = low;
            // }        
        }
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
}