// 这题比较基础有很多方法可以做
// 比如用额外空间存，排序后比较
// 比较取巧的是算两个数组的ASCII码的差值，这样多出来的就是那个新添加的了
class Solution {
    public char findTheDifference(String s, String t) {
        char[] array1 = s.toCharArray();
        char[] array2 = t.toCharArray();
        
        int asciis = 0;
        int asciit = 0;
        
        for(int i = 0; i < array1.length; i++){
            asciis += (int)array1[i];
        }
        
        for(int i = 0; i < array2.length; i++){
            asciit += (int)array2[i];
        }
        
        return (char)(asciit-asciis);
    }
}
