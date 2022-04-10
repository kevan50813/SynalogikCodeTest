package project;


import java.util.*;

public class App
{
    private double sum=0;
    private Map<Integer,Integer> wordMap= new HashMap<>(); // hash map that will store the word and the word count

    /**
     * count hoow mnay words are in the string
     * @param data - entire sting of data
     * @return how many words are in the string
     */
    public int wordCount(String data){
        String[] count = data.trim().split("\\s+");
        return count.length;
    }

    /**
     * compute the average
     * @param sum - the sum of all numbers
     * @param wordCount- how many words there are
     * @return the average
     */
    public double avgWordLen(double sum,int wordCount){
        double avg=0;
        avg=sum/wordCount;
        return avg;
    }

    /**
     * textSatatcts will get all word  lenghts and counts, please note the deffination of output is as follows:
     *  all text and punctaion is counted as one word for exsmaple hello&World is one word and hello world would be
     *  counted as 2 words
     * @param data - a String provided by the Read data class which is the entire text file conveted to one string
     *
     */
    public void textStatistics(String data){
        String[] words=data.split(" ");
        //add all words of differing length to a has map
        for(String word: words){
            double wordlen=word.length();
            sum+=wordlen;
            Integer val=wordMap.get(word.length()); // searching count
            if(val!=null){ // if count is there
                wordMap.put(word.length(),val+1);// increment count by one
            }else{ // count not there
                wordMap.put(word.length(),1); // add count as one
            }
        }

    }

    /**
     * print the statsicts
     * @param data - the string that is the file cpntnets
     */
    private void printStats(String data){
        System.out.println("word count is: "+wordCount(data));
        textStatistics(data);
        System.out.println("Average word length is : " + avgWordLen(sum, wordCount(data)));
        //gentate the staings from the hash map
        int maxValue=(Collections.max(wordMap.values()));  // This will return max value in the Hashmap
        for (Map.Entry<Integer,Integer> entry:wordMap.entrySet()) {
            System.out.println("No. of words of length " + entry.getKey() + " is " + entry.getValue() + ".");
            if(entry.getValue()==maxValue){
                System.out.println("The most frequently occurring word length is: "+entry.getValue()+" for word length: "+entry.getKey());
            }
        }
    }


    public static void main( String[] args )
    {   // chage text.txt to whatever your file is your testing, text.txt is a file used for testeing purposes provided
        App a=new App();
        ReadFile rf=new ReadFile("text.txt");
        a.printStats(rf.getData());
    }
}
