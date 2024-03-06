/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */

class Solution {
    public int search(ArrayReader reader, int target) {
        int left  = 0;
        int right = 1;
        while(target > reader.get(right)) {
                left = right;
                right *=2;
        }
        while(left<=right) {
            int mid  = (right-left)/2 + left;
            if(reader.get(mid) == target) {
                return mid;
            } else if (target < reader.get(mid)) {
                right = mid -1;
            } else if (target > reader.get(mid)) {
                left = mid + 1;
            }
        }  
        return -1;
    }
}