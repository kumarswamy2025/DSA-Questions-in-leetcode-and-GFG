class Solution {
    public String reverseWords(String s) {
        // here we separate words with space
         // Split by one or more spaces
        String[] words = s.trim().split("\\s+");

        StringBuilder res=new StringBuilder();
        // here we iterate each word from end and store in string builder class

        for(int i=words.length-1;i>=0;i--){
            res.append(words[i]+" ");

        }
        return res.toString().trim();
        
    }
}