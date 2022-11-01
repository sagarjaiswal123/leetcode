class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length()+s2.length()!=s3.length()){
            return false;
        }
           final HashMap<String, Boolean> map = new HashMap<>();
        return isInterleaveHelper(s1,s2,s3,map);
    }

    private boolean isInterleaveHelper(String input1, String input2, String result, HashMap<String, Boolean> map) {

       
        
        if (result.length()+input1.length()+input2.length()==0) return true;

        final String key = input1 + "*" + input2 + "*" + result;
        if (map.get(key)!=null){
            return map.get(key);
        }
            final char prefixChar = result.charAt(0);
            if (input1.length()!= 0 && prefixChar == input1.charAt(0)){
                final String s1 = input1.substring(1);
                final String s2 = input2;
                final String s3 = result.substring(1);
                
                final boolean isInterleaved = isInterleaveHelper(s1, s2, s3, map);
                map.put(s1+"*"+s2+"*"+s3,isInterleaved);
                if (isInterleaved) return isInterleaved;
            }
            if (input2.length()!=0 && prefixChar == input2.charAt(0)){
                final String s1 = input1;
                final String s2 = input2.substring(1);
                final String s3 = result.substring(1);
                final boolean isInterleaved = isInterleaveHelper(s1, s2, s3, map);
                map.put(s1+"*"+s2+"*"+s3,isInterleaved);
                if (isInterleaved) return isInterleaved;
            }

        return false;
    }
}