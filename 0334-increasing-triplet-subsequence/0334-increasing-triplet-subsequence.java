class Solution {
    public boolean increasingTriplet(int[] nums) {
              // calling slidingWindowApporach
        // return slidingWindowApporach(nums);

        // calling brute force appoarach
        // return bruteForce(nums);
        //  calling optimal appoarach
        return optimalAppoarch(nums);
        
    }

      // we can solve this problem using sliding window apoarch
    // NOTE : this apporach is not works works for cases
    static boolean slidingWindowApporach(int[] nums) {

        if (nums == null || nums.length < 3) {
            return false;
        }
        // sliding window size is 3 and compare ele in between 3
        int front = 0;
        for (int back = 2; back < nums.length; back++) {

            if (nums[front] < nums[front + 1] && nums[front + 1] < nums[back]) {

                return true;
            } else {
                front++;
            }

        }
        return false;

    }

    // we can solve this using brute force appoarch
    // NOTE: WE GOT Time Limit Exceeded ERROR
    static boolean bruteForce(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    if (nums[i] < nums[j] && nums[j] < nums[k]) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    // we solve this problem by using optimal apporach in single ietartion
    static boolean optimalAppoarch(int[] numns) {

        /*
         * Appoarch: track current ele and comapre it previous one
         * video : https://www.youtube.com/watch?v=yEFlGWOVH8g
         */

        // base case if lengtrh is less than 3 than return false
        if (numns.length < 3) {
            return false;
        }
        // first ele with max value
        int firstEle=Integer.MAX_VALUE;
        // second ele with max value
        int secondEle=Integer.MAX_VALUE;

        // iterate nums
        for (int i = 0; i < numns.length; i++) {

            //  checking if firstEle value less than current ele if less than update it 
            if(numns[i]<=firstEle){
                firstEle=numns[i];
            }
            else if(numns[i]<=secondEle){ //  checking if second value less than current ele if less than update it 
                secondEle=numns[i];

            }
            else{  // this is for third ele case suppose if both above cases are satified than it will also satisfy 
                return true;

            }

        }
        return false;

    }
}