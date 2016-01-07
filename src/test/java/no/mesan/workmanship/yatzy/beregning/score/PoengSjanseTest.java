package no.mesan.workmanship.yatzy.beregning.score;

import no.mesan.workmanship.yatzy.domene.Poeng;
import no.mesan.workmanship.yatzy.domene.TestKast;
import org.junit.Test;

import static no.mesan.workmanship.yatzy.domene.TestTerning.*;
import static org.junit.Assert.assertEquals;

public class PoengSjanseTest {
    private static final TestKast STRAIGHT= new TestKast(_1, _2, _3, _4, _5);
    private static final TestKast HUS= new TestKast(_2, _3, _3, _2, _2);
    private static final TestKast YATZY= new TestKast(_2, _2, _2, _2, _2);

    @Test
    public void testLitt() {
        assertEquals(new Poeng(15), PoengUnderStreken.P_SJANSE.beregnPoengForKast(STRAIGHT));
        assertEquals(new Poeng(12), PoengUnderStreken.P_SJANSE.beregnPoengForKast(HUS));
        assertEquals(new Poeng(10), PoengUnderStreken.P_SJANSE.beregnPoengForKast(YATZY));
    }
}
