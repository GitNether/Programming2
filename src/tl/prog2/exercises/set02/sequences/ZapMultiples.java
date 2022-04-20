package tl.prog2.exercises.set02.sequences;

import java.util.ArrayList;

public class ZapMultiples implements Filter, Sequence {

    Sequence sequence = null;
    int base;
    ArrayList<Integer> array = new ArrayList();

    public ZapMultiples(Sequence s, int base){
        sequence = s;
        this.base = base;
        while(s.hasNext()){
            int element = s.nextElement();
            if(testPassCondition(element))
                array.add(element);
        }
    }

    @Override
    public boolean testPassCondition(int element) {
        return !(element%base==0);
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
