https://leetcode.com/problems/remove-comments/discuss/115885/24-lines-simple-JAVA-solution-(One-pass)

public List<String> removeComments(String[] source) {
    List<String> list = new ArrayList<>();
    boolean cmtOn = false;
    StringBuilder str = new StringBuilder();        
    for (String s : source) {
        char[] line = s.toCharArray();
        int j = 0;            
        while (j < line.length) {
            if (line[j] == '/' && j < line.length-1 && line[j+1] == '/' && !cmtOn)
                break;            
            if (line[j] == '/' && j < line.length-1 && line[j+1] == '*' && !cmtOn) {
                cmtOn = true;
                j += 2;
            }            
            if (line[j] == '*' && j < line.length-1 && line[j+1] == '/' && cmtOn) {    
                cmtOn = false;
                j += 2;
                continue;
            }
            if (j < line.length && !cmtOn)
                str.append(line[j]);
            j++;
        }
        if (!cmtOn && str.length() > 0) {
            list.add(str.toString());
            str = new StringBuilder();
        }
    }
    return list;
}

https://leetcode.com/articles/remove-comments/