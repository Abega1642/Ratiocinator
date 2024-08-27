package dev.razafindratelo;

import dev.razafindratelo.checker.FalseTautology;
import dev.razafindratelo.checker.Statement;
import dev.razafindratelo.checker.TrueTautology;
import dev.razafindratelo.checker.TruthValue;


public class Main {
    public static void main(String[] args) {
        Statement state_1 = new Statement("Lou is poor", TruthValue.FALSE);
        Statement state_2 = new Statement("Lou is rich", TruthValue.TRUE);
        Statement state_3 = new Statement("Lou is handsome");
        TrueTautology truth_1 = new TrueTautology("Math is good");
        FalseTautology false_1 = new FalseTautology("Math is bad");

        System.out.println("LLou is poor et Lou is rich : " + state_1.and(state_2).getValue());
        System.out.println("Lou is poor et LLou is handsome : " + state_1.and(state_3).getValue());
        System.out.println("Lou is poor ou Lou is rich : " + state_1.or(state_2).getValue());
        System.out.println("Lou is poor ou Lou is handsome : " + state_1.or(state_3).getValue());

        System.out.println("Math is good so math is bad : " + truth_1.then(false_1).getValue());
        System.out.println("Lou is poor then Lou is handsome : " + state_1.then(state_3).getValue());
        System.out.println("Lou is poor then Math is bad : " + truth_1.then(false_1).getValue());
        System.out.println("LLou is poor then Math is good :" + state_1.then(truth_1).getValue());
        System.out.println("Math is good so math is bad : " + truth_1.then(false_1).getValue());

        System.out.println("Math is good so math is bad or Lou is rich :" + truth_1.then(false_1).or(state_2).getValue());


    }
}