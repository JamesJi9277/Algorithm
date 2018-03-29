class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) {
            return result;
        }
        HashMap<Character, Integer> map = toHashMap(p);
        int size = map.size();
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    size--;
                }
                if (size == 0) {
                    result.add(left);
                }
            }
            right++;
            
            if (right - left == p.length()) {
                char c1 = s.charAt(left);
                if (map.containsKey(c1)) {
                    map.put(c1, map.get(c1) + 1);
                    if (map.get(c1) == 1) {
                        size++;
                    }
                }
                left++;
            }
            
        }
        return result;
    }
    private HashMap<Character, Integer> toHashMap(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
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

