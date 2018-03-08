// 这一题不是自己写
// 但是基本思想还是通过map来匹配并且来存取index信息来比较sum
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
    List<String> res = new LinkedList<>();
    int minSum = Integer.MAX_VALUE;
    for (int i=0;i<list1.length;i++) map.put(list1[i], i);
    for (int i=0;i<list2.length;i++) {
        Integer j = map.get(list2[i]);
        if (j != null && i + j <= minSum) {
            if (i + j < minSum) { res.clear(); minSum = i+j; }
            res.add(list2[i]);
        }
    }
    return res.toArray(new String[res.size()]);
    }
}