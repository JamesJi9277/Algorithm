class Solution {
    public boolean validUtf8(int[] data) {
        int maskFirst = x0080, maskFirst2 = x00C0, maskFirst3 = x00E0, maskFirst4 = x00F0;
        int mask = 0, count = 0;
        for(int i = 0; i < data.length; i++){
            if(count == 0 && (maskFirst & data[i]) == 0) continue;
            if(count > 0){
                if((maskFirst & data[i]) == 0) return false;
                count--;
            }else if((maskFirst4 & data[i]) == maskFirst4 && (data[i] & x0008) != 0x0008){
                count = 3;
            }else if((maskFirst3 & data[i]) == maskFirst3 && (data[i] & x0010) != 0x0010){
                count = 2;
            }else if((maskFirst2 & data[i]) == maskFirst2 && (data[i] & x0020) != 0x0020){
                count = 1;
            }else{
                return false;
            }
        }
        return count == 0;
    }
}