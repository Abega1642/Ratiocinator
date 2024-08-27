package dev.razafindratelo.checker;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TrueTautology extends Statement {

    public TrueTautology(String statement) {
        super(statement, TruthValue.TRUE);
    }
}
