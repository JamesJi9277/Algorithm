// naive On3
public int findTripleInversion1(int[] nums) {
    int count = 0;
    for (int i = 0; i < nums.length - 2; i++) {
      for (int j = i + 1; j < nums.length - 1; j++) {
        for (int k = j + 1; k < nums.length; k++) {
          if (nums[i] > nums[j] && nums[j] > nums[k]) {
            count++;
          }
        }
      }
    }
    return count;
  }



// set pivot, find left larger and find right smaller
public int findTripleInversion2(int[] nums) {
    int count = 0;
    for (int i = 1; i < nums.length - 2; i++) {
      count += helper(nums, 0, i - 1, nums[i], true);
      count += helper(nums, i + 1, nums.length - 1, nums[i], false);
    }
    return count;
  }



// BIT, logn

  public int findTripleInversion3(int[] nums) {
    List<Integer> bigger = countBigger(nums);
    List<Integer> smaller = countSmaller(nums);
    int count = 0;
    for (int i = 0; i < bigger.size(); i++) {
      count += (smaller.get(i) * bigger.get(i));
    }
    return count;
  }
  public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        for (int i = nums.length - 1; i >= 0; i--) {
            map.put(sorted[i], i);
        }
        int[] bit = new int[nums.length + 1];

        for (int i = nums.length - 1; i >= 0; i--) {
            int index = map.get(nums[i]);
            res.add(0, getSum1(bit, index));
            update1(bit, index + 1, 1);
        }
        return res;
    }
    private int getSum1(int[] bit, int index) {
        int sum = 0;
        for (int i = index; i > 0; i -= (i & (-i))) {
            sum += bit[i];
        }
        return sum;
    }
    private void update1(int[] bit, int index, int value) {
        
        for (int i = index; i < bit.length; i += (i & (-i))) {
            bit[i] += value;
        }
    }
  public List<Integer> countBigger(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < sorted.length; i++) {
            map.put(sorted[i], i);
        }
        int[] bit = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            int index = map.get(nums[i]);
            res.add(getSum(bit, index));
            update(bit, index, 1);
        }
        return res;
    }
    private int getSum(int[] bit, int index) {
        int sum = 0;
        for (int i = index + 1; i < bit.length; i += (i & (-i))) {
            sum += bit[i];
        }
        return sum;
    }
    private void update(int[] bit, int index, int value) {
        for (int i = index; i > 0; i -= (i & (-i))) {
            bit[i] += value;
        }
    }