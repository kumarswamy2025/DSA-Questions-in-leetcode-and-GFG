class Solution {
    public boolean isIsomorphic(String s, String t) {
           //  calling hashmap

        return hashmap(s, t);
    }

     // we can solve this problem using hashmap
    static boolean hashmap(String s, String t) {
        if (s.length() != t.length()) return false;

    Map<Character, Character> mapST = new HashMap<>();
    Map<Character, Character> mapTS = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
        char chS = s.charAt(i);
        char chT = t.charAt(i);

        // If already mapped, check if the mapping is consistent
        if (mapST.containsKey(chS)) {
            if (mapST.get(chS) != chT) return false;
        } else {
            mapST.put(chS, chT);
        }

        // Reverse mapping check to ensure no two chars from s map to same char in t
        if (mapTS.containsKey(chT)) {
            if (mapTS.get(chT) != chS) return false;
        } else {
            mapTS.put(chT, chS);
        }
    }

    return true;

    }
}