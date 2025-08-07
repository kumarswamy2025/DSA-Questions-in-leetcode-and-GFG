class Solution {
    public int maxNumberOfBalloons(String text) {
         return ans(text);
    }

     // video link : https://www.youtube.com/watch?v=NxXfU4FQYFY
    static int ans(String text) {
        HashMap<Character, Integer> map = new HashMap<>();
        // inserting BALLON characters with frequency is 0
        map.put('b', 0);
        map.put('a', 0);
        map.put('l', 0);
        map.put('l', 0);
        map.put('o', 0);
        map.put('o', 0);
        map.put('n', 0);

        // itertate text and its frequenxcy

        for (int i = 0; i < text.length(); i++) {
            char data = text.charAt(i);
            // store it in map
            if (map.containsKey(data)) {

                map.put(data, map.get(data) + 1);
            }

        }

        // here we find min no of ballons
        // in ballo0n B:1, A:1 , L:2, O:2, N:1

        int min = map.get('b');
        min = Math.min(min, map.get('a'));
        min = Math.min(min, map.get('l') / 2);
        min = Math.min(min, map.get('o') / 2);
        min = Math.min(min, map.get('n'));

        return min;
    }
}