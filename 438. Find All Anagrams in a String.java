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

