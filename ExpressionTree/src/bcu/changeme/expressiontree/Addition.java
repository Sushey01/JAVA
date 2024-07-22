package bcu.changeme.expressiontree;


public class Addition extends BinaryOperation {
    public Addition(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double evaluate(double a, double b) {
        return a + b;
    }
}


