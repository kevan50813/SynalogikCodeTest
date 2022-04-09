package project;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

public class App
{
    public static int wordCount(String data){
        String[] count = data.trim().split("\\s+");
        return count.length;
    }

    /**
     * textSatatcts will get all word  lenghts and counts, please note the deffination of output is as follows:
     *  all text and punctaion is counted as one word for exsmaple hello&World is one word and hello world would be
     *  counted as 2 words
     * @param data - a String provided by the Read data class which is the entire text file conveted to one string
     *
     */
    public static void textStatistics(String data){
        String[] words=data.split(" ");
        Map<Integer,Integer> wordMap= new HashMap<>(); // hash map that will store the word and the word count
        //add all words of differing length to a has map
        for(String word: words){
            Integer val=wordMap.get(word.length()); // searching count
            if(val!=null){ // if count is there
                wordMap.put(word.length(),val+1);// increment count by one
            }else{ // count not there
                wordMap.put(word.length(),1); // add count as one
            }
        }
        //gentate the staings from the hash map
        for (Map.Entry<Integer,Integer> entry:wordMap.entrySet()) {
            System.out.println("No. of words of length " + entry.getKey() + " is " + entry.getValue() + ".");
        }
    }


    public static void main( String[] args )
    {   // chage text.txt to whatever your file is your testing, text.txt is a file used for testeing purposes provided
        ReadFile rf=new ReadFile("text.txt");
        System.out.println(rf.getData());
        System.out.println("word count is: "+wordCount(rf.getData()));
        textStatistics(rf.getData());
    }
}
