/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */


class Solution {
    

    public void findSecretWord(String[] words, Master master) {
        // calling brute force appoarch
       // bruteForce(words, master);

        //  calling optimal apporach
        optimalApporach(words, master);
    }
    
    // we can solve this problem using brute force apoarch but we got time
    // complexity error
    static void bruteForce(String[] words, Master master) {
        for (String i : words) {
            if (master.guess(i) == 6) {
                return;
            }
        }
    }

    // we can solve this problem using optimal apporach
    // video : https://www.youtube.com/watch?v=COnrhAabeos
    static void optimalApporach(String[] words, Master master) { 

        // Apporach: pick random word find match value and master.guess value if both
        // are equal then add it

        // stores array of words
        List<String> wordList = new ArrayList<>(Arrays.asList(words));

        Random random = new Random(); // used to pick random word
        // itertate wordlist and pick randiom word
        while (!wordList.isEmpty()) { 

            // pick random word
            String guessWord = wordList.get(random.nextInt(wordList.size()));

            // finding guess value

            int matchValue = master.guess(guessWord);

            if (matchValue == 6) { // ifn match value is equal to 6 then we find secdrete key
                return;
            }

            // Filter wordList to keep only those with the same match count
            List<String> filteredList = new ArrayList<>();
            for (String word : wordList) {
                if (matchCount(guessWord, word) == matchValue) {
                    filteredList.add(word);

                }
            }
             wordList = filteredList;

        }
    }

    // Helper function to count character matches at same positions
    static int matchCount(String a, String b) {
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (a.charAt(i) == b.charAt(i)) {
                count++;
            }
        }
        return count;

    }
}