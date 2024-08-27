import dev.razafindratelo.checker.FalseTautology;
import dev.razafindratelo.checker.Statement;
import dev.razafindratelo.checker.TrueTautology;
import dev.razafindratelo.checker.TruthValue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestForRatiocinator {
    @Test
    void lou_is_handsome() {
        var lou_is_handsome = new TrueTautology("Lou is handsome");
        Assertions.assertEquals(TruthValue.TRUE, lou_is_handsome.apply());
    }

    @Test
    void lou_is_poor() {
        var lou_is_poor = new FalseTautology("Lou is poor");
        Assertions.assertEquals(TruthValue.FALSE, lou_is_poor.apply());
    }

    @Test
    void lou_is_generous() {
        var lou_is_generous = new Statement("Lou is generous");
        Assertions.assertEquals(TruthValue.UNKNOWN, lou_is_generous.apply());
    }

    @Test
    void lou_is_poor_AND_lou_is_generous() {
        var lou_is_poor = new FalseTautology("Lou is poor");
        var lou_is_generous = new Statement("Lou is generous");

        Assertions.assertEquals(TruthValue.UNKNOWN, lou_is_poor.and(lou_is_generous).apply());
    }

    @Test
    void lou_is_handsome_SO_lou_is_poor() {
        var lou_is_handsome = new TrueTautology("Lou is handsome");
        var lou_is_poor = new FalseTautology("Lou is poor");

        Assertions.assertEquals(TruthValue.FALSE, lou_is_handsome.then(lou_is_poor).apply());
    }

    @Test
    void lou_is_poor_SO_lou_is_generous() {
        var lou_is_poor = new FalseTautology("Lou is poor");
        var lou_is_generous = new Statement("Lou is generous");

        Assertions.assertEquals(TruthValue.UNKNOWN, lou_is_poor.then(lou_is_generous).apply());
    }

    @Test
    void lou_is_handsome_OR_lou_is_generous_SO_lou_is_poor() {
        var lou_is_handsome = new TrueTautology("Lou is handsome");
        var lou_is_generous = new Statement("Lou is generous");
        var lou_is_poor = new FalseTautology("Lou is poor");


        Assertions.assertEquals(TruthValue.FALSE, lou_is_handsome.or(lou_is_generous).then(lou_is_poor).apply());
    }

    @Test
    void lou_is_poor_OR_lou_is_generous() {
        var lou_is_generous = new Statement("Lou is generous");
        var lou_is_poor = new FalseTautology("Lou is poor");

        Assertions.assertEquals(TruthValue.UNKNOWN, lou_is_poor.or(lou_is_generous).apply());
    }
}
