package bcu.changeme.expressiontree;

public class Subtraction extends BinaryOperation {
    public Subtraction(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double evaluate(double a, double b) {
        return a - b;
    }
}


