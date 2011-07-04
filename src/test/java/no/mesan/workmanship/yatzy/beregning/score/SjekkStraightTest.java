package no.mesan.workmanship.yatzy.beregning.score;

import org.junit.Test;

import no.mesan.workmanship.yatzy.beregning.score.SjekkStraight;
import no.mesan.workmanship.yatzy.domene.Straights;
import no.mesan.workmanship.yatzy.domene.TestKast;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import static no.mesan.workmanship.yatzy.domene.TestTerning.*;

public class SjekkStraightTest {
    private static final TestKast LITEN_STRAIGHT= new TestKast(_1, _2, _3, _4, _5);
    private static final TestKast STOR_STRAIGHT= new TestKast(_6, _2, _3, _4, _5);
    private static final TestKast HUS= new TestKast(_2, _3, _3, _2, _2);
    private static final TestKast YATZY= new TestKast(_2, _2, _2, _2, _2);

    @Test
    public void liten_er_liten() {
        assertTrue(SjekkStraight.sjekk(Straights.LITEN, LITEN_STRAIGHT));
    }

    @Test
    public void liten_er_ikke_stor() {
        assertFalse(SjekkStraight.sjekk(Straights.STOR, LITEN_STRAIGHT));
    }

    @Test
    public void stor_er_stor() {
        assertTrue(SjekkStraight.sjekk(Straights.STOR, STOR_STRAIGHT));
    }

    @Test
    public void stor_er_ikke_liten() {
        assertFalse(SjekkStraight.sjekk(Straights.LITEN, STOR_STRAIGHT));
    }

    @Test
    public void hus_er_ikke_straight() {
        assertFalse(SjekkStraight.sjekk(Straights.LITEN, HUS));
        assertFalse(SjekkStraight.sjekk(Straights.STOR, HUS));
    }
}
