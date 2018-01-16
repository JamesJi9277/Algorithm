时间On空间On
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Deque<Integer> queue = new LinkedList<Integer>();
        for (int i : nums) {
            if (!queue.isEmpty() && queue.peekLast() != i) {
                queue.offer(i);
            } else if (queue.isEmpty()) {
                queue.offer(i);
            }
        }
        int i = 0;
        while (!queue.isEmpty()) {
            nums[i++] = queue.poll();
        }
        return i;
    }
}

时间On空间O1
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                count++;
            } else {
                nums[i - count] = nums[i];
            }
        }
        return nums.length - count;
    }
}