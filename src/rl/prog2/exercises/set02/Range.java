package rl.prog2.exercises.set02;

public class Range implements Sequence {
	private int max;
	private int next;
	
	public Range(int min, int max) {
		this.max = max;
		next = min;
	}

	@Override
	public boolean hasNext() {
		return next <= max;
	}

	@Override
	public int nextElement() {
		return next++;
	}
	
	
}
