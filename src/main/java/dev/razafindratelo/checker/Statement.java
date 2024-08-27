package dev.razafindratelo.checker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class Statement {
    private String statement;
    private TruthValue value;

    public Statement(String statement, TruthValue value) {
        this.statement = statement;
        this.value = value;
    }

    public Statement(String statement) {
        this.statement = statement;
        this.value = TruthValue.UNKNOWN;
    }

    public Statement and(Statement statement) {
        if (this.statement != null) {
            if (this.value != statement.getValue()) {
                if (this.value == TruthValue.TRUE && statement.getValue() == TruthValue.FALSE
                    || this.value == TruthValue.FALSE && statement.getValue() == TruthValue.TRUE) {
                    return new Statement("result", TruthValue.FALSE);
                } else {
                    return new Statement("result", TruthValue.UNKNOWN);
                }
            }
        }
        return null;
    }

    public Statement or(Statement statement) {
        if (this.statement != null) {
            if (this.value != TruthValue.UNKNOWN && statement.getValue() != TruthValue.UNKNOWN) {
                if (this.value == TruthValue.TRUE || statement.getValue() == TruthValue.TRUE) {
                    return new Statement("result", TruthValue.TRUE);
                } else if (this.value == TruthValue.FALSE || statement.getValue() == TruthValue.FALSE) {
                    return new Statement("result", TruthValue.FALSE);
                }
            } else if (this.value == TruthValue.TRUE || statement.getValue() == TruthValue.TRUE) {
                return new Statement("result", TruthValue.TRUE);
            } else {
                return new Statement("result", TruthValue.UNKNOWN);
            }
        }
        return null;
    }

    public Statement then(Statement statement) {
        if (this.statement != null) {
            if (this.value != TruthValue.UNKNOWN && statement.getValue() != TruthValue.UNKNOWN) {
                if (this.value == TruthValue.TRUE && statement.getValue() == TruthValue.FALSE) {
                    return new Statement("result", TruthValue.FALSE);
                } else if (this.value == TruthValue.FALSE && statement.getValue() == TruthValue.FALSE){
                    return new Statement("result", TruthValue.TRUE);
                } else {
                    return new Statement("result", TruthValue.TRUE);
                }
            } else {
                return new Statement("result", TruthValue.UNKNOWN);
            }
        }
        return null;
    }

    public TruthValue apply() {
        return this.value;
    }
}
