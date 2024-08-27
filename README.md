#   Calculus Ratiocinator

This repository contains an algorithm of the `Calculus Ratiocinator`.

## About the algorithm :

The algorithm consists on taking the truth value of an assertion and compute the truth value when combined with other 
statements with all boolean operators like `p or q`, `p and q`, `(not p) or q` or commonly known as `then` or `so`
(`p => q`) in our current 
language.

### About the assertions packages :

#### Statement :

This class is the mother class of all assertions. It may have `true`, `false` as truth value, but more specifically, it
may be also `unknown` (neither true, nor false). 
[the law of noncontradiction is not handled here as in Boolean algebra or Boolean logic].

A statement can be composed to other statement with `or`, `and` and `then`. Then, you can check the boolean value 
the combined statement by using the method named `apply` to see whether it is `TRUE` or `FALSE` or `UNKNOWN`.

When a statement is created without precising its truth value, it will be by default `UNKNOWN`.

#### FalseTautology :

This class is a kind of statement in which the truth value is always false.

#### TrueTautology :

This class is a kind of statement in which the truth value is always true.


### Example :

    var lou_is_handsome = new TrueTautology("Lou is handsome");

When applying `apply` method to that TrueTautology, it gives us `TRUE` as response because it is a true tautology.

    var lou_is_poor = new FalseTautology("Lou is poor");

The result of `lou_is_poor.apply()` here will be `FALSE` because, it is a false tautology 
which denote an assertion which truth value is always false.

    var lou_is_generous = new Statement("Lou is generous");

The result of `lou_is_generous.apply()` here will be `UNKNOWN` because no information tells us that this is true of false.

But,    

    var lou_is_generous = new Statement("Lou is generous", TruthValue.TRUE);

the result of `lou_is_generous.apply()` will be obviously `TRUE`.

### Combination example :

#### First example :

    var lou_is_handsome = new TrueTautology("Lou is handsome");
    var lou_is_generous = new Statement("Lou is generous");
    var lou_is_poor = new FalseTautology("Lou is poor");

    lou_is_handsome.or(lou_is_generous).then(lou_is_poor).apply()

The result will be `FALSE` : in fact, the value of `lou_is_handsome.or(lou_is_generous)` is `TRUE` 
because `lou_is_handome` is already true, so whatever the truth value of `lou_is_generous`, the `OR` conjunction
gives us the true value.

#### Second example :

    var lou_is_generous = new Statement("Lou is generous");
    var lou_is_poor = new FalseTautology("Lou is poor");
    lou_is_poor.or(lou_is_generous).apply()

The result will be `UNKNOWN` because even we clearly know that `lou_is_poor` is always false, 
the result depends on `lou_is_generouse`. Therefore, the result is `UNKNOWN`.