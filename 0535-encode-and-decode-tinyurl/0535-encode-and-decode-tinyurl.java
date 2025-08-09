public class Codec {

   // we can solve this problem using hashmap 
    // video link :https://www.youtube.com/watch?v=VyBOaboQLGc
     
   

        HashMap<String,String> encodeResult=new HashMap<>();  // store endoe 
        HashMap<String,String> decodeResult=new HashMap<>();  // store decode 
        
        String baseURL="http://tinyurl.com/";




    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {

        // Checking if longyrl is exits or not in encode map

        if(!this.encodeResult.containsKey(longUrl)){
            String data=this.baseURL+String.valueOf(longUrl.length()+1);  // it create url based on len of string

            // maping  long url to short url 

            encodeResult.put(longUrl, data);

            // maping  short url to long url
            
            decodeResult.put(data, longUrl);

        }

        return this.encodeResult.get(longUrl);

        
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {

        return decodeResult.get(shortUrl);
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));