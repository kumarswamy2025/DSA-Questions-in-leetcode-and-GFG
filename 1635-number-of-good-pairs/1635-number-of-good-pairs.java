class Solution {
    public int numIdenticalPairs(int[] nums) {
         // calling brute forve apporach
        return bruteForce(nums);
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
}