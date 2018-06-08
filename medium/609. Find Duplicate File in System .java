class Solution {
    public static List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> result = new LinkedList<>();
        Map<String, LinkedList<String>> map = new HashMap<>();
        for(String path : paths){
            String[] tokens = path.split("\\s+");
            String directory = tokens[0];
            for(int itr=1; itr<tokens.length; itr++){
                int index = tokens[itr].indexOf("(");
                String content = tokens[itr].substring(index);
                String fileName = tokens[itr].substring(0, index);
                if(!map.containsKey(content)){
                    map.put(content, new LinkedList<>());
                }
                map.get(content).add(directory + "/" + fileName);
            }
        }
        for(List<String> value : map.values()){
            if(value.size() > 1){ result.add(value); }
        }
        return result;
    }
}