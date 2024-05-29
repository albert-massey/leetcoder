class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
        
    }
    
    private void helper(int[] candidates, int target, int pivot, List<Integer> path) {
        //base
        if(target < 0 || pivot == candidates.length) return;
        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        for(int i = pivot; i < candidates.length; i++) {
            path.add(candidates[i]);
            helper(candidates, target - candidates[i], i, path);
            path.remove(path.size() -1);
        }
    }
}