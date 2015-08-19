package no.mesan.workmanship.yatzy.brett.spill;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import no.mesan.workmanship.yatzy.brett.Plassering;
import no.mesan.workmanship.yatzy.brett.spill.Bonus;
import no.mesan.workmanship.yatzy.brett.spill.FlestPoengPlassering;
import no.mesan.workmanship.yatzy.domene.TestKast;
import no.mesan.workmanship.yatzy.domene.YatzyBrett;
import no.mesan.workmanship.yatzy.domene.Yatzykombinasjon;

import static org.junit.Assert.*;

import static no.mesan.workmanship.yatzy.domene.TestTerning.*;
import static no.mesan.workmanship.yatzy.domene.Yatzykombinasjon.*;

public class FlestPoengPlasseringTest {
    Plassering plassering;
    YatzyBrett yatzyBrett;

    @Before
    public void setup() {
        this.plassering= new FlestPoengPlassering();
        this.yatzyBrett= new YatzyBrett(Bonus.ORDINAR);
    }

    private static final TestKast TESTYATZY= new TestKast(_2, _2, _2, _2, _2);
    @Test
    public void valg_for_yatzy() {
        final Yatzykombinasjon type0= this.plassering.velgPlassering(this.yatzyBrett, TESTYATZY);
        assertEquals(YATZY, type0);
        this.yatzyBrett.settPoeng(YATZY, TESTYATZY);
        final Set<Yatzykombinasjon> mulige= new HashSet<>();
        // 10 poeng
        for (int i= 0; i < 3; i++) {
            final Yatzykombinasjon yatzykombinasjon= this.plassering.velgPlassering(this.yatzyBrett, TESTYATZY);
            mulige.add(yatzykombinasjon);
            this.yatzyBrett.settPoeng(yatzykombinasjon, TESTYATZY);
        }
        assertTrue(TOERE.toString(), mulige.contains(TOERE));
        assertTrue(HUS.toString(), mulige.contains(HUS));
        assertTrue(SJANSE.toString(), mulige.contains(SJANSE));
        // 8 poeng
        mulige.clear();
        for (int i= 0; i < 2; i++) {
            final Yatzykombinasjon yatzykombinasjon= this.plassering.velgPlassering(this.yatzyBrett, TESTYATZY);
            mulige.add(yatzykombinasjon);
            this.yatzyBrett.settPoeng(yatzykombinasjon, TESTYATZY);
        }
        assertTrue(TO_PAR.toString(), mulige.contains(TO_PAR));
        assertTrue(FIRE_LIKE.toString(), mulige.contains(FIRE_LIKE));
        // 6 poeng
        mulige.clear();
        for (int i= 0; i < 1; i++) {
            final Yatzykombinasjon yatzykombinasjon= this.plassering.velgPlassering(this.yatzyBrett, TESTYATZY);
            mulige.add(yatzykombinasjon);
            this.yatzyBrett.settPoeng(yatzykombinasjon, TESTYATZY);
        }
        assertTrue(TRE_LIKE.toString(), mulige.contains(TRE_LIKE));
        // 4 poeng
        mulige.clear();
        for (int i= 0; i < 1; i++) {
            final Yatzykombinasjon yatzykombinasjon= this.plassering.velgPlassering(this.yatzyBrett, TESTYATZY);
            mulige.add(yatzykombinasjon);
            this.yatzyBrett.settPoeng(yatzykombinasjon, TESTYATZY);
        }
        assertTrue(PAR.toString(), mulige.contains(PAR));
    }

    private static final TestKast TESTHUS= new TestKast(_2, _3, _3, _2, _2);
    @Test
    public void valg_for_hus() {
        final Set<Yatzykombinasjon> mulige= new HashSet<>();
        // 12 poeng
        for (int i= 0; i < 2; i++) {
            final Yatzykombinasjon yatzykombinasjon= this.plassering.velgPlassering(this.yatzyBrett, TESTHUS);
            mulige.add(yatzykombinasjon);
            this.yatzyBrett.settPoeng(yatzykombinasjon, TESTHUS);
        }
        assertTrue(HUS.toString(), mulige.contains(HUS));
        assertTrue(SJANSE.toString(), mulige.contains(SJANSE));
        // 6 poeng
        mulige.clear();
        for (int i= 0; i < 5; i++) {
            final Yatzykombinasjon yatzykombinasjon= this.plassering.velgPlassering(this.yatzyBrett, TESTHUS);
            mulige.add(yatzykombinasjon);
            this.yatzyBrett.settPoeng(yatzykombinasjon, TESTHUS);
        }
        assertTrue(TO_PAR.toString(), mulige.contains(TO_PAR));
        assertTrue(TRE_LIKE.toString(), mulige.contains(TRE_LIKE));
        assertTrue(PAR.toString(), mulige.contains(PAR));
        assertTrue(TOERE.toString(), mulige.contains(TOERE));
        assertTrue(TREERE.toString(), mulige.contains(TREERE));
    }

    private static final TestKast TESTLITEN= new TestKast(_1, _2, _3, _4, _5);
    @Test
    public void valg_for_straight() {
        final Set<Yatzykombinasjon> mulige= new HashSet<>();
        // 15 poeng
        for (int i= 0; i < 2; i++) {
            final Yatzykombinasjon yatzykombinasjon= this.plassering.velgPlassering(this.yatzyBrett, TESTLITEN);
            mulige.add(yatzykombinasjon);
            this.yatzyBrett.settPoeng(yatzykombinasjon, TESTLITEN);
        }
        assertTrue(LITEN_STRAIGHT.toString(), mulige.contains(LITEN_STRAIGHT));
        assertTrue(SJANSE.toString(), mulige.contains(SJANSE));
        // 6 poeng
        mulige.clear();
        for (int i= 0; i < 5; i++) {
            final Yatzykombinasjon yatzykombinasjon= this.plassering.velgPlassering(this.yatzyBrett, TESTLITEN);
            mulige.add(yatzykombinasjon);
            this.yatzyBrett.settPoeng(yatzykombinasjon, TESTLITEN);
        }
        assertTrue(FEMMERE.toString(), mulige.contains(FEMMERE));
        assertTrue(FIRERE.toString(), mulige.contains(FIRERE));
        assertTrue(TREERE.toString(), mulige.contains(TREERE));
        assertTrue(TOERE.toString(), mulige.contains(TOERE));
        assertTrue(ENERE.toString(), mulige.contains(ENERE));
    }

    private static final TestKast TESTSKROT= new TestKast(_1, _2, _3, _4, _6);
    @Test
    public void valg_for_skrot() {
        final Set<Yatzykombinasjon> mulige= new HashSet<>();
        for (int i= 0; i < 6; i++) {
            final Yatzykombinasjon yatzykombinasjon= this.plassering.velgPlassering(this.yatzyBrett, TESTSKROT);
            mulige.add(yatzykombinasjon);
            this.yatzyBrett.settPoeng(yatzykombinasjon, TESTSKROT);
        }
        assertTrue(SJANSE.toString(), mulige.contains(SJANSE));
        assertTrue(SEKSERE.toString(), mulige.contains(SEKSERE));
        assertTrue(FIRERE.toString(), mulige.contains(FIRERE));
        assertTrue(TREERE.toString(), mulige.contains(TREERE));
        assertTrue(TOERE.toString(), mulige.contains(TOERE));
        assertTrue(ENERE.toString(), mulige.contains(ENERE));
    }
}
