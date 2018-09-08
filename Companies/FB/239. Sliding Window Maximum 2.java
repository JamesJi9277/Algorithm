// Time  nlogk, Space Ok
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> queue = new LinkedList<>();
        int index = 0;
        for (int i : nums) {
            if (pq.size() < k) {
                pq.offer(i);
                queue.offer(i); 
                continue;
            }
            // size is k, can get max
            int prev = queue.poll();
            queue.offer(i);
            res[index] = pq.peek();
            pq.remove(prev);
            pq.offer(i);
            index++;
        }
        res[index] = pq.peek();
        return res;
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            left[i] = (i == 0) ? nums[0] : (i % k == (k - 1)) ? nums[i] : Math.max(nums[i], left[i - 1]);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            right[i] = (i == nums.length - 1) ? nums[nums.length - 1] : (i % k == (k - 1)) ? nums[i] : Math.max(nums[i], right[i + 1]);
        }
        for (int i = 0; i < res.length; i++) {
            res[i] = Math.max(right[i], left[i + k - 1]);
        }
        return res;
    }
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] leftMax = new int[nums.length];
        int[] rightMax = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                leftMax[0] = nums[0];
            } else if (i % k == 0) {
                leftMax[i] = nums[i];
            } else {
                leftMax[i] = Math.max(leftMax[i - 1], nums[i]);
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                rightMax[i] = nums[i];
            } else if (i % k == 0) {
                rightMax[i] = nums[i];
            } else {
                rightMax[i] = Math.max(rightMax[i + 1], nums[i]);
            }
        }
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = Math.max(rightMax[i], leftMax[i + k - 1]);
        }
        return res;
    }
}
}