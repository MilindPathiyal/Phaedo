//Milind Pathiyal

//Prints out Phaedo text
import java.util.*;
import java.io.*;
public class Phaedo
{
    private int wordCount;
    private String longestWord;
    private int[] frequencyTable;
    private String[] greekNames;
    private String greek;
    private int greekCount;
    //pre: none
    //post:creates phaedo object
    public static void driver()
    {
        Phaedo a = new Phaedo();
        a.print();
    }
    //pre: private variables must exist
    //post: sets the private variable values
    public Phaedo()
    {
        greek = "";
        longestWord = "";
        frequencyTable = new int [11];
        greekNames = new String [14];
        wordCount = 0;
    }
    //pre: string and private variables must exist
    //post: calculates number of words, longest word, creates frequency table, and finds greek names
    public void processLine(String input)
    {
        input+= " ";
        String word = " ";
        int i = 0;
        while(input.indexOf(' ')  >= -1)
        {
            int space = input.indexOf(' ');
            word = input.substring(0, space);
            word = clean(word);
            wordCount ++; 
            
            frequencyTable[word.length()]+=1;
            char capital=word.charAt(0); 
            if ((word.length() >= 5 && capital <='Z' && capital >= 'A'))
            {
                if(((word.substring(word.length()-2).equals("us")) || word.substring(word.length()-4).equals("ates")) 
                || (word.substring(word.length()-2).equals("to")) )
                {
                     greekNames[i] = greek;
                     i++;
                }
            }
        
            input = input.substring(space+1, input.length());
            if(longestWord.length() < word.length()) 
            {
                longestWord = word;
            }
        }
    }
    
    //pre: string and private variables must exist
    //post: cleans text
    public String clean(String input)
    {
        String answer = "";
        for(int i = 0; i < input.length(); i++)
        {
            char testC = input.charAt(i);
            if((testC <= 'z' && testC >= 'a') || (testC <= 'Z' && testC >= 'A'))
            {
                answer += testC;
            }
        }
        return answer;
    }
    //pre: private variables, printResults(), processLine() must exist
    //post: creates file of processLine
    public void print()
    {
        int word = 0;
        int longLength = 0;
        int count = 0;
        try
        {
            Scanner text = new Scanner(new File("Phaedo.txt"));
            while(text.hasNext())
            {
                String line = text.nextLine();
                processLine(line);
            }
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("There are " + wordCount + " words");
        System.out.println("The longest word is " + longestWord + " and its length is " + longestWord.length());
        greekNames();
        frequencyTable();
    }
    public void frequencyTable()
    {
        for(int i = 1; i<frequencyTable.length; i++)
        {
            System.out.println((i) + " letters in "+ frequencyTable[i] + " words ");
        }
    }
    public void greekNames()
    {
        System.out.print("Greek names: ");
        for(int i = 0; i<greekNames.length; i++)
        {
            System.out.print(greekNames[i] + ", ");
        }
    }
}
/*
There are 603 words
The longest word is experienced and its length is 11
Greek names: Plato, Crito, Socrates, Socrates, Echecrates, Socrates, Crito, Apollodorus, Socrates, Crito, Asclepius, Crito, Crito, Echecrates,
1 letters in 23 words   
2 letters in 106 words  
3 letters in 178 words  
4 letters in 130 words  
5 letters in 57 words   
6 letters in 34 words   
7 letters in 34 words   
8 letters in 24 words   
9 letters in 8 words    
10 letters in 7 words   
11 letters in 2 words   
*/

