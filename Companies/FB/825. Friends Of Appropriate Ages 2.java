class Solution {
    public int numFriendRequests(int[] ages) {
        if (ages == null || ages.length == 0) {
            return 0;
        }
        // 根据年龄来穷举，然后再map里面根据排列组合找到count的总数
        int[] map = new int[121];
        for (int age : ages) {
            map[age]++;
        }
        int[] A = new int[121];
        int[] B = new int[121];
        int count = 0;
        for (int i = 1; i < 121; i++) {
            for (int j = 1; j < 121; j++) {
                if (j > i) {
                    continue;
                }
                if (j <= 0.5 * i + 7) {
                    continue;
                }
                if (j > 100 && i < 100) {
                    continue;
                }
                count += map[i] * map[j];
                if (i == j) {
                    count -= map[i];
                }
            }
        }
        return count;
    }
}