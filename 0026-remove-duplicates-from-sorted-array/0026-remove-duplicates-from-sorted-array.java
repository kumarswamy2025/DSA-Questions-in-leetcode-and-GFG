class Solution {
    public int removeDuplicates(int[] nums) {

          // calling brute force appoarch
        // return bruteForceApporach(nums);
        // calling two pointers appoarach
        return twoPointersAppoach(nums);
        
    }

      // brute force apporach
    static int bruteForceApporach(int[] nums) {
        /**
         * Apporach:
         * step-1: store nums in map with occuronanacce
         * step-2 : now take keyset from map and store in nums array and return keyset
         * size
         * 
         * 
         */

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        // iterating arrray and store it in map
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1); // if key is present then upadate occuracne
            } else { // else add to map
                map.put(i, 1);

            }
        }

        // take keyset from map and insert into nums array and return its size
        int size = 0;
        int index = 0; // index for nums array
        for (Integer i : map.keySet()) {
            nums[index] = i;
            size++;
            index++;

        }
        return size;
    }

    // two pointers appoarach
    static int twoPointersAppoach(int[] nums) {
        /*
         * Appoarch : compare first and second ele every iteration if both are not
         * equeal then inceremet left and swap left and right
         */

        int left = 0;
        for (int right = 1; right < nums.length; right++) {

            if (nums[left] != nums[right]) { // checking if left and right are not equal
                left++; // increment left
                // swap left and right
                nums[left]=nums[right];

            }

        }
        // return left+1
        return left+1;
    }
}