class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // base case
        if(nums.length<=0 || k==0 || nums==null){
            return false;
        }




        // sliding window
        HashSet<Integer> set=new HashSet<>();

        // left pointer
        int left=0;
        // traverse each ele
        for(int right=0;right<nums.length;right++){
            
            // checking if element is already present or not
            if(set.contains(nums[right])){
                return true;
            }
            // else add to set
            else{
                set.add(nums[right]);
            }
            // checking if set size is greater than or equal to k+1 then remove left ele
            if(set.size()>=k+1){
                 // Remove the last visited element from the set
                set.remove(nums[left]);
                // update left
                left++;
            }

        }
                // If no duplicate element is found then return false...

        return false;
    }
}