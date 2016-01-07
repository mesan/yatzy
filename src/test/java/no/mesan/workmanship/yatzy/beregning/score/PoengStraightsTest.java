package no.mesan.workmanship.yatzy.beregning.score;

import no.mesan.workmanship.yatzy.domene.Poeng;
import no.mesan.workmanship.yatzy.domene.TestKast;
import no.mesan.workmanship.yatzy.poeng.SpesialPoeng;
import org.junit.Test;

import static no.mesan.workmanship.yatzy.domene.TestTerning.*;
import static org.junit.Assert.assertEquals;

public class PoengStraightsTest {
    private static final TestKast LITEN_STRAIGHT= new TestKast(_1, _2, _3, _4, _5);
    private static final TestKast STOR_STRAIGHT= new TestKast(_6, _2, _3, _4, _5);
    private static final TestKast HUS= new TestKast(_2, _3, _3, _2, _2);
    private static final TestKast YATZY= new TestKast(_2, _2, _2, _2, _2);

    @Test
    public void liten() {
        assertEquals(SpesialPoeng.LITEN_STRAIGHT_POENG.poeng,
                     PoengUnderStreken.P_LITEN_STRAIGHT.beregnPoengForKast(LITEN_STRAIGHT));
    }

    @Test
    public void stor() {
        assertEquals(SpesialPoeng.STOR_STRAIGHT_POENG.poeng,
                     PoengUnderStreken.P_STOR_STRAIGHT.beregnPoengForKast(STOR_STRAIGHT));
    }

    @Test
    public void ikke_stor_eller_liten() {
        assertEquals(Poeng.NULL_POENG, PoengUnderStreken.P_STOR_STRAIGHT.beregnPoengForKast(HUS));
        assertEquals(Poeng.NULL_POENG, PoengUnderStreken.P_LITEN_STRAIGHT.beregnPoengForKast(HUS));
    }

    @Test
    public void ikke_omvendt() {
        assertEquals(Poeng.NULL_POENG, PoengUnderStreken.P_STOR_STRAIGHT.beregnPoengForKast(LITEN_STRAIGHT));
        assertEquals(Poeng.NULL_POENG, PoengUnderStreken.P_LITEN_STRAIGHT.beregnPoengForKast(STOR_STRAIGHT));
    }
}
