class Solution {
    public boolean isPossible(int[] nums) {
        //  calling brute force apporach

        //  return bruteForceApporach(nums);

        //  calling optimal apporach
        return optimalApporach(nums);
    }

     // we can solve this using brute force apporach
    // time complexity: O(n^2)

    static boolean bruteForceApporach(int[] nums) {
        /*
         * Apporach : compare current ele with rest of next ele
         *  NOTE: This apporach not handle dublciate ele 
         */

        // create visited Aarray
        boolean[] visited = new boolean[nums.length]; // used to track visited ele

        // traverse array

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) { // checking if ele is already visited

                int count = 1; // tracks sub array size
                int prevEle = nums[i]; // used to compare next ele
                visited[i] = true; // update visited array

                // traverse rest of ele 
                for(int j=i+1;j<nums.length;j++){
                    if(!visited[j] && prevEle+1==nums[j]){ // checking if ele is already visited and checking prev ele is  consecutive ele or nor 
                        visited[j]=true; // update visited array
                        count=count+1; // update count
                        // set prev ele is current
                        prevEle=nums[j];

                    }
                }

                //  checking if sub array size is less than 3 then return false
                if(count<3){
                    return false;
                }

            }

        }

        return true;

    }
    

    //  optimal solution 
    // vidoe link : https://www.youtube.com/watch?v=Ty8EZlxVNC8&t=795s

     static boolean optimalApporach(int[] nums){
         Map<Integer, Integer> count = new HashMap<>(); // frequency of each number
        Map<Integer, Integer> end = new HashMap<>();   // how many subsequences end with key

        // Count frequency of each number
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            if (count.get(num) == 0) {
                continue; // already used
            }

            // Decrease the count for current num
            count.put(num, count.get(num) - 1);

            // If there is a subsequence ending with num-1, append num to it
            if (end.getOrDefault(num - 1, 0) > 0) {
                end.put(num - 1, end.get(num - 1) - 1);
                end.put(num, end.getOrDefault(num, 0) + 1);
            }
            // Else, try to create a new subsequence num, num+1, num+2
            else if (count.getOrDefault(num + 1, 0) > 0 && count.getOrDefault(num + 2, 0) > 0) {
                count.put(num + 1, count.get(num + 1) - 1);
                count.put(num + 2, count.get(num + 2) - 1);
                end.put(num + 2, end.getOrDefault(num + 2, 0) + 1);
            }
            // Else, cannot form a valid subsequence
            else {
                return false;
            }
        }
        return true;
     }
}