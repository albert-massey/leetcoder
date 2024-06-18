class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>(), result);
        return result;
        
    }
    private void helper(int[] candidates, int target, int idx, List<Integer> path, List<List<Integer>> result) {
        //base
        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if(target < 0 || idx == candidates.length) return;
        
        //logic
        helper(candidates, target, idx+1, path, result);
        
        path.add(candidates[idx]);
        helper(candidates, target-candidates[idx], idx, path, result);
        path.remove(path.size()-1);
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//     private void helper(int[] candidates, int target, int pivot, List<Integer> path) {
//         //base
//         if(target < 0 || pivot == candidates.length) return;
//         if(target == 0) {
//             result.add(new ArrayList<>(path));
//             return;
//         }
        
//         for(int i = pivot; i < candidates.length; i++) {
//             path.add(candidates[i]);
//             helper(candidates, target - candidates[i], i, path);
//             path.remove(path.size() -1);
//         }
//     }
}