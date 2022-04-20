package tl.prog2.exercises.set02.sequences;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers implements Sequence {

    Sequence seq = null;
    ArrayList<Integer> primes = new ArrayList();

    public PrimeNumbers(int max){
        seq = new Range(2, max);
        while(seq.hasNext()) {
            int p = seq.nextElement();
            primes.add(p);
            seq = new ZapMultiples(seq, p);
        }
    }

    @Override
    public boolean hasNext() {
        return !primes.isEmpty();
    }

    @Override
    public int nextElement() {
        return primes.remove(0);
    }
}
