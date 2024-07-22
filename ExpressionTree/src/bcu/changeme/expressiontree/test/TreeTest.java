package bcu.changeme.expressiontree.test;

import bcu.changeme.expressiontree.*;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.*;
 
public class TreeTest {
	// (5 * square root x) + ((y - z) / x)
	private final Expression expr = new Addition(
		new Multiplication(
			new Constant(5.0),
			new SquareRoot( 
				new Variable("x")
			)
		),
		new Division(
			new Subtraction(
				new Variable("y"),
				new Variable("z")
			),
			new Variable("x")
		)
	);
	
	@Test
	public void testEvaluate() {
		Map<String, Double> map = new HashMap<>();
		map.put("x", 16.0);
		map.put("y", 12.0);
		map.put("z", 8.0);
		
		assertEquals(20.25, expr.evaluate(map), 0.5e-10);
	}
	
	@Test
	public void testFreeVariables() {
		Set<String> expected = new HashSet<>();
		expected.add("x");
		expected.add("y");
		expected.add("z");
		
		assertEquals(expected, expr.freeVariables());
	}
}
