package orderedStructures;

import exceptions.InvalidIndexException;
import interfaces.Combinable;

public class Arithmetic extends Progression implements Combinable {
	private double commonDifference; 
	
	public Arithmetic(double firstValue, double commonDifference) { 
		super(firstValue); 
		this.commonDifference = commonDifference; 
	}
	
	@Override
	public double nextValue() throws IllegalStateException{
		if(!isFirstExecuted()){
			throw new IllegalStateException("FirstValue() was not executed.");
		}
		current = current + commonDifference; 
		return current;
	}
	
	@Override
	public String toString(){		
		return "Arith(" + this.firstValue() + ", " + this.commonDifference + ")";
	}
	
	@Override
	public double getTerm(int n) throws InvalidIndexException{
		if (n <= 0) 
			throw new IndexOutOfBoundsException("printAllTerms: Invalid argument value = " + n);
		
		return this.firstValue() + this.commonDifference * (n-1);
	}

	@Override
	public boolean equals(Progression p) {
		return (firstValue() == p.firstValue() && commonDifference == p.getTerm(2) - p.firstValue());
	}

	@Override
	public Progression add(Progression other) {
		Progression sumP = new Arithmetic(firstValue() + other.firstValue(), commonDifference + (other.getTerm(2) - other.firstValue()));
		return sumP;
	}

	@Override
	public Progression subtract(Progression other) {
		Progression substractP = new Arithmetic(firstValue() - other.firstValue(), commonDifference - (other.getTerm(2) - other.firstValue()));
		return substractP;
	}
}
