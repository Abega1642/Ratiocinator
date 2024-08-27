package dev.razafindratelo.assertions;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class FalseTautology extends Statement{

    public FalseTautology(String statement) {
        super(statement, TruthValue.FALSE);
    }
}
