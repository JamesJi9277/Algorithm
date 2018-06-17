class Solution {
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Pair> list = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            list.add(new Pair(entry.getKey(), entry.getValue()));
        }
        list.sort(null);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++){
            int count = list.get(i).value;
            char c = list.get(i).character;
            
            while(count > 0){
                sb.append(c);
                count--;
            }
        }
        
        return sb.toString();
    }
}
class Pair implements Comparable<Pair> {
    Character character;
    int value;
    public Pair() {};
    public Pair(Character c, int value) {
        this.character = c;
        this.value = value;
    }
    @Override
    public int compareTo(Pair that) {
        return that.value - this.value;
    }
}


class Solution {
    public String frequencySort(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Pair> list = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Pair pair = new Pair(entry.getKey(), entry.getValue());
            list.add(pair);
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (Pair pair : list) {
            int count = pair.getCount();
            char c = pair.getChar();
            while (count > 0) {
                sb.append(c);
                count--;
            }
        }
        return sb.toString();
    }
}
class Pair implements Comparable<Pair> {
    char c;
    int count;
    public Pair() {};
    public Pair(char c, int count) {
        this.c = c;
        this.count = count;
    }
    public int getCount() {
        return count;
    }
    public char getChar() {
        return c;
    }
    @Override 
    public int compareTo(Pair p1) {
        return p1.getCount() - this.getCount();
    }
}