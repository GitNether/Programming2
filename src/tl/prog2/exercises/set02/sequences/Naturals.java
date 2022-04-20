package tl.prog2.exercises.set02.sequences;

import java.util.ArrayList;
import java.util.List;

public class Naturals implements Sequence {

    ArrayList<Integer> array = new ArrayList();

    public Naturals(){
        ArrayList<Integer> a = new ArrayList(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        array = a;
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