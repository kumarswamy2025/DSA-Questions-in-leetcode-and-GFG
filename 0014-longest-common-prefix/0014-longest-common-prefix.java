class Solution {
    public String longestCommonPrefix(String[] strs) {
         //  calling optimal apporach
        return optimalApporach(strs);
    }

     //  we can solve this  problem in optimal way
    // video : https://www.youtube.com/watch?v=wtOQaovlvhY
    static String optimalApporach(String[] strs){
        /*
         * Apporach : first sort of strings then it will automatically arrange in assending order 
         *  and then compare first string and last string characters 
         */

         Arrays.sort(strs);  // sort aray
         
        //  String builder class
        StringBuilder res=new StringBuilder();

        String firsString=strs[0]; // first string
         
        String lastString=strs[strs.length-1]; // last string 

        //  iteracte each charactrer in second string and store it if both are equal

        for(int i=0;i<firsString.length();i++){
            char firsStringCharacter=firsString.charAt(i);  // first string character
            char secondStringCharacter=lastString.charAt(i); // last   string character 

            if(firsStringCharacter!=secondStringCharacter){
                break;
            }
            else{
                res.append(firsStringCharacter); // store each charaters 
            }

        }
        

        return res.toString();





    }
}