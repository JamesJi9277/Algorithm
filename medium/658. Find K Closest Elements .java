class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int index = bsearch(arr, x);
        int i = index, j = index;
        while(k - 1 > 0) {
            if(i == 0) {
                j++;
            } else if(j == arr.length - 1) {
                i--;
            } else if( Math.abs(arr[i-1] - x) <= Math.abs(arr[j+1] - x)) {
                i--;
            } else {
                j++;
            }
            k--;
        }
        
        for(int it = i; it <= j; it++) res.add(arr[it]);
        return res;
    }
    
    private int bsearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return start;
    }
}