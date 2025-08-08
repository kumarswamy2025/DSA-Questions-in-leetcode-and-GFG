class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
           // calling brute force apporach

        // return bruteForceApporach(ransomNote, magazine);


        //  calling hashmap apporach

       return hashamapApporach(ransomNote, magazine);
    }

     // we camm solve this problem using brute force apporach
    static boolean bruteForceApporach(String ransomNote, String magazine) {

        if (ransomNote.length() > magazine.length()) { // base case
            return false;
        }

        char[] m = magazine.toCharArray();
        boolean[] used = new boolean[m.length]; // to mark used characters

        for (int i = 0; i < ransomNote.length(); i++) {
            char r = ransomNote.charAt(i);
            boolean found = false;

            for (int j = 0; j < m.length; j++) {
                if (used[j]==false && r == m[j]) {
                    used[j] = true;
                    found = true;
                    break;
                }
            }

            if (!found)
                return false;
        }

        return true;

    }

    //  we can solve this using hashmap
    static boolean hashamapApporach(String ransomNote, String magazine){
          // Create a map to store character frequencies from the magazine.
    Map<Character, Integer> magazineFreq = new HashMap<>();
    
    // Fill the frequency map with characters from the magazine.
    for (char ch : magazine.toCharArray()) {
        magazineFreq.put(ch, magazineFreq.getOrDefault(ch, 0) + 1);
    }
    
    // Check against the frequency map with each character from ransomNote.
    for (char ch : ransomNote.toCharArray()) {
        // Check if the character is missing or not enough in the magazine.
        if (!magazineFreq.containsKey(ch) || magazineFreq.get(ch) == 0) {
            return false;
        }
        // Decrease the frequency count for the current character.
        magazineFreq.put(ch, magazineFreq.get(ch) - 1);
    }
    
    return true;
    }
}