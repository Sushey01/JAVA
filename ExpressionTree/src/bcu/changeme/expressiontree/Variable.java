package bcu.changeme.expressiontree;

import java.util.Collections;
import java.util.Map;
import java.util.Set;



public class Variable extends Expression {
    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public double evaluate(Map<String, Double> variables) {
        if (variables.containsKey(name)) {
            return variables.get(name);
        }
        throw new IllegalArgumentException("Variable " + name + " not assigned a value.");
    }

    @Override
    public Set<String> freeVariables() {
        return Collections.singleton(name); // Singleton set is already unmodifiable
    }
}



