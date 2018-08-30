On, On
class Solution {
    public int removeDuplicates(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : nums) {
            if (!pq.contains(i)) {
                pq.offer(i);
            }
        }
        int index = 0;
        int size = pq.size();
        while (!pq.isEmpty()) {
            nums[index++] = pq.poll();
        }
        return size;
    }
}
On O1
// only modify first dup ele and set rest of dup as count
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int dup = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                dup++;
            } else {
                nums[i - dup] = nums[i];
            }
        }
        return nums.length - dup;
    }
}

public class Solution {
    /*
     * @param nums: An ineger array
     * @return: An integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int dup = 0;
        for (int i = 0; i < nums.length; i++) {
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                dup++;
                i++;
            }
            nums[i - dup] = nums[i];
        }
        return nums.length - dup;
    }
}