class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        this.result = new ArrayList<>();
        helper(num, 0, target, "", 0, 0);
        return result;
    }
    
    private void helper(String num, int pivot, int target, String path, long calc, long tail) {
        //base
        if(pivot == num.length()) {
            if(calc == target) {
                result.add(path);
            }
            return;
        }
        
        //logic
        for(int i = pivot; i < num.length(); i++) {
            //preceding zero
            if(num.charAt(pivot) == '0' && pivot != i) continue;
            long curr = Long.parseLong(num.substring(pivot, i+ 1));
            
            if(pivot == 0) {
                helper(num, i+1, target, path+curr, curr, curr);
            } else {
                //+
                helper(num, i+1, target, path+"+"+curr, calc + curr, curr);
                //-
                helper(num, i+1, target, path+"-"+curr, calc - curr, -curr);
                //*
                helper(num, i+1, target, path+"*"+curr, calc -tail + tail * curr, tail * curr);
            }
        }
        
    }
    
}