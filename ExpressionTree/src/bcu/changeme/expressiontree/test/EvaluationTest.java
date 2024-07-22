package bcu.changeme.expressiontree.test;

import bcu.changeme.expressiontree.*;

import org.junit.Test; 
import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.Map;
 
public class EvaluationTest {
	@Test
	public void testConstant() {
		Expression expr = new Constant(3.0);
		
		assertEquals(3.0, expr.evaluate(), 0.0);
	}
	
	@Test
	public void testVariable() {
		Expression expr = new Variable("x");
		Map<String, Double> map = Collections.singletonMap("x", 3.0);
		
		assertEquals(3.0, expr.evaluate(map), 0.0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testVariableNotAssigned() {
		new Variable("x").evaluate();
	}
	
	@Test
	public void testAddition() {
		Expression expr = new Addition(
			new Constant(1.0),
			new Constant(2.0)
		);
		
		assertEquals(3.0, expr.evaluate(), 0.0);
	}
	
	@Test
	public void testSubtraction() {
		Expression expr = new Subtraction(
			new Constant(8.0),
			new Constant(3.0)
		);
		
		assertEquals(5.0, expr.evaluate(), 0.0);
	}
	
	@Test
	public void testMultiplication() {
		Expression expr = new Multiplication(
			new Constant(8.0),
			new Constant(3.0)
		);
		
		assertEquals(24.0, expr.evaluate(), 0.0);
	}
	
	@Test
	public void testDivision() {
		Expression expr = new Division(
			new Constant(10.0),
			new Constant(4.0)
		);
		
		assertEquals(2.5, expr.evaluate(), 0.0);
	}
	
	@Test
	public void testSquareRoot() {
		Expression expr = new SquareRoot(
			new Constant(9.0)
		);
		
		assertEquals(3.0, expr.evaluate(), 0.0);
	}
}



