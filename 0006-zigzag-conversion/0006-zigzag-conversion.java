class Solution {
    public String convert(String s, int numRows) {
            // calling optimalApporch

        return optimalApporch(s, numRows);
    }

     // we can solve this problem using optimal apporach
    // video link : https://www.youtube.com/watch?v=vDXpo50qUC0
    static String optimalApporch(String s, int numRows) {

        if (numRows == 1 || s.length() <= numRows)
           {
             return s;
           }

        String[] res = new String[numRows];
        for (int i = 0; i < numRows; i++) {
            res[i] = ""; // initialize all elements to empty string
        }

        int currentRow = 0;
        boolean goingDown = false;

        for (int i = 0; i < s.length(); i++) {
            res[currentRow] += s.charAt(i);

            if (currentRow == 0 || currentRow == numRows - 1)
                goingDown = !goingDown;

            currentRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (String str : res) {
            result.append(str);
        }

        return result.toString();

    }
    
}