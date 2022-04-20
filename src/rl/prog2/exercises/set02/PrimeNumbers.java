package rl.prog2.exercises.set02;

/** Implements the sieve of Eratosthenes. */
public class PrimeNumbers implements Sequence {

	Sequence seq;
	
	public PrimeNumbers() {
		seq = new Naturals();
		seq.nextElement();
	}
	
	@Override
	public boolean hasNext() {
		return seq.hasNext();
	}

	@Override
	public int nextElement() {
		int result = seq.nextElement();
		seq = new ZapMultiples(seq, result);
		return result;
	}
}
