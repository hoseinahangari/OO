package main.expression;

import main.expression.literal.Value;
import main.expression.literal.Variable;

import java.util.*;

public abstract class Expression {
    Set<Variable> variables = new HashSet<>();

    public void addToVariables(Variable variable){
        variables.add(variable);
    }

    public Set<Variable> getVariables() {
        return variables;
    }

    public void setVariables(Set<Variable> variables) {
        this.variables = variables;
    }

    public  Expression eval(Variable variable, Double d){
        Value value = new Value(d);
        variables.stream()
                .filter(variable1 -> variable1.getName()==variable.getName())
                .forEach(item -> item.setValue(value));
        return this;
    }

    public abstract Double eval();

    public abstract Expression derive(Variable variable);
}
