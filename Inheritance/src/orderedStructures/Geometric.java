package orderedStructures;

import exceptions.InvalidIndexException;
import interfaces.Combinable;

public class Geometric extends Progression implements Combinable{

	private double commonFactor; 
	
	public Geometric(double firstValue, double commonFactor) { 
		super(firstValue); 
		this.commonFactor = commonFactor; 
	}
	
	@Override
	public double nextValue() {
		if(!isFirstExecuted()){
			throw new IllegalStateException("FirstValue() was not executed.");
		}
		current = current * commonFactor; 
		return current;
	}

	@Override
	public String toString(){		
		return "Geom(" + this.firstValue() + ", " + this.commonFactor+ ")";
	}
	
	@Override
	public double getTerm(int n) throws InvalidIndexException{
		if (n <= 0) 
			throw new IndexOutOfBoundsException("printAllTerms: Invalid argument value = " + n);
		
		return firstValue()*Math.pow(commonFactor, n-1);
	}
	
	@Override
	public boolean equals(Progression p) {
		return (firstValue() == p.firstValue() && commonFactor == p.getTerm(2) - p.firstValue());
	}
	
	@Override
	public Progression add(Progression other) {
		Progression sumP = new Geometric(firstValue() + other.firstValue(), commonFactor + (other.getTerm(2) - other.firstValue()));
		return sumP;
	}

	@Override
	public Progression subtract(Progression other) {
		Progression substractP = new Geometric(firstValue() - other.firstValue(), commonFactor - (other.getTerm(2) - other.firstValue()));
		return substractP;
	}
}
