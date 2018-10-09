public class Solution {
	public int min(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			nums[i] = map.get(nums[i]);
		}
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			int val = nums[i];
			if (val < 0) {
				continue;
			}
			while (val != i) {
				int temp = nums[val];
				nums[val] = -1;
				val = temp;
				swap++;
			}
			nums[i] = -1;
		}
		return count;
	}
}