package rl.prog2.exercises.set02;

public class Evens extends Filter {

	public Evens(Sequence seq) {
		super(seq);
		computeNext();
	}

	@Override
	protected boolean testPassCondition(int element) {
		return element % 2 == 0;
	}

}
