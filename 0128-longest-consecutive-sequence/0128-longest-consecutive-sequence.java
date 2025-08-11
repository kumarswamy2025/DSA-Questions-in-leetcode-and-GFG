class Solution {
    public int longestConsecutive(int[] nums) {
          // calling brute force apporach
        return bruteforceApporach(nums);
    }

      // we can solve this problem using bruteforce apporach
    static int bruteforceApporach(int[] nums) {

      if (nums.length == 0) {
        return 0;
      }

    HashSet<Integer> set = new HashSet<>();
    for (int num : nums) {
        set.add(num);
    }

    int longest = 0;

    for (int num : set) {
        // Only start counting if it's the start of a sequence
        if (!set.contains(num - 1)) {
            int currentNum = num;
            int currentStreak = 1;

            while (set.contains(currentNum + 1)) {
                currentNum++;
                currentStreak++;
            }

            longest = Math.max(longest, currentStreak);
        }
    }

    return longest;


    }
}