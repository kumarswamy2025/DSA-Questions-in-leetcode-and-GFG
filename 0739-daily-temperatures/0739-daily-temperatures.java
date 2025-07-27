class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        // calling brute force apporach (note: for this apporach we get Time Limit Exceeded error so use monotonic stack)
        // return bruteForceApporach(temperatures);

        // calling monotonic stack
        return Monotonic_Stack(temperatures);

    }

    static int[] bruteForceApporach(int[] temperatures) {
        // create result array
        int[] result = new int[temperatures.length];

        // outer loop : iterate all values
        for (int i = 0; i < temperatures.length; i++) {
            // inner loop  : compare outer loop values with each  inner loop value
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) { // checking if next element is greater than prev or not
                    result[i] = j - i; // if greater than find difference between the next greater ele and current ele 
                    break; // break loop when we find next gretaer ele 
                }
            }

        }
        return result;
    }

    static int[] Monotonic_Stack(int[] temperatures) {

        // create stcak
        Stack<Integer> stack = new Stack<>();

        // create result array
        int[] result = new int[temperatures.length];

        /* 
        
        NOTE: In stack we store index values not Actual values 
        
         */

        // outer loop
        for (int i = 0; i < temperatures.length; i++) {

            // checking if stack is not empty and current index ele is greater than stack peek ele 
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop(); // pop previous index value 
                result[prevIndex] = i - prevIndex; //  calculate wait time 
            }

            stack.push(i); // push current index to stack 

        }

        return result;

    }

}