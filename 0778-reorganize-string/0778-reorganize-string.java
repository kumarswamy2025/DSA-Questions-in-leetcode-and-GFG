class Solution {
    public String reorganizeString(String s) {
            // calling optimal apporach
        return optimalOpporach(s);
    }
    
    // we can solve this problem by arranging majarity ele first
    // video : https://www.youtube.com/watch?v=wZENBuWh-C0
    static String optimalOpporach(String s) {

        /*
         * Apporach : first find majority ele and then arange it and
         * base condiotions are :
         * condition-1: majarity ele length > len/2 then return ""
         * condition-2 : majarity ele length = len/2 then arrange it after leaving
         * single space
         * condition -3: majarity ele length < len/2 then arrange it after leaving
         * single space
         * 
         * 
         */

        // store frequency ele
        HashMap<Character, Integer> map = new HashMap<>();

        // finding freq each character
        for (int i = 0; i < s.length(); i++) {
            char data = s.charAt(i);
            if (map.containsKey(data)) {
                map.put(data, map.get(data) + 1);
            } else {
                map.put(data, 1);
            }
        }

        int majarity = 0; // store majarity ele
        char letter = ' '; // store majarity character
        // finding majarity ele and letter
        for (Character i : map.keySet()) {
            if (map.get(i) > majarity) {
                majarity = map.get(i);
                letter = i;
            }
        }

        // now checking condiiton-1 : if majarity > len+1/2 return " "
        if (majarity > (s.length()+1) / 2) {  // s.length()+1  in this +1 is to handle odd length 
            return "";

        }

        // store result
        char res[] = new char[s.length()];

        // condition -2: majarity == s.len/2
        // now fill character with even spaces
        int index = 0;
        while (map.get(letter) > 0) {

            // storing majarity ele at even index
            res[index] = letter;
            // reduce the frequency of majarity ele
            map.put(letter, map.get(letter) - 1);
            // update index
            index = index + 2;

        }

        // condtion-3 : majarity < s.len/2
        // now fill the remaiong characters

        for (char i : map.keySet()) {
            while (map.get(i) > 0) {
                if (index >= res.length) { // checking if index is reached to res.length then set to 1
                    index = 1;

                }
                res[index] = i; // storeing character
                // update frequency
                map.put(i, map.get(i) - 1);

                // update index
                index = index + 2;

            }
        }
        return new String(res);

    }
}