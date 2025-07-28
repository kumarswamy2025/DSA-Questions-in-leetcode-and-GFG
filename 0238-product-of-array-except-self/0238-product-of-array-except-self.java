class Solution {
    public int[] productExceptSelf(int[] nums) {

           // calling brute force apporach 
        // return bruteForceApporach(nums);
        
         // calling optimal apporach
        return optimalApporach(nums);
    }

     // this si brute force apporach
    static int[] bruteForceApporach(int[] nums) {
        // create result array
        int[] res = new int[nums.length];
        // outer loop
        for (int i = 0; i < nums.length; i++) {
            // inner loop\
            int Product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    Product = Product * nums[j]; // calculating product

                }
            }
            res[i] = Product;

        }

        return res;
    }
     // this si optimal apporach
  
    static int[] optimalApporach(int[] nums) {
        // creating result array
        int[] result = new int[nums.length];

        // creating left part array, to store all left multiplications

        int[] left = new int[nums.length];
        // assign left[0] is 1
        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        // creating right part array, to store all left multiplications
        int[] right = new int[nums.length];
        // assign right[nums.length-1] is 1
        right[nums.length - 1] = 1;
        for (int j = nums.length-2; j > -1; j--) {
            right[j]=right[j+1]*nums[j+1];
        }

        // now make product of left and right arrays and store in result array
        for(int i=0;i<nums.length;i++){
            result[i]=left[i]*right[i];
        }
        return result;

    }
}