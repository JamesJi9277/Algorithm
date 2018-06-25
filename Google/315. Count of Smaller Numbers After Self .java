class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int[] count = new int[nums.length];
        int[] index = new int[nums.length];
        for (int i = 0; i < nums.length; i++) index[i] = i;
        mergeSort(nums, index, 0, nums.length, count);
        List<Integer> list = new ArrayList<>();
        for (int n : count) list.add(n);
        return list;
    }
    private void mergeSort(int[] nums, int[] index, int lo, int hi, int[] count) {
        if (lo > hi - 2) return;
        int mid = (lo + hi) / 2;
        mergeSort(nums, index, lo, mid, count);
        mergeSort(nums, index, mid, hi, count);
        int i = lo, j = mid, k = 0;
        int[] arr = new int[hi - lo];
        while (i < mid) {
            while (j < hi && nums[index[j]] < nums[index[i]]) {
                arr[k++] = index[j++];
            }
            count[index[i]] += k - (i - lo);
            arr[k++] = index[i++];
        }
        for (i = 0; i < k; i++) index[i + lo] = arr[i];
    }
}



// don't understand, fenwick tree
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = (nums[i] < min) ? nums[i]:min;
        }
        int[] nums2 = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums2[i] = nums[i] - min + 1;
            max = Math.max(nums2[i],max);
        }
        int[] tree = new int[max+1];
        for (int i = nums2.length-1; i >= 0; i--) {
            res.add(0,get(nums2[i]-1,tree));
            update(nums2[i],tree);
        }
        return res;
    }
    private int get(int i, int[] tree) {
        int num = 0;
        while (i > 0) {
            num +=tree[i];
            i -= i&(-i);
        }
        return num;
    }
    private void update(int i, int[] tree) {
        while (i < tree.length) {
            tree[i] ++;
            i += i & (-i);
        }
    }
}