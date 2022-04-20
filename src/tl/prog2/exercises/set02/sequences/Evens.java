package tl.prog2.exercises.set02.sequences;

import java.util.ArrayList;

public class Evens implements Filter, Sequence {

    Sequence sequence = null;
    ArrayList<Integer> array = new ArrayList();

    public Evens(Sequence s){
        sequence = s;
        while(s.hasNext()){
            int element = s.nextElement();
            if(testPassCondition(element))
            array.add(element);
        }
    }

    @Override
    public boolean testPassCondition(int element) {
        return element%2==0;
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
