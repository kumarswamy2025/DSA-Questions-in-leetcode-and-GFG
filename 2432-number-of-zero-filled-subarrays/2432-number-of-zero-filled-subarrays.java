class Solution {
    public long zeroFilledSubarray(int[] nums) {
        // calling brute force apporach
        // return bruteForce(nums);
        // calling optiomal apporach
        return optimalApporach(nums);
    }

     // we can solve this problem using brute force apporach
    static long bruteForce(int[] nums) {
        long count = 0;
        // outer loop
        for (int i = 0; i < nums.length; i++) { // traverse each ele
            if (nums[i] == 0) { // single sub array
                count++;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == 0) {
                        count++;
                    } else {
                        break;
                    }
                }
            }
        }
        return count;
    }
    // we can solve this question using optimal apporach
    // video link : https://www.youtube.com/watch?v=G-EWVGCcL_w

    static long optimalApporach(int[] nums) {
        long res = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) { // checking if nums[i] is equal to 0
                count++; // if equals than update count
            } else { // if not equal to 0 then set count to 0
                count = 0;
            }
            // store count data in res variable
            res = res + count;
        }

        return res;
    }
}