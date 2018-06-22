class Solution {
    // 排序
    // PQ
    // quick select
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i : nums) {
            pq.offer(i);
        }
        int count = nums.length - k + 1;
        while (--count > 0) {
            pq.poll();
        }
        return pq.poll();
    }
}

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return findKth(nums, nums.length - k + 1, 0, nums.length - 1);
    }
    private int findKth(int[] nums, int k, int start, int end) {
        int left = start;
        int right = end;
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] > pivot) {
                right--;
            }
            if (left < right) {
                nums[left] = nums[right];
                left++;
            }
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            if (left < right) {
                nums[right] = nums[left];
                right--;
            }
        }
        nums[left] = pivot;
        if (left + 1 == k) {
            return pivot;
        } else if (left + 1 < k) {
            return findKth(nums, k, left + 1, end);
        } else {
            return findKth(nums, k, start, left - 1);
        }
    }
}



class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) {
            return 0;
        }
        // Onlogn
        // Arrays.sort(nums);
        // return nums[nums.length - k];
        // On, Onlogn
        // Comp comp = new Comp();
        // PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, comp);
        // for (int i : nums) {
        //     if (pq.isEmpty()) {
        //         pq.offer(i);
        //     } else if (pq.size() < k) {
        //         pq.offer(i);
        //     } else if (pq.size() == k && i > pq.peek()) {
        //         pq.poll();
        //         pq.offer(i);
        //     }
        // }
        // return pq.peek();
        return findKth(nums, 0, nums.length - 1, nums.length - k + 1);
    }
    private int findKth(int[] nums, int start, int end, int k) {
        int left = start;
        int right = end;
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] > pivot) {
                right--;
            }
            if (left < right) {
                nums[left] = nums[right];
                left++;
            }
            while (left < right && nums[left] < pivot) {
                left++;
            }
            if (left < right) {
                nums[right] = nums[left];
                right--;
            }
        }
        nums[left] = pivot;
        if (left + 1 == k) {
            return pivot;
        } else if (left + 1 < k) {
            return findKth(nums, left + 1, end, k);
        } else {
            return findKth(nums, start, left - 1, k);
        }
    }
}
// class Comp implements Comparator<Comp> {
//     public Comp() {};
//     @Override
//     public int compare(Integer i, Integer j) {
//         return j - i;
//     }
// }