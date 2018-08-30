class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if (S == null || S.length() < 3) {
            return ans;
        }
        
        int len = S.length();
        
        for (int i = 1; i < len; i++) {
            int count = 1;
            
            while(i < len && S.charAt(i) == S.charAt(i - 1)) {
                count++;
                i++;
            }
                        
            if(count > 2) {
                ans.add(Arrays.asList(i - count, i - 1));
            }
        }
        
        return ans;
    }
}