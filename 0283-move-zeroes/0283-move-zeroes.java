class Solution {
    public void moveZeroes(int[] nums) {
        

        // calling brute force apporach
        // bruteForce(nums);
        // calling two pointers apporach
        twoPointersApporach(nums);
    }
    // brute force apporach
    static void bruteForce(int[] nums) {
        // apporach: create array and insert non zero elements 
        int[] res=new int[nums.length];

        int index=0; // index of res array

        for(int i: nums){
            if(i!=0){
                res[index]=i;
                index++;
            }
        }

        //    now copy res array to nums arrat
        for(int i=0;i<nums.length;i++){
            nums[i]=res[i];
        }


    }

    //  use solve this problem using two pointers
    static void twoPointersApporach(int[] nums){
        // apporach : right pointer traverase from left to right and if any non zero ele is found then i will insert left side
        int left=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]!=0){
  
                //  swap right and left 
                int temp=nums[left];
                
                nums[left]=nums[right];
                nums[right]=temp;
                // increment left
                left++;




            }
        }


    }
}