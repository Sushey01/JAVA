package bcu.changeme.expressiontree;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class SquareRoot extends Expression {
    private Expression operand;

    public SquareRoot(Expression operand) {
        this.operand = operand;
    }

    @Override
    public double evaluate(Map<String, Double> variables) {
        double operandValue = operand.evaluate(variables);
        if (operandValue < 0) {
            throw new ArithmeticException("Square root of negative number");
        }
        return Math.sqrt(operandValue);
    }

    @Override
    public Set<String> freeVariables() {
        return Collections.unmodifiableSet(operand.freeVariables());
    }
}


