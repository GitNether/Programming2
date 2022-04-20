package tl.prog2.exercises.set02.sequences;

import java.util.ArrayList;

public class Range implements Sequence {

    ArrayList<Integer> array = new ArrayList();

    public Range(int min, int max){
        for(int i = min; i <= max; i++){
            array.add(i);
        }
    }

    @Override
    public boolean hasNext() {
        return !array.isEmpty();
    }

    @Override
    public int nextElement() {
        return array.remove(0);
    }
}
