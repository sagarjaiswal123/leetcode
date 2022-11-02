class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length()+s2.length()!=s3.length()){
            return false;
        }
        //return isInterleaveHelper(s1,s2,s3);
                final HashMap<String, Boolean> map = new HashMap<>();

        return isInterleaveHelper(s1,s2,s3,map,0,0,0);
    }

    private boolean isInterleaveHelper(String input1, String input2, String result) {

        if (result.length()+input1.length()+input2.length()==0) return true;
        
            final char prefixChar = result.charAt(0);
            if (input1.length()!= 0 && prefixChar == input1.charAt(0)){
                final boolean isInterleaved = isInterleaveHelper(input1.substring(1), input2, result.substring(1));
                if (isInterleaved) return isInterleaved;
            }
            if (input2.length()!=0 && prefixChar == input2.charAt(0)){
                final boolean isInterleaved = isInterleaveHelper(input1, input2.substring(1), result.substring(1));
                if (isInterleaved) return isInterleaved;
            }

        return false;
    }
    
private boolean isInterleaveHelper(String input1, String input2, String result, HashMap<String, Boolean> map, int inputIndex1, int inputIndex2, int resultIndex) {

        if (inputIndex1 == input1.length() && inputIndex2 == input2.length() && resultIndex == result.length())
            return true;

        final String key = input1.substring(inputIndex1) + "*" + input2.substring(inputIndex2) + "*" + result.substring(resultIndex);
        final Boolean interLeaved = map.get(key);
        if (interLeaved != null){
            return interLeaved;
        }

        if (inputIndex1<input1.length() && result.charAt(resultIndex) == input1.charAt(inputIndex1)){
            final boolean isInterleaved = isInterleaveHelper(input1, input2, result, map, inputIndex1 + 1, inputIndex2, resultIndex + 1);
            final String s1 = input1.substring(inputIndex1+1);
            final String s2 = input2.substring(inputIndex2);
            final String s3 = result.substring(resultIndex+1);
            map.put(s1+"*"+s2+"*"+s3,isInterleaved);
            if (isInterleaved) return isInterleaved;
        }

        if (inputIndex2<input2.length() && result.charAt(resultIndex) == input2.charAt(inputIndex2)){
            final boolean isInterleaved = isInterleaveHelper(input1, input2, result, map, inputIndex1 , inputIndex2 + 1, resultIndex + 1);
            final String s1 = input1.substring(inputIndex1);
            final String s2 = input2.substring(inputIndex2+1);
            final String s3 = result.substring(resultIndex+1);
            map.put(s1+"*"+s2+"*"+s3,isInterleaved);
            if (isInterleaved) return isInterleaved;
        }

        return false;
    }


    
}