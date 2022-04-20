package tl.prog2.exercises.set06;

public class Word implements Comparable<Word> {
    private String word;
    private int count;

    public Word(String word){
        this.word = word;
        count = 1;
    }

    public String getWord() { return word; }
    public int getCount(){
        return count;
    }
    public void incrementCount(){
        count++;
    }

    @Override
    public int compareTo(Word word) {
        return word.getCount() - getCount();
    }
}
