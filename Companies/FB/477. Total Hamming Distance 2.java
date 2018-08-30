//On2, TLE
class Solution {
    public int totalHammingDistance(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                sum += count(nums[i], nums[j]);
            }
        }
        return sum;
    }
    private int count(int x, int y) {
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            int res = ((x >> i) & 1) ^ ((y >> i) & 1);
            if (res == 1) {
                sum++;
            }
        }
        return sum;
    }
}
// try to use hashmap to memo, still TLE
// need to come up a even quicker approach
class Solution {
    public int totalHammingDistance(int[] nums) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int xor = nums[i] ^ nums[j];
                if (map.containsKey(xor)) {
                    sum += map.get(xor);
                } else {
                    int temp = count(nums[i], nums[j]);
                    map.put(xor, temp);
                    sum += temp;
                }
            }
        }
        return sum;
    }
    private int count(int x, int y) {
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            int res = ((x >> i) & 1) ^ ((y >> i) & 1);
            if (res == 1) {
                sum++;
            }
        }
        return sum;
    }
}


class Solution {
    public int totalHammingDistance(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int temp = 0;
            for (int j = 0; j < nums.length; j++) {
                temp += (nums[j] >> i) & 1;
            }
            //becasue this is find two combination
            // so can * cannot is total of pair
            res += temp * (nums.length - temp);
        }
        return res;
    }
}


// one more write, bug free
class Solution {
    public int totalHammingDistance(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            int total = 0;
            for (int j : nums) {
                total += ((j >> i) & 1);
            }
            sum += total * (nums.length - total);
        }
        return sum;
    }
}