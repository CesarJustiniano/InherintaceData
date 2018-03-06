package orderedStructures;

public class Fibonacci extends Progression {

	private double prev; 
	
	public Fibonacci() { 
		this(1); 
		prev = 0; 
	}
	public Fibonacci(double first) {
		super(first);
	}

	@Override
	public double nextValue() {
        // add the necessary code here
		//...
		if(!isFirstExecuted()){
			throw new IllegalStateException("FirstValue() was not executed.");
		}
		current += prev;
		prev = current - prev;
		
		return current;
	}
	
	@Override	
	public double firstValue() { 
		double value = super.firstValue(); 
		prev = 0; 
		return value; 
	}

	@Override
	public String toString(){		
		return "Fibonacci(" + this.firstValue() + ")";
	}
	
	@Override
	public boolean equals(Progression p) {
		return (firstValue() == p.firstValue());
	}
}
