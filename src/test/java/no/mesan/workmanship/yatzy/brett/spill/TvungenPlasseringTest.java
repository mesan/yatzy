package no.mesan.workmanship.yatzy.brett.spill;

import static org.junit.Assert.*;
import org.junit.Test;

import no.mesan.workmanship.yatzy.brett.spill.Bonus;
import no.mesan.workmanship.yatzy.brett.spill.TvungenPlassering;
import no.mesan.workmanship.yatzy.domene.TestKast;
import no.mesan.workmanship.yatzy.domene.YatzyBrett;

import static no.mesan.workmanship.yatzy.domene.TestTerning.*;
import static no.mesan.workmanship.yatzy.domene.Yatzykombinasjon.*;

public class TvungenPlasseringTest {
    private static final TestKast KAST= new TestKast(_1, _2, _3, _4, _5);

    @Test
    public void sekvensAvKast() {
        final YatzyBrett yatzyBrett= new YatzyBrett(Bonus.TVUNGEN);
        final TvungenPlassering plassering= new TvungenPlassering();
        assertEquals(ENERE, plassering.velgPlassering(yatzyBrett, KAST));
        yatzyBrett.settPoeng(ENERE, KAST);
        assertEquals(TOERE, plassering.velgPlassering(yatzyBrett, KAST));
        yatzyBrett.settPoeng(TOERE, KAST);
        assertEquals(TREERE, plassering.velgPlassering(yatzyBrett, KAST));
        yatzyBrett.settPoeng(TREERE, KAST);
        yatzyBrett.settPoeng(FIRERE, KAST);
        yatzyBrett.settPoeng(FEMMERE, KAST);
        yatzyBrett.settPoeng(SEKSERE, KAST);
        yatzyBrett.settPoeng(PAR, KAST);
        yatzyBrett.settPoeng(TRE_LIKE, KAST);
        yatzyBrett.settPoeng(FIRE_LIKE, KAST);
        yatzyBrett.settPoeng(TO_PAR, KAST);
        assertEquals(LITEN_STRAIGHT, plassering.velgPlassering(yatzyBrett, KAST));
    }
}
