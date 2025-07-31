class Solution {
    public boolean isPalindrome(String s) {
        // remoce write spaces between words
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int right=s.length()-1;
        int left=0;
        while(left<right){

            if(s.charAt(left)!=s.charAt(right)){

                return false;

            }
            right--;
            left++;

        }
        return true;
    }
}