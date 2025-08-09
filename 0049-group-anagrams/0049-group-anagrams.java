class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // calling brute force apporach
        // return bruteForce(strs);
        //   calling hashmap apporqach
        return hashmapApporach(strs);
    }

    // we can solve this problem using brute force apporach
    // time complexity O(N^2)
    static List<List<String>> bruteForce(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        boolean[] visited = new boolean[strs.length]; // to avoid duplicates

        for (int i = 0; i < strs.length; i++) {
            if (visited[i]) {
                continue;
            }

            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            visited[i] = true;

            for (int j = i + 1; j < strs.length; j++) {
                if (!visited[j] && areAnagrams(strs[i], strs[j])) {
                    group.add(strs[j]);
                    visited[j] = true;
                }
            }
            result.add(group);
        }
        return result;
    }

    static boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }

    // we can solve this problem using hashmap
    static List<List<String>> hashmapApporach(String[] strs) {
        // Map to store the list of anagrams
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String word : strs) {
            // Convert the word to an array of characters
            char[] charArray = word.toCharArray();
            // Sort the array
            Arrays.sort(charArray);
            // Convert back to string
            String sortedWord = new String(charArray);

            // If the sorted word is not in the map, add it with an empty list
            if (!anagramMap.containsKey(sortedWord)) {
                anagramMap.put(sortedWord, new ArrayList<>());
            }

            // Append the original word to the corresponding list
            anagramMap.get(sortedWord).add(word);
        }

        // Return the grouped list of anagrams
        return new ArrayList<>(anagramMap.values());
    }

}