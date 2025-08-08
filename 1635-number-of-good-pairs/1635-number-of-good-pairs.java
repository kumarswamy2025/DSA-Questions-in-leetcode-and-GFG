class Solution {
    public int numIdenticalPairs(int[] nums) {
        // calling brute forve apporach
        // return bruteForce(nums);

        //  calling hashmap solution 

        return hashmap(nums);
    }

    // we can solve this problem using vrute force appoarach
    static int bruteForce(int[] nums){
        // apporach : inneach iteraction compare the current ele with inner loop ele and if there is an match then increment count
  
         int pairCounter=0;
        //  outer loop
        for(int i=0;i<nums.length;i++){
            // inner loop
            for(int j=i+1;j<nums.length;j++){

                if(nums[i]==nums[j]){
                    pairCounter++;
                }

            }
        }

        return pairCounter;

    }

    //  we can solve this problem using hashmpa
    static int hashmap(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        
        // Iterate over each number in the array
        for (int num : nums) {
            // If number is already seen, it can form pairs with all previous occurrences
            if (map.containsKey(num)) {
                // Increment count by the number of occurrences seen so far
                count += map.get(num);
                // Increment the occurrence count in the map
                map.put(num, map.get(num) + 1);
            } else {
                // If number is seen for the first time, put it in the map
                map.put(num, 1);
            }
        }
        return count;
    }
}