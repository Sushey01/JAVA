package bcu.changeme.expressiontree;

import java.util.*; 

public abstract class Expression {
	/*
	 * Evaluates this expression, assuming it has no free variables.
	 */ 
	public double evaluate() {
		return evaluate(Collections.emptyMap());
	}
	
	/*
	 * Evaluates this expression, using the given variable assignments.
	 */
	public abstract double evaluate(Map<String, Double> variables);
	
	/*
	 * Returns an unmodifiable set containing the names of all free variables
	 * in this expression.
	 */
	public abstract Set<String> freeVariables();
}


