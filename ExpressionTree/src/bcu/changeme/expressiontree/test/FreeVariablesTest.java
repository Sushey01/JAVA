package bcu.changeme.expressiontree.test;

import bcu.changeme.expressiontree.*;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
 
import java.util.*; 

public class FreeVariablesTest {
	@Test
	public void testConstant() {
		Expression expr = new Constant(1.0);
		
		assertEquals(Collections.emptySet(), expr.freeVariables());
	}
	
	@Test
	public void testVariable() {
		Expression expr = new Variable("x");
		
		assertEquals(Collections.singleton("x"), expr.freeVariables());
	}
	
	@Test
	public void testAddition() {
		Expression expr = new Addition(
			new Variable("x"),
			new Variable("y")
		);
		
		Set<String> expected = new HashSet<>();
		expected.add("x");
		expected.add("y");
		
		assertEquals(expected, expr.freeVariables());
	}
	
	@Test
	public void testSquareRoot() {
		Expression expr = new SquareRoot(
			new Variable("x")
		);
		
		assertEquals(Collections.singleton("x"), expr.freeVariables());
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testConstantUnmodifiable() {
		Expression expr = new Constant(1.0);
		
		expr.freeVariables().add("z");
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testVariableUnmodifiable() {
		Expression expr = new Variable("x");
		
		expr.freeVariables().add("z");
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testAdditionUnmodifiable() {
		Expression expr = new Addition(
			new Variable("x"),
			new Variable("y")
		);
		
		expr.freeVariables().add("z");
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testSquareRootUnmodifiable() {
		Expression expr = new SquareRoot(
			new Variable("x")
		);
		
		expr.freeVariables().add("z");
	}
}

