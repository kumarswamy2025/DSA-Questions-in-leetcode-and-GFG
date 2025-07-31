class Solution {
    public int firstMissingPositive(int[] nums) {
         //  calling optimalApporach

        return optimalApporach(nums);
    }
     // we can solve this problem in optimal apoarach
    // video : https://www.youtube.com/watch?v=SEn4fyMZ22M&t=125s
    static int optimalApporach(int[] nums) {
        /*
         * Appoarch: put current ele in index based
         * currentIndex=nums[i]-1
         */

        int length = nums.length;
        int i = 0;
        while (i < length) {
            int currentIndex = nums[i] - 1;

            if (nums[i] > 0 && nums[i] <= length && nums[i] != nums[currentIndex]) {
                // swap nums[i] and nums[curretEle]
                swap(nums, i, currentIndex);
            } else {
                i++;
            }

        }

        //  compare array values  with numbers(index+1)

        for(int index=0;index<nums.length;index++){
            if(nums[index]!=index+1){
                return index+1; // here index is zero basesd index 

            }
        }

        return length+1;  // suppose there is no missing ele from 0 index to N so return n+1

    }

    // swap method
    static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}