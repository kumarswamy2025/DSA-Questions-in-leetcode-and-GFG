class Solution {
    public int majorityElement(int[] nums) {
        // we can solve this problem using hashmap
        // create hash map and store it
        HashMap<Integer, Integer> map = new HashMap<>();

        // storing ele
        for (int i : nums) {
            if (map.containsKey(i)) { // checking if key is already present
                map.put(i, map.get(i) + 1); // if key is present then it is increment by 1
            } else { // put ele to map
                map.put(i, 1);

            }
        }
        int keyValue=0;  // key value 
        // Majarity ele
        int majorityElement = nums[0]; // default value
        for(Integer mapSet:map.keySet()){  // iterate map 
             
            if(map.get(mapSet)>keyValue){  // comparing map key value 
                keyValue=map.get(mapSet);  // update key value
                majorityElement=mapSet;   // update majarity ele 
            }
        }



        return majorityElement;
    }
}