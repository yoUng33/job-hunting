class Solution {
    public int compress(char[] chars) {
        int idx = 0, count = 1;
        for(int i = 1; i<chars.length; i++){
            if(chars[i] == chars[idx]){
                count++;
            }else {
                if(count == 1){
                    count = 1;
                    idx++;
                }else{
                    String cStr = String.valueOf(count);
                    for(int j = 0; j<cStr.length(); j++){
                        chars[++idx] = cStr.charAt(j);
                    }
                    chars[++idx] = chars[i];
                    count = 1;
                }
            }
        }
        if(count > 1) {
            String cStr = String.valueOf(count);
            for(int j = 0; j<cStr.length(); j++){
                chars[++idx] = cStr.charAt(j);
            }
        }
        return idx+1;
    }

    public static void main(String[] args) {
        char[] chars = {'a','a','a','a','b','a'};
        Solution so = new Solution();
        so.compress(chars);
    }
}