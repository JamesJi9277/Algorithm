class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return result;
        }
        HashMap<Character, Integer> map = convertToHashMap(p);
        int left = 0;
        int right = 0;
        int size = map.size();
        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                if (map.get(s.charAt(right)) == 0) {
                    size--;
                }
                if (size == 0) {
                    result.add(left);
                }
            }
            right++;
            
            if (right - left == p.length()) {
                char c = s.charAt(left);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                    // 如果不等于1等于2之类的说明后面有重复的，就算不更改size也无所谓
                    if (map.get(c) == 1) {
                        size++;
                    }
                }
                left++;
            }
        }
        return result;
    }
    private HashMap<Character, Integer> convertToHashMap(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                int count = map.get(s.charAt(i));
                map.put(s.charAt(i), ++count);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        return map;
    }
}



class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        if (s == null || p == null || s.length() == 0 || p.length() == 0) {
            return result;
        }
        String standard = toStandard(p);
        for (int i = 0; i <= s.length() - p.length(); i++) {
            String sub = s.substring(i, i + p.length());
            if (toStandard(sub).equals(standard)) {
                result.add(i);
            }
        }
        return result;
    }
    
    private String toStandard(String s) {
        char[] array = s.toCharArray();
        Arrays.sort(array);
        return Arrays.toString(array);
    }
}

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        if (s == null || p == null || s.length() == 0 || p.length() == 0) {
            return result;
        }
        HashSet<String> set = new HashSet<String>();
        set.add(toStandard(p));
        for (int i = 0; i <= s.length() - p.length(); i++) {
            String sub = s.substring(i, i + p.length());
            if (set.contains(toStandard(sub))) {
                result.add(i);
            }
        }
        return result;
    }
    private String toStandard(String s) {
        char[] array = s.toCharArray();
        Arrays.sort(array);
        return Arrays.toString(array);
    }
}

