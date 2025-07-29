class Solution {
    public void rotate(int[] nums, int k) {
         // calling brute force apporach
        bruteForce(nums, k);
        
        // calling swap appoarch
        // swap(nums, k);
    }
     // we can solve brute force appoarch using ararly list
    static void bruteForce(int[] nums, int k) {
        /*
         * appoarch : create aray list and add at end array values upto nums.length-1-k;
         * and remainig k ele add at front of array list
         */
        k = k % nums.length; // Handle if k > length
        ArrayList<Integer> list = new ArrayList<>();

        // adding elements at first

        for (int i = nums.length - 1; i >= nums.length - k; i--) {
            list.add(0, nums[i]);

        }

        // adding rest of elements at end
        for (int i = 0; i < nums.length - k; i++) {
            list.add(nums[i]);
        }

        // now copy this list into nums array
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }

    }

    // we can solve this problem using swap technic Note: we got Time Limit Exceeded 
    static void swap(int[] nums, int k){
        

         int n = nums.length;
    k = k % n; // normalize k

    for (int r = 0; r < k; r++) {
        int last = nums[n - 1]; // save last element

        // shift elements to right
        for (int i = n - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }

        nums[0] = last; // place last at the front
    }
    }
}