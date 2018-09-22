// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
import java.util.List;
import java.util.*;
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<String> subStringsKDist(String inputStr, int num)
	{
        List<String> res = new ArrayList<>();
        // sanity check
        if (inputStr == null || inputStr.length() == 0 || num < 1) {
            return res;
        }
        // for dedup purpose
        Set<String> set = new HashSet<>();
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < inputStr.length(); i++) {
            char c = inputStr.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
                count++;
            } else {
                map.put(c, map.get(c) + 1);
                if (map.get(c) == 1) {
                    count++;
                }
            }
            if (i - num >= 0) {
                map.put(inputStr.charAt(i - num), map.get(inputStr.charAt(i - num)) - 1);
                if (map.get(inputStr.charAt(i - num)) == 0) {
                    count--;
                }
            }
            if (count == num) {
                String temp = inputStr.substring(i - num + 1, i + 1);
                if (set.add(temp)) {
                    res.add(temp);
                }
            }
        }
        return res;
    }
    // METHOD SIGNATURE ENDS
}