class Solution {
    public int lengthOfLastWord(String s) {
         final int lastIndex = s.length();
        boolean foundAlphaChar = false;
        int wordLength = 0;

        for (int i = lastIndex-1; i >=0; i--) {
            final char currentChar = s.charAt(i);
            if (Character.isAlphabetic(currentChar)){
                foundAlphaChar = true;
                wordLength++;
            }
            if (foundAlphaChar && Character.isSpaceChar(currentChar)){
                break;
            }
        }

        return wordLength;
    }
}