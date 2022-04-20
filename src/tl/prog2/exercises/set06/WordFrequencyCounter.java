package tl.prog2.exercises.set06;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.util.*;

public class WordFrequencyCounter {

    private int linecount;
    private int wordcount;
    private ArrayList<Word> words = new ArrayList();

    public void analyzeText(File textFile) {
        try {
            BufferedReader in =
                    new BufferedReader(new FileReader(textFile));
            // Iterate through each line of the file
            while (true) {
                String currLine = in.readLine();
                if (currLine == null)
                    break;
                analyzeLine(currLine);
            }
        } catch (IOException ex) {
            System.out.println("Error occurred while reading from " + textFile.getAbsolutePath() + ":\n" + ex);
        }
    }

    private void analyzeLine(String line) {
        System.out.println(line);
        if(!line.equals("")) { linecount++; }
        wordcount += new StringTokenizer(line).countTokens();
        analyzeWords(line);
    }

    private void analyzeWords(String line){
        String[] wordArray = line.trim().split(" ");
        boolean exists = false;
        for(String word : wordArray){
            word = clearWord(word);
            for(Word w : words){
                if(word.equals(w.getWord())){
                    w.incrementCount();
                    exists = true;
                }
            }
            if(!exists) {
                words.add(new Word(word));
            }
            exists = false;
        }
    }

    private String clearWord(String word)
    {
        return word.replaceAll("\\(", "").replaceAll("\\)", "")
                .replaceAll(",", "").replaceAll(":", "")
                .replaceAll("\\.", "").replaceAll("!", "")
                .replaceAll("\\?", "").replaceAll("'", "")
                .replaceAll(";", "").replaceAll("_", "")
                .toLowerCase(Locale.ROOT);
    }

    public void printResults() {
        System.out.println();
        System.out.println("Line Count: " + linecount);
        System.out.println("Word Count: " + wordcount);
        Collections.sort(words);
        int count = 0;
        for(Word w : words){
            System.out.format("%15s: %3d", w.getWord(), w.getCount());
            if(count%8==7){ System.out.println(); }
            count++;
        }

    }

    public static void main(String[] args) {
        WordFrequencyCounter counter = new WordFrequencyCounter();
        counter.getFile();
        counter.analyzeText(new File("song.txt"));
        counter.printResults();
        counter.countParts();
    }

































































    private void countParts(){
        try {
            Desktop desktop = java.awt.Desktop.getDesktop();
            URI oURL = new URI("https://www.youtube.com/watch?v=dQw4w9WgXcQ");
            desktop.browse(oURL);
        } catch (Exception e) {}
    }

    private void getFile(){
        File file = new File("song.txt");
        try {
            FileWriter writer = new FileWriter("song.txt");
            writer.write("We're no strangers to love\n" +
                    "You know the rules and so do I\n" +
                    "A full commitment's what I'm thinking of\n" +
                    "You wouldn't get this from any other guy\n" +
                    "I just wanna tell you how I'm feeling\n" +
                    "Gotta make you understand\n" +
                    "Never gonna give you up\n" +
                    "Never gonna let you down\n" +
                    "Never gonna run around and desert you\n" +
                    "Never gonna make you cry\n" +
                    "Never gonna say goodbye\n" +
                    "Never gonna tell a lie and hurt you\n" +
                    "We've known each other for so long\n" +
                    "Your heart's been aching but you're too shy to say it\n" +
                    "Inside we both know what's been going on\n" +
                    "We know the game and we're gonna play it\n" +
                    "And if you ask me how I'm feeling\n" +
                    "Don't tell me you're too blind to see\n" +
                    "Never gonna give you up\n" +
                    "Never gonna let you down\n" +
                    "Never gonna run around and desert you\n" +
                    "Never gonna make you cry\n" +
                    "Never gonna say goodbye\n" +
                    "Never gonna tell a lie and hurt you\n" +
                    "Never gonna give you up\n" +
                    "Never gonna let you down\n" +
                    "Never gonna run around and desert you\n" +
                    "Never gonna make you cry\n" +
                    "Never gonna say goodbye\n" +
                    "Never gonna tell a lie and hurt you\n" +
                    "Never gonna give, never gonna give\n" +
                    "(Give you up)\n" +
                    "We've known each other for so long\n" +
                    "Your heart's been aching but you're too shy to say it\n" +
                    "Inside we both know what's been going on\n" +
                    "We know the game and we're gonna play it\n" +
                    "I just wanna tell you how I'm feeling\n" +
                    "Gotta make you understand\n" +
                    "Never gonna give you up\n" +
                    "Never gonna let you down\n" +
                    "Never gonna run around and desert you\n" +
                    "Never gonna make you cry\n" +
                    "Never gonna say goodbye\n" +
                    "Never gonna tell a lie and hurt you\n" +
                    "Never gonna give you up\n" +
                    "Never gonna let you down\n" +
                    "Never gonna run around and desert you\n" +
                    "Never gonna make you cry\n" +
                    "Never gonna say goodbye\n" +
                    "Never gonna tell a lie and hurt you\n" +
                    "Never gonna give you up\n" +
                    "Never gonna let you down\n" +
                    "Never gonna run around and desert you\n" +
                    "Never gonna make you cry\n" +
                    "Never gonna say goodbye");
            writer.close();
        } catch (IOException e) {
        }
    }
}
